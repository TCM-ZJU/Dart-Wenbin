package dart
{
	import flash.display.Sprite;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	import flash.text.TextFormat;
	
	public class liuxie extends Sprite
	{
		private var r1:round;
		private var r2:round;
		private var r3:round;
		private var r4:round;
		private var r5:round;
		private var r6:round;
		
		public function liuxie()
		{
			init();
		}
		
		private function init():void
		{
			var centerx:Number = 200;
			var centery:Number = 180;
			var radius:Number = 100;
			var text:TextField = new TextField();
			text.text = "环境外因";
			text.textColor = 0xff0000;
			text.width = 130;
			var Format:TextFormat = new TextFormat();
			Format.size = 30;
			Format.bold = true;
			text.setTextFormat(Format);
			text.x = centerx - text.width / 2;
			
			r1 = new round(0xff0000, 0xffff00, "热", centerx - radius * Math.sin(30 * Math.PI / 180), centery - radius * Math.sin(60 * Math.PI / 180), 30, 0x0000ff, 20);
			r2 = new round(0xff0000, 0xffff00, "暑", centerx + radius * Math.sin(30 * Math.PI / 180), centery - radius * Math.sin(60 * Math.PI / 180), 30, 0x0000ff, 20);
			r3 = new round(0x00ffff, 0xff00ff, "风", centerx - radius, centery, 30, 0x0000ff, 20);
			r4 = new round(0xffff00, 0xff0000, "湿", centerx + radius, centery, 30, 0x0000ff, 20);
			r5 = new round(0xffffff, 0x000000, "燥", centerx - radius * Math.sin(30 * Math.PI / 180), centery + radius * Math.sin(60 * Math.PI / 180), 30, 0x0000ff, 20);
			r6 = new round(0x000000, 0xbbbbbb, "寒", centerx + radius * Math.sin(30 * Math.PI / 180), centery + radius * Math.sin(60 * Math.PI / 180), 30, 0x0000ff, 20);
			
			var l1:line = new line(0x0000ff, centerx - radius * Math.sin(30 * Math.PI / 180), centery - radius * Math.sin(60 * Math.PI / 180), centerx + radius * Math.sin(30 * Math.PI / 180), centery - radius * Math.sin(60 * Math.PI / 180), 2)
			var l2:line = new line(0x0000ff, centerx - radius * Math.sin(30 * Math.PI / 180), centery - radius * Math.sin(60 * Math.PI / 180), centerx - radius, centery, 2)
			var l3:line = new line(0x0000ff, centerx + radius * Math.sin(30 * Math.PI / 180), centery - radius * Math.sin(60 * Math.PI / 180), centerx + radius, centery, 2)
			var l4:line = new line(0x0000ff, centerx - radius, centery, centerx - radius * Math.sin(30 * Math.PI / 180), centery + radius * Math.sin(60 * Math.PI / 180), 2)
			var l5:line = new line(0x0000ff, centerx + radius, centery, centerx + radius * Math.sin(30 * Math.PI / 180), centery + radius * Math.sin(60 * Math.PI / 180), 2)
			var l6:line = new line(0x0000ff, centerx - radius * Math.sin(30 * Math.PI / 180), centery + radius * Math.sin(60 * Math.PI / 180), centerx + radius * Math.sin(30 * Math.PI / 180), centery + radius * Math.sin(60 * Math.PI / 180), 2)
			
			r1.addEventListener(MouseEvent.CLICK, cl1);
			r2.addEventListener(MouseEvent.CLICK, cl2);
			r3.addEventListener(MouseEvent.CLICK, cl3);
			r4.addEventListener(MouseEvent.CLICK, cl4);
			r5.addEventListener(MouseEvent.CLICK, cl5);
			r6.addEventListener(MouseEvent.CLICK, cl6);
			
			this.addChild(text);
			
			this.addChild(l1);
			this.addChild(l2);
			this.addChild(l3);
			this.addChild(l4);
			this.addChild(l5);
			this.addChild(l6);
			
			this.addChild(r1);
			this.addChild(r2);
			this.addChild(r3);
			this.addChild(r4);
			this.addChild(r5);
			this.addChild(r6);
		}
		
		private function cl1(e:MouseEvent):void
		{
			
			r1.ifclick = !r1.ifclick;
			
			r1.resetcolor();
		}
		private function cl2(e:MouseEvent):void
		{
			r2.ifclick = !r2.ifclick
			r2.resetcolor();
		}
		private function cl3(e:MouseEvent):void
		{
			r3.ifclick = !r3.ifclick
			r3.resetcolor();
		}
		private function cl4(e:MouseEvent):void
		{
			r4.ifclick = !r4.ifclick
			r4.resetcolor();
		}
		private function cl5(e:MouseEvent):void
		{
			r5.ifclick = !r5.ifclick
			r5.resetcolor();
		}
		private function cl6(e:MouseEvent):void
		{
			r6.ifclick = !r6.ifclick
			r6.resetcolor();
		}
		
		public function getarray():Array
		{
			var sarray:Array = new Array();
			if (r1.ifclick)
				sarray.push("热邪");
			if (r2.ifclick)
				sarray.push("暑邪");
			if (r3.ifclick)
				sarray.push("风邪");
			if (r4.ifclick)
				sarray.push("湿邪");
			if (r5.ifclick)
				sarray.push("燥邪");
			if (r6.ifclick)
				sarray.push("寒邪");	
			return sarray;
		}
	}
}