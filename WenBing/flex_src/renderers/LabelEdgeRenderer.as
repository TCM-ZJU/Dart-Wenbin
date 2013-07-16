package renderers
{
	import com.adobe.flex.extras.controls.springgraph.Graph;
	import com.adobe.flex.extras.controls.springgraph.IEdgeRenderer;
	import com.adobe.flex.extras.controls.springgraph.Item;
	
	import flash.display.DisplayObjectContainer;
	import flash.display.Graphics;
	import flash.geom.Point;
	
	import mx.core.IDataRenderer;
	import mx.core.UIComponent;

	public class LabelEdgeRenderer implements IEdgeRenderer
	{
		private var labels:Array = new Array();
		private var vBoxs:Array = new Array();
		private var oldLabels:Array = new Array();
		private var oldVBoxs:Array = new Array();

		public function draw(g:Graphics, f:UIComponent, t:UIComponent, fromX:int, fromY:int, toX:int, toY:int, graph:Graph):Boolean
		{
			var fromItem:Item = (f as IDataRenderer).data as Item;
			var toItem:Item = (t as IDataRenderer).data as Item;
			var linkDatas:Array = graph.getLinkData(fromItem, toItem) as Array;

			var endPoints:Object = adjustPointsToEdge(fromX, fromY, toX, toY);
			
			if (linkDatas != null)
			{
				var isTwoWay:Boolean = checkIsTwoWay(linkDatas);
				if (isTwoWay)
				{
					drawTwoWay(g, fromItem, toItem, linkDatas, endPoints, f.parent);
				}
				else
				{
					if (linkDatas[0].fromID == toItem.id && linkDatas[0].toID == fromItem.id)
					{
						drawOneWay(g, toItem, fromItem, linkDatas, {fromX: endPoints.toX, fromY: endPoints.toY, toX: endPoints.fromX, toY: endPoints.fromY}, f.parent);
					}
					else
					{
						drawOneWay(g, fromItem, toItem, linkDatas, endPoints, f.parent);
					}
				}
			}
			return true;
		}
		
		private function drawOneWay(g:Graphics, fromItem:Item, toItem:Item, linkDatas:Array, endPoints:Object, container:DisplayObjectContainer):void
		{
			var vBox:EdgeLabelVBox = findVBox(fromItem.id, toItem.id, container);
			var hasManyLabels:Boolean = checkHasManyLabels(fromItem.id, toItem.id, linkDatas);
			var d:Object = null;
			var i:int;
			var len:int;
			var settings:Object;
			var alpha:Number = 1.0;
			var thickness:int = 1;
			var color:uint = 0x000000;
			var edgeLabel:String = "";	
			var label:EdgeLabel;
			var labelIndex:int;
			var p:Point;
			var r:Number;
			
			len = linkDatas.length;			
			for (i = 0; i < len; i++)
			{
				if (linkDatas[i].fromID == fromItem.id && linkDatas[i].toID == toItem.id)
				{
					d = linkDatas[i];
					if (d != null)
					{
						if (d.hasOwnProperty("data"))
						{
							settings = d.data;
							edgeLabel = settings.edgeLabel;				
							alpha = settings.alpha;
							thickness = settings.thickness;
							color = settings.color;
						}
						//查找edgeLabel，没找到则创建
						labelIndex = findLabelIndex(d.data);					
						if (labelIndex == -1)
						{
							label = new EdgeLabel();
							label.edgeData = d.data;
							label.text = edgeLabel;
							vBox.addChild(label);
							labels.push(label);
						}
						else
						{
							label = oldLabels[labelIndex] as EdgeLabel;
							labels.push(label);
							oldLabels.splice(labelIndex, 1);
						}
					}
					if (!hasManyLabels)
					{
						break;
					}
				}
			}
			if (hasManyLabels)
			{
				color = 0x000000;
			}
			g.lineStyle(thickness, color, alpha);
			g.moveTo(endPoints.fromX, endPoints.fromY);
			g.lineTo(endPoints.toX, endPoints.toY);
			drawArrow(g, thickness, endPoints.fromX, endPoints.fromY, endPoints.toX, endPoints.toY);
			p = computePoint(vBox.width, vBox.height, endPoints.fromX, endPoints.fromY, endPoints.toX, endPoints.toY);
			r = computeRotation(endPoints.fromX, endPoints.fromY, endPoints.toX, endPoints.toY);
			vBox.x = p.x;
			vBox.y = p.y;
			vBox.rotation = r;
		}
		
		private function drawTwoWay(g:Graphics, fromItem:Item, toItem:Item, linkDatas:Array, endPoints:Object, container:DisplayObjectContainer):void
		{
			var fromX:int = endPoints.fromX;
			var fromY:int = endPoints.fromY;
			var toX:int = endPoints.toX;
			var toY:int = endPoints.toY;
			var tan:Number;
			var radians:Number;
			var dx:Number;
			var dy:Number;
			var tempPoints:Object;
			
			//dx和dy是连线的端点向远离中心线的方向调整的距离
			if (fromX != toX)
			{
				tan = (toY - fromY)/(toX - fromX);
				radians = Math.atan(Math.abs(tan));
				dx = CircleLabelView.radius/3*Math.sin(radians);
				dy = CircleLabelView.radius/3*Math.cos(radians);
			}
			else
			{
				dx = CircleLabelView.radius/3;
				dy = 0;
			}
			tempPoints = adjustPointsToSide(fromX, fromY, toX, toY, dx, dy);
			drawOneWay(g, fromItem, toItem, linkDatas, tempPoints, container);
			tempPoints = adjustPointsToSide(toX, toY, fromX, fromY, dx, dy);
			drawOneWay(g, toItem, fromItem, linkDatas, tempPoints, container);
		}
		
		public function clearOld():void
		{
			var i:int;
			var len:int;
			len = oldLabels.length;
			if (len > 0)
			{
				var label:EdgeLabel;
				for (i = 0; i < len; i++)
				{
					label = oldLabels[i] as EdgeLabel;
					label.parent.removeChild(label);
				}
				oldLabels.splice(0, len);
			}
			
			len = oldVBoxs.length;
			if (len > 0)
			{
				var vBox:EdgeLabelVBox;
				for (i = 0; i < len; i++)
				{
					vBox = oldVBoxs[i] as EdgeLabelVBox;
					vBox.parent.removeChild(vBox);
				}
				oldVBoxs.splice(0, len);
			}
		}
		
		public function prepareDraw():void
		{
			oldLabels = labels;
			oldVBoxs = vBoxs;
			labels = new Array();
			vBoxs = new Array();
		}
		
		private function drawArrow(g:Graphics, thickness:int, fromX:int, fromY:int, toX:int, toY:int):void
		{
			var k:Number = 0.3;
			var b:Number = 6;
			var x1:Number;
			var y1:Number;
			var x2:Number;
			var y2:Number;
			var dx:Number;
			var dy:Number;
			var radians:Number;
			
			if (fromY == toY)
			{
				dy = thickness*b*k - thickness;
				y1 = toY - dy;
				y2 = toY + thickness - 1 + dy;
				x1 = x2 = toX < fromX ? toX + thickness*b : toX - thickness*b;
			}
			else if(fromX == toX)
			{
				dx = thickness*b*k - thickness;
				x1 = toX - dx;
				x2 = toX + thickness - 1 + dx;
				y1 = y2 = toY < fromY ? toY + thickness*b : toY - thickness*b;
			}
			else
			{
				var r:Number = Math.PI/2 - Math.atan(Math.abs(toY - fromY)/Math.abs(toX - fromX));
				dx = thickness*b*k*Math.cos(r);
				dy = thickness*b*k*Math.sin(r);
				var cx:Number = fromX < toX ? toX - thickness*b*Math.sin(r) - thickness + 1 : toX + thickness*b*Math.sin(r);
				var cy:Number = fromY < toY ? toY - thickness*b*Math.cos(r) - thickness + 1 : toY + thickness*b*Math.cos(r);
				x1 = fromX < toX ? cx - dx : cx + thickness - 1 + dx;
				x2 = fromX < toX ? cx + thickness - 1 + dx : cx - dx;
				y1 = fromY < toY ? cy + thickness - 1 + dy : cy - dy;
				y2 = fromY < toY ? cy - dy : cy + thickness - 1 + dy;
			}
            g.moveTo(toX, toY);
            g.lineTo(x1, y1);
            g.moveTo(toX, toY);
            g.lineTo(x2, y2);
		}
		
		private function computePoint(uiWidth:Number, uiHeight:Number, fx:int, fy:int, tx:int, ty:int):Point
		{
			var px:Number;
			var py:Number;
			if (tx != fx)
			{
				var tan:Number = (ty - fy)/(tx - fx);
				var radians:Number = Math.atan(tan);
				var sin:Number = Math.sin(Math.abs(radians));
				var cos:Number = Math.cos(Math.abs(radians));
				var w:Number = uiWidth * cos;
				var h:Number = uiWidth * sin;
				if (tx > fx)
				{
					px = (tx - fx - w)/2 + fx;
					if (ty > fy)
					{
						py = fy + (ty - fy - h)/2;
					}
					else
					{
						py = fy - (fy - ty - h)/2;
					}
				}
				else if(tx < fx)
				{
					if (ty > fy)
					{
						px = (fx - tx - w)/2 + tx - sin*uiHeight;
						py = ty - (ty - fy - h)/2 - cos*uiHeight;
					}
					else
					{
						px = (fx - tx - w)/2 + tx + sin*uiHeight;
						py = ty + (fy - ty - h)/2 - cos*uiHeight;
					}
				}
				return new Point(px, py);				
			}
			else if(ty > fy)
			{
				return new Point(tx - uiHeight, ty - (ty - fy - uiWidth)/2);
			}
			else
			{
				return new Point(tx + uiHeight, ty + (fy - ty - uiWidth)/2);
			}
		}
		
		private function computeRotation(fx:int, fy:int, tx:int, ty:int):Number
		{
			if (tx != fx)
			{
				var tan:Number = (ty - fy)/(tx - fx);
				var radians:Number = Math.atan(tan);
				return radians * 180/Math.PI;
			}
			else if(ty > fy)
			{
				return -90;
			}
			else
			{
				return 90;
			}
		}
		
		private function adjustPointsToEdge(fromX:int, fromY:int, toX:int, toY:int):Object
		{
			//把端点调整到球体边缘
			var radians:Number;
			if (fromY == toY)
			{
				if (fromX < toX)
				{
					fromX += CircleLabelView.radius;
					toX -= CircleLabelView.radius;
				}
				else
				{
					fromX -= CircleLabelView.radius;
					toX += CircleLabelView.radius;
				}
			}
			else if (fromX == toX)
			{
				if (fromY < toY)
				{
					fromY += CircleLabelView.radius;
					toY -= CircleLabelView.radius;
				}
				else
				{
					fromY -= CircleLabelView.radius;
					toY += CircleLabelView.radius;
				}
			}
			else
			{
				radians = Math.atan(Math.abs(toY - fromY)/Math.abs(toX - fromX));
				var dx:Number = CircleLabelView.radius * Math.cos(radians);
				var dy:Number = CircleLabelView.radius * Math.sin(radians);
				if (fromX < toX)
				{
					fromX += dx;
					toX -= dx;
				}
				else
				{
					fromX -= dx;
					toX += dx;
				}
				if (fromY < toY)
				{
					fromY += dy;
					toY -= dy;
				}
				else
				{
					fromY -= dy;
					toY += dy;
				}
			}
			
			return {fromX: fromX, fromY: fromY, toX: toX, toY: toY};
		}
		
		private function adjustPointsToSide(fromX:int, fromY:int, toX:int, toY:int, dx:Number, dy:Number):Object
		{
			//向背离中心线方向调整端点，使两条线相隔一段距离
			var fx:int;
			var fy:int;
			var tx:int;
			var ty:int;
			if (toX > fromX && toY > fromY)
			{
				fx = fromX - dx;
				fy = fromY + dy;
				tx = toX - dx;
				ty = toY + dy;
			}
			else if (toX < fromX && toY < fromY)
			{
				fx = fromX + dx;
				fy = fromY - dy;
				tx = toX + dx;
				ty = toY - dy;
			}
			else if (toX > fromX && toY < fromY)
			{
				fx = fromX + dx;
				fy = fromY + dy;
				tx = toX + dx;
				ty = toY + dy;
			}
			else if (toX < fromX && toY > fromY)
			{
				fx = fromX - dx;
				fy = fromY - dy;
				tx = toX - dx;
				ty = toY - dy;
			}
			else if(toX == fromX && toY > fromY)
			{
				fx = fromX - dx;
				fy = fromY;
				tx = toX - dx;
				ty = toY;
			}
			else if(toX == fromX && toY < fromY)
			{
				fx = fromX + dx;
				fy = fromY;
				tx = toX + dx;
				ty = toY;
			}
			else if(toX > fromX && toY == fromY)
			{
				fx = fromX;
				fy = fromY + dy;
				tx = toX;
				ty = toY + dy;
			}
			else if(toX > fromX && toY == fromY)
			{
				fx = fromX;
				fy = fromY - dy;
				tx = toX;
				ty = toY - dy;
			}
			return {fromX: fx, fromY: fy, toX: tx, toY: ty};
		}
		
		private function findLabelIndex(d:Object):int
		{
			var i:int;
			for (i = 0; i < oldLabels.length; i++)
			{
				var label:EdgeLabel = oldLabels[i] as EdgeLabel;
				if (label.edgeData == d)
				{
					return i;
				}
			}
			return -1;
		}
		
		private function findVBoxIndex(fromID:String, toID:String):int
		{
			var i:int;
			var len:int = oldVBoxs.length;
			for (i = 0; i < len; i++)
			{
				var vBox:EdgeLabelVBox = oldVBoxs[i] as EdgeLabelVBox;
				if (vBox.fromID == fromID && vBox.toID == toID)
				{
					return i;
				}
			}
			return -1;
		}
		
		private function findVBox(fromID:String, toID:String, container:DisplayObjectContainer):EdgeLabelVBox
		{
			var vBoxIndex:int = findVBoxIndex(fromID, toID);
			var vBox:EdgeLabelVBox;
			if (vBoxIndex == -1)
			{
				vBox = new EdgeLabelVBox();
				vBox.fromID = fromID;
				vBox.toID = toID;
				container.addChild(vBox);
				vBoxs.push(vBox);
			}
			else
			{
				vBox = oldVBoxs[vBoxIndex] as EdgeLabelVBox;
				vBoxs.push(vBox);
				oldVBoxs.splice(vBoxIndex, 1);
			}
			return vBox;
		}
		
		private function checkIsTwoWay(linkDatas:Array):Boolean
		{
			var fromID:String;
			var toID:String;
			if (linkDatas)
			{
				var len:int = linkDatas.length;
				if (len > 0)
				{
					fromID = linkDatas[0].fromID;
					toID = linkDatas[0].toID;
				}
				for (var i:int = 1; i < len; i++)
				{
					if (fromID == linkDatas[i].toID && toID == linkDatas[i].fromID)
						return true;
				}
			}
			return false;
		}
		
		private function checkHasManyLabels(fromID:String, toID:String, linkDatas:Array):Boolean
		{
			var count:int = 0;
			for each (var d:Object in linkDatas)
			{
				if (d.fromID == fromID && d.toID == toID)
					count++;
				if (count > 1)
					return true;
			}
			return false;
		}
	}
}