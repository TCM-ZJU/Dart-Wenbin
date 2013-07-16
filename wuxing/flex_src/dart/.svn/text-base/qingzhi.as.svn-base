package dart
{
	import flash.display.Sprite;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	import flash.text.TextFormat;
	
	public class qingzhi extends Sprite
	{
		public var na:String = "";
		
		public function qingzhi()
		{
			init();
		}
		
		private function init():void
		{
			var centerx:Number = 200;
			var centery:Number = 180;
			var radius:Number = 100;
			
			var text:TextField = new TextField();
			text.text = "情志内因";
			text.textColor = 0xff0000;
			text.width = 130;
			var Format:TextFormat = new TextFormat();
			Format.size = 30;
			Format.bold = true;
			text.setTextFormat(Format);
			text.x = centerx - text.width / 2;
			
			var r1:round = new round(0x00ffff, 0xff00ff, "怒", centerx, centery - radius, 30, 0x0000ff, 20);
			var r2:round = new round(0x000000, 0xbbbbbb, "恐", centerx - radius * Math.sin(72 * Math.PI / 180), centery - radius * Math.cos(72 * Math.PI / 180), 30, 0x0000ff, 20);
			var r3:round = new round(0xff0000, 0xffff00, "喜", centerx + radius * Math.sin(72 * Math.PI / 180), centery - radius * Math.cos(72 * Math.PI / 180), 30, 0x0000ff, 20);
			var r4:round = new round(0xffffff, 0x000000, "悲", centerx - radius * Math.sin(36 * Math.PI / 180), centery + radius * Math.cos(36 * Math.PI / 180), 30, 0x0000ff, 20);
			var r5:round = new round(0xffff00, 0xff0000, "思", centerx + radius * Math.sin(36 * Math.PI / 180), centery + radius * Math.cos(36 * Math.PI / 180), 30, 0x0000ff, 20);
			
			var l1:line = new line(0x0000ff, centerx, centery - radius, centerx - radius * Math.sin(72 * Math.PI / 180), centery - radius * Math.cos(72 * Math.PI / 180), 2)
			var l2:line = new line(0x0000ff, centerx - radius * Math.sin(72 * Math.PI / 180), centery - radius * Math.cos(72 * Math.PI / 180), centerx - radius * Math.sin(36 * Math.PI / 180), centery + radius * Math.cos(36 * Math.PI / 180), 2)
			var l3:line = new line(0x0000ff, centerx + radius * Math.sin(72 * Math.PI / 180), centery - radius * Math.cos(72 * Math.PI / 180), centerx + radius * Math.sin(36 * Math.PI / 180), centery + radius * Math.cos(36 * Math.PI / 180), 2)
			var l4:line = new line(0x0000ff, centerx - radius * Math.sin(36 * Math.PI / 180), centery + radius * Math.cos(36 * Math.PI / 180), centerx + radius * Math.sin(36 * Math.PI / 180), centery + radius * Math.cos(36 * Math.PI / 180), 2)
			var l5:line = new line(0x0000ff, centerx + radius * Math.sin(72 * Math.PI / 180), centery - radius * Math.cos(72 * Math.PI / 180), centerx, centery - radius, 2)
			
			r1.addEventListener(MouseEvent.CLICK, cl1);
			r2.addEventListener(MouseEvent.CLICK, cl2);
			r3.addEventListener(MouseEvent.CLICK, cl3);
			r4.addEventListener(MouseEvent.CLICK, cl4);
			r5.addEventListener(MouseEvent.CLICK, cl5);
			r1.addEventListener(MouseEvent.MOUSE_OUT, out);
			r2.addEventListener(MouseEvent.MOUSE_OUT, out);
			r3.addEventListener(MouseEvent.MOUSE_OUT, out);
			r4.addEventListener(MouseEvent.MOUSE_OUT, out);
			r5.addEventListener(MouseEvent.MOUSE_OUT, out);
			
			this.addChild(text);
			this.addChild(l1);
			this.addChild(l2);
			this.addChild(l3);
			this.addChild(l4);
			this.addChild(l5);
			this.addChild(r1);
			this.addChild(r2);
			this.addChild(r3);
			this.addChild(r4);
			this.addChild(r5);
		}
		
		private function cl1(event:MouseEvent):void 
    	{
	   		this.na = "怒";
    	}
    	
    	private function cl2(event:MouseEvent):void 
    	{
	   		this.na = "恐";
    	}
    	
    	private function cl3(event:MouseEvent):void 
    	{
	   		this.na = "喜";
    	}
    	
    	private function cl4(event:MouseEvent):void 
    	{
	   		this.na = "悲";
    	}
    	
    	private function cl5(event:MouseEvent):void 
    	{
	   		this.na = "思";
    	}
		
		private function out(event:MouseEvent):void 
    	{
	   		this.na = "";
    	}
	}
}