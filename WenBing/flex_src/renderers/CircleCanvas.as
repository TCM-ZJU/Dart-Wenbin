package renderers
{
	import flash.display.GradientType;
	import flash.display.InterpolationMethod;
	import flash.display.SpreadMethod;
	
	import mx.containers.Canvas;
	
	public class CircleCanvas extends Canvas
	{
		/** our current color setting. */
		protected var _bgColor:uint;
		[Bindable]
		public function get bgColor():uint
		{
			return _bgColor;
		}
		public function set bgColor(value:uint):void
		{
			_bgColor = value;
			invalidateDisplayList();
		}
		
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
		{
			// We could simply do graphics.beginFill(_color) here, to get a solid color fill.
			// But instead, we'll use a gradient fill to get a simulated 3D effect.
			// TODO: tweak the gradient fill settings to get a better looking gradient
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			graphics.clear();
			graphics.beginGradientFill(GradientType.RADIAL, [bgColor, 0x000000], [1, 1], [0, 255], 
				null, SpreadMethod.PAD, InterpolationMethod.RGB, 0.75);
			graphics.drawCircle(unscaledWidth / 2, unscaledHeight / 2, (unscaledWidth < unscaledHeight ? unscaledWidth : unscaledHeight) / 2);
			graphics.endFill();
		}
	}
}