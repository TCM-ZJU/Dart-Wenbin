package dart
{
	import flash.display.DisplayObject;
	import flash.display.Sprite;
	import flash.events.MouseEvent;
	[SWF(width = "230" ,height = "270")]
	public class action extends Sprite
	{
		public var na:String = "";
		public function action()
		{
			
			var roundObject:Sprite = new Sprite();
			var centerx:Number = 120;
			var centery:Number = 200;
			var deta:Number = 60;
			var ay:Number = 0;
			var radius:Number = 100;
			var smallradius:Number = 20;
			roundObject.graphics.lineStyle(2,0x000000);
			roundObject.graphics.drawCircle(centerx, centery-deta*Math.sqrt(3)/3, radius);
			var r1:round = new round(0xff0000, 0xffff00, "血", centerx - deta, centery, smallradius, 0x000000, 20); 
			var r2:round = new round(0xb1c1da, 0x26ae7b, "律液", centerx + deta, centery, smallradius,0x000000, 20); 
			var r3:round = new round(0x0000ff, 0x789abc, "精", centerx, centery-deta*Math.sqrt(3), smallradius,0x000000, 20);
			var r4:round = new round(0xffffff, 0x222222, "气", centerx - deta * 2, ay, smallradius,0x000000, 20); 
			var r5:round = new round(0x00ff00, 0xff00ff, "神", centerx + deta * 2, ay, smallradius,0x000000, 20);  
			var da1:doublearrow = new doublearrow(0x000000, "生成", centerx - deta + smallradius, centery, centerx + deta - smallradius, centery, 2);
			var da2:doublearrow = new doublearrow(0x000000, "生成", centerx - deta+smallradius*0.5, centery-smallradius*Math.sqrt(3)/2, centerx-smallradius*0.5, centery-deta*Math.sqrt(3)+smallradius*Math.sqrt(3)/2, 2);
			var da3:doublearrow = new doublearrow(0x000000, "生成", centerx + deta-smallradius*0.5, centery-smallradius*Math.sqrt(3)/2, centerx+smallradius*0.5, centery-deta*Math.sqrt(3)+smallradius*Math.sqrt(3)/2, 2);
			var da4:doublearrow = new doublearrow(0x000000, "生成", centerx - deta * 2, ay + smallradius, centerx, centery-deta*Math.sqrt(3)/3-radius, 2);
			var a1:arrow = new arrow(0x000000, "生成", centerx - deta * 2 + smallradius, ay, centerx + deta * 2 - smallradius, ay, 2, false);
			var a2:arrow = new arrow(0x000000, "生成", centerx, centery-deta*Math.sqrt(3)/3-radius, centerx + deta * 2, ay + smallradius, 2, false);
			var a3:arrow = new arrow(0x333333, "控制", centerx + deta * 2, ay - smallradius, centerx - deta * 2, ay - smallradius, 2, false);
			var a4:arrow = new arrow(0x333333, "控制", centerx + deta * 2, ay + smallradius, centerx + radius, centery-deta*Math.sqrt(3)/3, 2, false);
			var a5:arrow = new arrow(0x3333ff, "载", centerx - radius, centery-deta*Math.sqrt(3)/3, centerx - deta * 2, ay + smallradius, 2, false);
			var a6:arrow = new arrow(0x555555, "固摄", centerx - deta * 2, ay + smallradius, centerx - radius * 0.5, centery-deta*Math.sqrt(3)/3 - radius * Math.sqrt(3)/2, 2, false);
			var a7:arrow = new arrow(0x777777, "推动", centerx - deta * 2, ay + smallradius, centerx - radius * Math.sqrt(3)/2, centery-deta*Math.sqrt(3)/3 - radius * 0.5, 2, false);
			this.addChild(roundObject);
			
			r1.addEventListener(MouseEvent.CLICK, click1);
			r2.addEventListener(MouseEvent.CLICK, click2);
			r3.addEventListener(MouseEvent.CLICK, click3);
			r4.addEventListener(MouseEvent.CLICK, click4);
			r5.addEventListener(MouseEvent.CLICK, click5);
			r1.addEventListener(MouseEvent.MOUSE_OUT, out);
			r2.addEventListener(MouseEvent.MOUSE_OUT, out);
			r3.addEventListener(MouseEvent.MOUSE_OUT, out);
			r4.addEventListener(MouseEvent.MOUSE_OUT, out);
			r5.addEventListener(MouseEvent.MOUSE_OUT, out);
			
			
			//this.addChild(roundObject);
			
			this.addChild(da1);
			this.addChild(da2);
			this.addChild(da3);
			this.addChild(da4);
			this.addChild(a1);
			this.addChild(a2);
			this.addChild(a3);
			this.addChild(a4);
			this.addChild(a5);
			this.addChild(a6);
			this.addChild(a7);
			
			this.addChild(r1);
			this.addChild(r2);
			this.addChild(r3);
			this.addChild(r4);
			this.addChild(r5);
			
		}
		
		private function click1(event:MouseEvent):void 
    	{
	   		this.na = "血";
    	}
    	
    	private function click2(event:MouseEvent):void 
    	{
	   		this.na = "律液";
    	}
    	
    	private function click3(event:MouseEvent):void 
    	{
	   		this.na = "精";
    	}
    	
    	private function click4(event:MouseEvent):void 
    	{
	   		this.na = "气";
    	}
    	
    	private function click5(event:MouseEvent):void 
    	{
	   		this.na = "神";
    	}
    	
    	private function out(event:MouseEvent):void 
    	{
	   		this.na = "";
    	}
	}
}