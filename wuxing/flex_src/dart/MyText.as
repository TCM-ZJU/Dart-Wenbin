package dart
{
	import flash.display.*;
	import flash.events.*;
	import flash.geom.*;
	import flash.text.*;
	
	import org.papervision3d.cameras.*;
	import org.papervision3d.materials.*;
	import org.papervision3d.objects.*;
	import org.papervision3d.objects.primitives.*;
	import org.papervision3d.view.*;
    
	public class MyText extends Plane
	{
		public var text:TextField = new TextField(); 
		
		public function MyText(textString:String, textsize:String = "15", textcolor:String = "#123456", textfont:String = "Arial"):void
		{
            text.htmlText = "<font face='"+ textfont +"' size='"+ textsize +"' color='"+ textcolor +"'><b>"+ textString +"</b></font>"; 
            text.autoSize = "left"; 
            
            //text.borderColor = 0xffffff;
             
            var cap:BitmapData = new BitmapData(text.textWidth, text.textHeight, true, 0xffffff); 
            cap.draw(text); 
            
           // var sp:Sprite = new Sprite();
           // sp.addChild(new Bitmap(cap));
            
            
            super(new BitmapMaterial(cap));
		}
		
		public function setrotate(cameraPitch:Number, cameraYaw:Number, radius:Number, oldx:Number,
		oldy:Number, oldz:Number):void
		{
			this.x = oldx + radius *1.5 * Math.cos((90-cameraPitch) * Math.PI / 180) * Math.sin((90+cameraYaw) * Math.PI / 180);
   			this.y = oldy + radius *1.5 * Math.sin((90-cameraPitch) * Math.PI / 180);
   			this.z = oldz - radius *1.5 * Math.cos((90-cameraPitch) * Math.PI / 180) * Math.cos((90+cameraYaw) * Math.PI / 180);
   			this.rotationX = 90 - cameraPitch;
   			this.rotationY = -90 - cameraYaw;
		}
	}
}