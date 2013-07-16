package dart
{
	import flash.display.Sprite;
	import flash.events.*;
	
	public class line extends Sprite
	{
		private var color:uint;
		private var colortemp:uint;
		private var lineObject:Sprite = new Sprite();
		private var xini:Number;
		private var yini:Number;
		private var xfin:Number;
		private var yfin:Number;
		private var thickness:Number;
		public function line(color:uint, xini:Number, yini:Number, xfin:Number, yfin:Number, thickness:Number)
		{
			this.color = color;
			this.colortemp = color;
			this.xini = xini;
			this.yini = yini;
			this.xfin = xfin;
			this.yfin = yfin;
			this.thickness = thickness;
			init();			
		}
		
		private function init():void
		{
			trace(this.thickness)
			this.lineObject.graphics.lineStyle(this.thickness, this.color);
            this.lineObject.graphics.moveTo(this.xini, this.yini);
            this.lineObject.graphics.lineTo(this.xfin, this.yfin);
            this.lineObject.addEventListener(MouseEvent.MOUSE_OVER, moveHandler)
            this.lineObject.addEventListener(MouseEvent.MOUSE_OUT, outHandler)
            this.addChildAt(this.lineObject, 0);
		}
		
		private function moveHandler(event:MouseEvent):void
		{
			this.color = 0xffffff - this.colortemp;
			this.removeChildAt(this.getChildIndex(this.lineObject));
			init();
			
		}
		private function outHandler(event:MouseEvent):void
		{
			this.color = this.colortemp;
			this.removeChildAt(this.getChildIndex(this.lineObject));
			init();
		}
	}
}