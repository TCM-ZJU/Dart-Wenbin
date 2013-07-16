package dart
{
	import flash.display.Sprite;
	import flash.events.*;
	import flash.text.TextField;
	import flash.text.TextFormat;

	public class arrow extends Sprite
	{
		private var color:uint;
		private var colortemp:uint;
		public var tittle:TextField = new TextField();
		private var arrowObject:Sprite = new Sprite();
		private var xini:Number;
		private var yini:Number;
		private var xfin:Number;
		private var yfin:Number;
		private var thickness:Number;
		private var flag:Boolean;
		private var color2:uint;
		private var size:Number;
		public function arrow(color:uint, tittle:String, xini:Number, yini:Number,
		xfin:Number, yfin:Number, thickness:Number, flag:Boolean = true, color2:uint = 0x000000, size:Number = 10)
		{
			this.color = color;
			this.colortemp = color;
			this.tittle.text = tittle;
			this.xini = xini;
			this.yini = yini;
			this.xfin = xfin;
			this.yfin = yfin;
			this.thickness = thickness;
			this.flag = flag;
			this.color2 = color2;
			this.size = size;
			init();
		}
		
		public function init():void
		{
			var k:Number = 0.5;
			var l:Number = 10; 
			var k1:Number;
            var k2:Number;
            var k3:Number;
            var x2:Number; 
            var y2:Number; 
            var x3:Number; 
            var y3:Number;
            if(this.xfin == this.xini)
            {
            	x2 = this.xfin + k * Math.sqrt(Math.pow(l,2)/(Math.pow(k,2)+1));
            	x3 = this.xfin - k * Math.sqrt(Math.pow(l,2)/(Math.pow(k,2)+1)); 
            	y2 = y3 = this.yfin > this.yini ? this.yfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k,2)+1)):this.yfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k,2)+1)); 
            }
            else if(this.yfin == this.yini)
            {
            	y2 = this.yfin + k * Math.sqrt(Math.pow(l,2)/(Math.pow(k,2)+1));
            	y3 = this.yfin - k * Math.sqrt(Math.pow(l,2)/(Math.pow(k,2)+1));
            	x2 = x3 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k,2)+1)); 
            }
            else
            {
            	k1 = (this.yfin - this.yini)/(this.xfin - this.xini);
            	
            	if (k1 == k || k1 == -k)
            	{
            		x2 = this.xfin > this.xini ? this.xfin - l : this.xfin + l;
            		y2 = yfin;
            		k2 = (k1==k) ? (k + k1)/(1 - k * k1) : (k1 - k)/(1 + k * k1);
            		x3 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)); 
            		y3 = this.yfin > this.yini ? this.yfin - Math.abs(k2) * Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.yfin + Math.abs(k2) * Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)); 
            	}
            	else if(k1*k == 1 || k1*k == -1)
            	{
            		x2 = xfin;
            		y2 = this.yfin > this.yini ? yfin - l : yfin + l;
            		k2 = (k1*k == -1) ? (k + k1)/(1 - k * k1) : (k1 - k)/(1 + k * k1);
            		x3 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)); 
            		y3 = this.yfin > this.yini ? this.yfin - Math.abs(k2) * Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.yfin + Math.abs(k2) * Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)); 
            	}
            	else
            	{
            		k2 = (k1 - k)/(1 + k * k1);
            		k3 = (k + k1)/(1 - k * k1);
            		if (k1 * k2 < 0 && k1 < 0)
            		{
            			x2 = this.xfin < this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1));
            			x3 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1));
            		}
            		else if (k1 * k3 < 0 && k1 > 0)
            		{
            			x2 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1));
            			x3 = this.xfin < this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1));
            		}
            		else
            		{
            			x2 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)); 
            			x3 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)); 
            		}
            		y2 = this.yfin + k2 * (x2 - this.xfin); 
            		//y2 = this.yfin > this.yini ? this.yfin - Math.abs(k2) * Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.yfin + Math.abs(k2) * Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)); 
            		y3 = this.yfin + k3 * (x3 - this.xfin);
            		//y3 = this.yfin > this.yini ? this.yfin - Math.abs(k3) * Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)):this.yfin + Math.abs(k3) * Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)); 
            	}
            }
            
			/*if(this.xfin != this.xini)
			{
				k1 = (this.yfin - this.yini)/(this.xfin - this.xini);
				else
				{
					else
					{
						
	            		k2 = (k + k1)/(1 - k * k1);
	            		k3 = (k1 - k)/(1 + k * k1);
	            		x2 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)); 
	            		y2 = this.yfin > this.yini ? this.yfin - Math.abs(k2) * Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)):this.yfin + Math.abs(k2) * Math.sqrt(Math.pow(l,2)/(Math.pow(k2,2)+1)); 
	            		x3 = this.xfin > this.xini ? this.xfin - Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)):this.xfin + Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)); 
	            		y3 = this.yfin > this.yini ? this.yfin - Math.abs(k3) * Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)):this.yfin + Math.abs(k3) * Math.sqrt(Math.pow(l,2)/(Math.pow(k3,2)+1)); 
					}
				}
   			}
          */
            
			this.arrowObject.graphics.lineStyle(this.thickness, this.color);
            this.arrowObject.graphics.moveTo(this.xini, this.yini);
            this.arrowObject.graphics.lineTo(this.xfin, this.yfin); 
            this.arrowObject.graphics.moveTo(this.xfin, this.yfin);
            this.arrowObject.graphics.lineTo(x2, y2);
            this.arrowObject.graphics.moveTo(this.xfin, this.yfin);
            this.arrowObject.graphics.lineTo(x3, y3);
            
            this.tittle.textColor = this.color2;
			//this.tittle.thickness = 100;
			
			var Format:TextFormat = new TextFormat();
			Format.size = this.size;
			Format.bold = true;
			this.tittle.setTextFormat(Format);
			this.tittle.x = (this.xfin + this.xini - this.tittle.textWidth)/2;
			this.tittle.y = (this.yfin + this.yini - this.tittle.textHeight)/2;
			if(flag)
			{
				this.arrowObject.addEventListener(MouseEvent.MOUSE_OVER, moveHandler)
	            this.arrowObject.addEventListener(MouseEvent.MOUSE_OUT, outHandler)
			}
			this.addChild(this.arrowObject);
            this.addChild(this.tittle);
		}
		private function moveHandler(event:MouseEvent):void
		{
			this.color = 0xffffff - this.colortemp;
			this.removeChildAt(this.getChildIndex(this.arrowObject));
			init();
			
		}
		private function outHandler(event:MouseEvent):void
		{
			this.color = this.colortemp;
			this.removeChildAt(this.getChildIndex(this.arrowObject));
			init();
		}
	}
	
}