package dart
{
	import flash.display.DisplayObject;
	import flash.display.Sprite;
	import flash.events.*;
	
	public class doublearrow extends Sprite
	{
		private var color:uint;
		private var colortemp:uint;
		private var tittle:String;
		private var xini:Number;
		private var yini:Number;
		private var xfin:Number;
		private var yfin:Number;
		private var thickness:Number;
		private var arr:arrow;
		private var arr1:arrow;
		private var object:DisplayObject;
		public function doublearrow(color:uint, tittle:String, xini:Number, yini:Number,
		xfin:Number, yfin:Number, thickness:Number)
		{
			this.color = color;
			this.colortemp = color;
			this.tittle = tittle;
			this.xini = xini;
			this.yini = yini;
			this.xfin = xfin;
			this.yfin = yfin;
			this.thickness = thickness;
			init();
			
		}
		private function init():void
		{
			arr = new arrow(color, tittle, xini, yini, xfin, yfin, thickness, false);
			arr1 = new arrow(color, tittle, xfin, yfin, xini, yini, thickness, false);
			arr.removeChild(arr.tittle);
			this.addChild(arr);
			this.addChild(arr1);
		}
	}
}