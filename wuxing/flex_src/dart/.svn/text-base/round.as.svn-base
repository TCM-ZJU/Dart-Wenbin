package dart
{
	import flash.display.Sprite;
	import flash.events.*;
	import flash.text.*;
	
	public class round extends Sprite
	{
		private var color:uint;
		private var color2:uint;
		private var colortemp;
		private var tittle:TextField = new TextField();
		public var cx:Number;
		public var cy:Number;
		private var radius:Number;
		private var textcolor:Number;
		private var size:Number;
		private var roundObject:Sprite = new Sprite();
		public var ifclick = false;

		 
		public function round(color:uint, color2:uint, tittle:String, cx:Number, cy:Number, radius:Number, textcolor:Number = 0x000000, size:Number=10)
		{
			this.color = color;
			this.color2 = color2;
			this.colortemp = color2;
			this.tittle.text = tittle;
			this.tittle.mouseEnabled = true;
			this.cx = cx;
			this.cy = cy;
			this.radius = radius;
			this.textcolor = textcolor;
			this.size = size;
			//this.width = 200;
			//this.height = 200;
			//this.x = 100;
			//this.y = 100;
			this.tittle.textColor = this.textcolor;
			var Format:TextFormat = new TextFormat();
			Format.size = this.size;
			Format.bold = true;
			this.tittle.setTextFormat(Format);
			init();
		}
		
		public function init():void
		{
			
			
			this.tittle.wordWrap = true;
			this.tittle.autoSize = TextFieldAutoSize.CENTER;
			
			
			//this.tittle.thickness = 10;
			//this.tittle.setActualSize(this.tittle.textWidth*1.1, this.tittle.textHeight*1.1)
			
			
			this.tittle.x = this.cx - this.tittle.textWidth/2;
			this.tittle.y = this.cy - this.tittle.textHeight/2;
			this.tittle.addEventListener(MouseEvent.MOUSE_OVER, moveHandler);
            this.tittle.addEventListener(MouseEvent.MOUSE_OUT, outHandler);
            
			this.roundObject.graphics.lineStyle(2,this.color2);
            this.roundObject.graphics.beginFill(this.color);
            this.roundObject.graphics.drawCircle(this.cx,this.cy,this.radius);
            this.roundObject.graphics.endFill();
            this.roundObject.addEventListener(MouseEvent.MOUSE_OVER, moveHandler);
            this.roundObject.addEventListener(MouseEvent.MOUSE_OUT, outHandler);
            this.addChild(this.roundObject);
            this.addChild(this.tittle);
            
		}
		private function moveHandler(event:MouseEvent):void
		{
			if (!this.ifclick)
			{
				var Format:TextFormat = new TextFormat();
				Format.size = this.size;
				Format.bold = true;
				this.tittle.setTextFormat(Format);
				this.color2 = this.color;
				this.color = this.colortemp;
				this.colortemp = this.color2;
				this.tittle.textColor = 0x888888;
				this.removeChildAt(this.getChildIndex(this.tittle));
				this.removeChildAt(this.getChildIndex(this.roundObject));
				init();
			}
		}
		private function outHandler(event:MouseEvent):void
		{
			if(!this.ifclick)
			{
				var Format:TextFormat = new TextFormat();
				Format.size = this.size;
				Format.bold = true;
				this.tittle.setTextFormat(Format);
				this.color2 = this.color;
				this.color = this.colortemp;
				this.colortemp = this.color2;
				this.tittle.textColor = this.textcolor;
				this.removeChildAt(this.getChildIndex(this.tittle));
				this.removeChildAt(this.getChildIndex(this.roundObject));
				init();
			}
		}
		
		private function onHandler(event:MouseEvent):void
		{
			;
		}
		private function move():void
		{
			;
		}
			
		public function resetcolor():void
		{
			var color1:uint;
			var color2:uint;
			
			var color4:uint;
			color1 = this.color2;
			color2 = this.color;
			color4 = this.tittle.textColor;
			this.color2 = 0xffff00;
			this.color = 0x0000ff;
			this.tittle.textColor = 0xffffff;
			
			this.removeChildAt(this.getChildIndex(this.tittle));
			this.removeChildAt(this.getChildIndex(this.roundObject));
			
			var Format:TextFormat = new TextFormat();
			Format.size = this.size*1.5;
			Format.bold = true;
			this.tittle.setTextFormat(Format);
			
			init();
			
			this.color2 = color1;
			this.color = color2;
			this.tittle.textColor = color4;
			
		}
		
		public function getString():String
		{
			return this.tittle.text;
		}
		
		public function change(color:uint, color2:uint):void
		{
			this.color = color;
			this.color2 = color2;
			this.colortemp = color2;
			this.tittle.textColor = this.textcolor;
			init();
		}
	}
}