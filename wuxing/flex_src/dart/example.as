package dart
{
	import flash.display.Sprite;
	import flash.text.*;
	
	public class example extends Sprite
	{
		private var sa:Array = new Array();
		public function example(sa:Array)
		{
			this.sa = sa;
			init();
		}
		
		private function init():void
		{
			var text:TextField = new TextField();
			text.text = "“"+this.sa[0]+"”到“"+this.sa[1]+"”的推导过程";
			text.textColor = 0x000000;
			text.width = 300;
			var Format:TextFormat = new TextFormat();
			Format.size = 15;
			Format.bold = true;
			text.setTextFormat(Format);
			text.x = 315 - text.width / 2;
			
			
			
			var color1:uint;
			var color2:uint;
			
			switch (sa[3])
			{
				case "金":
					color1=0xffffff;
					color2=0x222222;
					break;
				case "木":
					color1=0x00ffff;
					color2=0xff0000;
					break;
				case "水":
					color1=0x000000
					color2=0xffffff
					break;
				case "火":
					color1=0xff0000
					color2=0x00ffff
					break;
				case "土":
					color1=0xffff00
					color2=0x0000ff
					break;
			}
			
			var r1:round = new round(0xff00ff, 0xffff00, sa[0].toString(), 80, 100, 30, 0x0000ff, 20);
			
			var r2:round = new round(color1, color2, sa[2].toString(), 180, 100, 30, 0x0000ff, 20);
			var r3:round = new round(color1, color2, sa[3].toString(), 280, 100, 30, 0x0000ff, 20);
			switch (sa[5])
			{
				case "金":
					color1=0xffffff;
					color2=0x222222;
					break;
				case "木":
					color1=0x00ffff;
					color2=0xff0000;
					break;
				case "水":
					color1=0x000000
					color2=0xffffff
					break;
				case "火":
					color1=0xff0000
					color2=0x00ffff
					break;
				case "土":
					color1=0xffff00
					color2=0x0000ff
					break;
			}
			var r4:round = new round(color1, color2, sa[5].toString(), 380, 100, 30, 0x0000ff, 20);
			var r5:round = new round(color1, color2, sa[4].toString(), 480, 100, 30, 0x0000ff, 20);
			var r6:round = new round(0xff00ff, 0xffff00, sa[1].toString(), 580, 100, 30, 0x0000ff, 20);
			var arrowcolor:uint;
			arrowcolor = 0x000000;
			var arro1:arrow = new arrow(arrowcolor, "", 110, 100, 150, 100, 5, true);
			var arro2:arrow = new arrow(arrowcolor, "属", 210, 100, 250, 100, 5, true, 0xff0000, 20);
			var arro3:arrow = new arrow(arrowcolor, rela(sa[3], sa[5]), 310, 100, 350, 100, 5, true, 0xff0000, 20);
			var arro4:arrow = new arrow(arrowcolor, "属", 450, 100, 410, 100, 5, true, 0xff0000, 20);
			var arro5:arrow = new arrow(arrowcolor, "", 550, 100, 510, 100, 5, true);
			
			this.addChild(text);
			this.addChild(arro1);
			this.addChild(arro2);
			this.addChild(arro3);
			this.addChild(arro4);
			this.addChild(arro5);
			this.addChild(r1);
			this.addChild(r2);
			this.addChild(r3);
			this.addChild(r4);
			this.addChild(r5);
			this.addChild(r6);
		}
		
		private function rela(s1:String, s2:String):String
		{
			if (s1 == "木" && s2 == "火" || s1 == "火" && s2 == "土" || s1 == "土" && s2 == "金" || s1 == "金" && s2 == "水" || s1 == "水" && s2 == "木")
				return "生";
			else if (s1 == "木" && s2 == "土" || s1 == "土" && s2 == "水" || s1 == "水" && s2 == "火" || s1 == "火" && s2 == "金" || s1 == "金" && s2 == "木")
				return "克";
			return null;
		}
	}
}