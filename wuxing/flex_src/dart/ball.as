package dart
{

	import org.papervision3d.core.proto.MaterialObject3D;
	import org.papervision3d.lights.PointLight3D;
	import org.papervision3d.materials.shadematerials.GouraudMaterial;
	import org.papervision3d.objects.primitives.Sphere;
	
	public class ball extends Sphere
	{
		private var ballradius:Number;
		private var ballcolor:uint;
		private var lightcolot:uint;
		private var ballheight:Number;
		private var ballwidth:Number;
		private var text:MyText
		public function ball(textstr:String, ballcolor:uint = 0xffffff, lightcolor:uint = 0xaaaaaa, ballradius:Number = 50, ballheight:Number = 20, ballwidth:Number = 20):void
		{
			this.ballradius = ballradius;
			
			var light:PointLight3D = new PointLight3D(true);
      		light.x = 0;
      		light.y = 0;
      		light.z = 0;
			var Material:MaterialObject3D = new GouraudMaterial(light, lightcolor, ballcolor);
			Material.interactive = true;
			super(Material, ballradius, ballheight, ballwidth);
			text = new MyText(textstr, ballradius > 40 ? "40" : ballradius.toString());
  			text.z = -ballradius;
  			addChild(text,"text");
  			 
		}
		
		public function setrotate(cameraPitch:Number, cameraYaw:Number):void
		{
			this.getChildByName("text").x = this.ballradius *1.5 * Math.cos((90-cameraPitch) * Math.PI / 180) * Math.sin((90+cameraYaw) * Math.PI / 180);
   			this.getChildByName("text").y = this.ballradius *1.5 * Math.sin((90-cameraPitch) * Math.PI / 180);
   			this.getChildByName("text").z = -this.ballradius *1.5 * Math.cos((90-cameraPitch) * Math.PI / 180) * Math.cos((90+cameraYaw) * Math.PI / 180);
   			this.getChildByName("text").rotationX = 90 - cameraPitch;
   			this.getChildByName("text").rotationY = -90 - cameraYaw;
		}
		
		public function changename(str1:String, str2:String, cameraPitch:Number, cameraYaw:Number):void
		{
			var textstr:String = text.text.text == str1 ? str2 : str1;
			removeChild(text);
			text = new MyText(textstr, ballradius > 40 ? "40" : ballradius.toString());
			text.z = -ballradius;
			addChild(text, "text");
			setrotate(cameraPitch, cameraYaw)
		}
		
	}
}