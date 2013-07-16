package dart 
{
	import flash.display.*;
	import flash.events.*;
	import flash.net.*;
	import flash.text.*;
	import flash.utils.*;

[SWF(width="1200",height="800",backgroundColor="#000000", frameRate="30")]
	public class reason extends Sprite
	{
		private var loader:URLLoader = new URLLoader();
		private var a:Array = new Array();
		public var d:Array = new Array();
		public var na:String = "";
		public var level:int = 0;
		public var l:int;
		
		public function reason(result:String)
		{			
			//var a:arrow = new arrow(0xaa4433,"hello",250,220,200,230,2);
			//this.addChild(a);
            //var r:round = new round(1193046,"sadfasdrld",600,400,25);
            //this.addChild(r);
            //var l:line = new line(0x4499aa, 100, 200, 200, 100, 10);
            //this.addChild(l);
            //background();
            this.l = -1;
            ini(result);
            
		}
		
		private function ini(result:String):void
		{
			var xml:XML = XML(result);
			var list:XMLList = xml.Objects.elements();
			this.level = list.length();
			for(var i:int = 0; i < this.level; ++i)
			{
			
				for (var j:int = 0; j < list[i].children().length(); ++j)
				{
					var cx:Number = i * 200 + 20;
					var cy:Number = 200 + ((j + 1) - (1  +  list[i].children().length()) / 2) * 80;
					var flag:Boolean = false;
					/*if (i == 0)
					{
						var r:round = new round(0x00ff00, 0x33cc00, list[i].children()[j].text, cx, cy, 20, 0xffffff, 20);
						flag = true;
					}
					else if (i == 1)
					{
						var r:round = new round(0xee6513, 0x672cd6, list[i].children()[j].text, cx, cy, 20, 0xffffff, 20);
					}
					else
					{
						var r:round = new round(0x8a998f, 0x000000, list[i].children()[j].text, cx, cy, 20, 0xffffff, 20);
					}*/
					if (list[i].children()[j].type == "证候")
					{
						var r:round = new round(0xee6513, 0x672cd6, list[i].children()[j].text, cx, cy, 30, 0x0000ff, 20);
						r.addEventListener(MouseEvent.CLICK, cl);
					}
					else
					{
						var r:round = new round(0x8a998f, 0x000000, list[i].children()[j].text, cx, cy, 30, 0x0000ff, 20);
						r.ifclick = true;
					}
					this.addChild(r);
					this.a.push({name:list[i].children()[j].text.toString(), cx:cx, cy:cy, type:list[i].children()[j].type.toString()});
				}
			} 	

		 	var arr:XMLList = xml.arrows.elements();
		 	for each(var element:XML in arr)
		 	{
		 		this.d.push({begin:element.begin.toString(), end:element.end.toString()});
		 	}
		 	for (var i:int = d.length - 1; i >= 0; --i)
			{
				var begin:int = findindex(d[i].begin.toString(), a);
				var end:int = findindex(d[i].end.toString(), a);
				var endx:Number;
				var endy:Number;
				if(a[begin].cx == a[end].cx)
				{
					endx = a[end].cx;
					endy = a[end].cy > a[begin].cy ? a[end].cy - 30 : a[end].cy + 30;
				}
				else if(a[begin].cy == a[end].cy)
				{
					endy = a[end].cy;
					endx = a[end].cx > a[begin].cx ? a[end].cx - 30 : a[end].cx + 30;
				}
				else
				{
					endx = a[end].cx - ( a[end].cx - a[begin].cx ) * 30 / Math.sqrt(Math.pow(a[end].cx - a[begin].cx, 2) + Math.pow(a[end].cy - a[begin].cy, 2));
					endy = a[end].cy - ( a[end].cy - a[begin].cy ) * 30 / Math.sqrt(Math.pow(a[end].cx - a[begin].cx, 2) + Math.pow(a[end].cy - a[begin].cy, 2));
				}
				var arrowcolor:uint;
				arrowcolor = 0xff0000;
				if (a[begin].type == "证候" && a[end].type == "证候")
				{
					var arro:arrow = new arrow(arrowcolor, "", a[begin].cx, a[begin].cy, endx, endy, 5, true);
					arro.addEventListener(MouseEvent.MOUSE_OVER, arrover);
					arro.addEventListener(MouseEvent.MOUSE_OUT, arrout);
				}
				else
				{
					var arro:arrow = new arrow(arrowcolor, "", a[begin].cx, a[begin].cy, endx, endy, 5, false);
				}
				this.addChildAt(arro, 0);
				
			}
		 	//draw(a, b, formula);
		}
		
		private function findindex(title:String, temp:Array):int
		{
			for (var i:int = 0; i < temp.length; ++i)
			{
				//trace(temp[i].title);
				
				if (temp[i].name == title)
					return i;
				else
					continue;
			}
			return -1;
		}
		
		private function cl(e:MouseEvent):void
		{
			/*if (e.target is flash.text.TextField)
			{
				this.na = e.target.text;
			}
			else
			{
				this.na = e.target.getString();
			}*/
			if (!e.currentTarget.ifclick)
			{
				this.na = e.currentTarget.getString();
				e.currentTarget.ifclick = true;
				e.currentTarget.change(0x00ff00, 0x33cc00);
				for (var i:int = this.numChildren - 1; i >= 0; --i)
				{
					if (this.getChildAt(i) is round)
					{
						var temp:round = this.getChildAt(i) as round;
						if (temp.getString() != this.na && temp.ifclick && this.a[findindex(temp.getString(),a)].type == "证候")
						{
							temp.ifclick = false;
							temp.change(0xee6513, 0x672cd6);
							break;
						}
					} 
				}
			}	
			
			trace(this.na)
		}
		
		private function arrover(e:MouseEvent):void
		{
			l = this.getChildIndex(e.currentTarget as DisplayObject);
		}
		
		private function arrout(e:MouseEvent):void
		{
			l = -1;
		}
		
		public function getarray():Array
		{
			var sarray:Array = new Array();
			
			sarray.push(d[l].begin);
			sarray.push(d[l].end);
			return sarray;
		}
	}
}
