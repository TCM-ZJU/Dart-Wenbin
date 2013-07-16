package dart
{
	import org.papervision3d.core.proto.MaterialObject3D;
	import org.papervision3d.lights.PointLight3D;
	import org.papervision3d.materials.shadematerials.GouraudMaterial;
	import org.papervision3d.objects.DisplayObject3D;
	import org.papervision3d.objects.primitives.Cone;
	import org.papervision3d.objects.primitives.Cylinder;
	
	public class arrowline extends DisplayObject3D
	{
		public var cylinder:Cylinder;
		public var cone:Cone;
		public var Radius:Number;
		public function arrowline(beginX:Number, beginY:Number, beginZ:Number, endX:Number, 
		endY:Number, endZ:Number, beginRadius:Number, endRadius:Number, color:uint = 0xffffff, 
		lightcolor:uint = 0xaaaaaa, cylinderRadius:Number = 10, coneRadius:Number = 20, 
		arrowlength:Number = 60):void
		{
			this.Radius = coneRadius;
			var light:PointLight3D = new PointLight3D(true);
      		light.x = 0;
      		light.y = 0;
      		light.z = 0;
			var Material:MaterialObject3D = new GouraudMaterial(light, lightcolor, color);
			var length:Number = length(beginX, beginY, beginZ, endX, endY, endZ);
			
  			cylinder = new Cylinder(Material,cylinderRadius,length - beginRadius - endRadius - arrowlength,20,20,cylinderRadius,true,true);
  			cone = new Cone(Material, coneRadius, arrowlength,20,20);
  			cylinder.y = -(length - beginRadius - endRadius - arrowlength)/2;
  			cone.y = arrowlength / 2;
  			this.addChild(cone, "arrow");
  			this.addChild(cylinder, "line");

  			var k:Number = Proportional(beginRadius, arrowlength, length);
  			//this.x  = 100;
  			if (beginZ == endZ)
  			{
  				this.rotationZ = (beginY - endY) >= 0 ? Math.atan(-(beginX - endX) / (beginY - endY)) * 180 / Math.PI : Math.atan(-(beginX - endX) / (beginY - endY)) * 180 / Math.PI + 180;
  				trace(Math.atan((beginX - endX) / (beginY - endY)))
  				trace(this.rotationZ)
  			}
  			else
  			{
  				var ydegree:Number = (beginX == endX) ? 0 : Math.atan((beginX - endX)/(beginZ - endZ));
	  			var rY:Number = (beginZ - endZ) >= 0 ? ydegree * 180 / Math.PI :ydegree * 180 / Math.PI + 180; 
	  			var xdegree:Number = (beginY == endY) ? ((beginZ > endZ) ? -Math.PI / 2 : Math.PI / 2) : Math.atan((beginZ - endZ)/((beginY - endY)*Math.cos(rY * Math.PI/180)));
	  			
	  			this.rotationX = (beginY - endY) >= 0 ? xdegree * 180 / Math.PI :xdegree * 180 / Math.PI + 180; 
	  			
	  			this.rotationY = rY;
  			}
  			
  			
  			//this.rotationX = (beginY - endY) > 0 ? Math.atan((beginZ - endZ)/(beginY - endY)) * 180 / Math.PI : Math.atan((beginZ - endZ)/(beginY - endY)) * 180 / Math.PI + 180;
  			////this.rotationY = (beginX - endX) > 0 ? Math.atan((beginZ - endZ)/(beginX - endX)) * 180 / Math.PI : Math.atan((beginZ - endZ)/(beginX - endX)) * 180 / Math.PI + 180;
  			//this.rotationY = (beginX - endX) > 0 ? Math.atan((beginX - endX)/(beginZ - endZ)) * 180 / Math.PI : Math.atan((beginX - endX)/(beginZ - endZ)) * 180 / Math.PI + 180;
  			//this.rotationY = Math.atan((-(beginX-endX))/Math.sqrt(Math.pow(beginZ - endZ, 2) + Math.pow(beginY - endY, 2))) * 180 / Math.PI;
  			//this.rotationZ = ()
  			this.x = beginX - (beginX - endX)/k;
  			this.y = beginY - (beginY - endY)/k;
  			this.z = beginZ - (beginZ - endZ)/k;	
		}
		
		private function length(x1:Number, y1:Number, z1:Number, x2:Number, y2:Number, z2:Number):Number
		{
			return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
		}

		private function Proportional(Radius:Number, arrawlength:Number, length:Number):Number
		{
			return length/(Radius + arrawlength);
		}
		
		public function setrotate(cameraPitch:Number, cameraYaw:Number):void
		{
			this.getChildByName("text").x = this.Radius *1.5 * Math.cos((90-cameraPitch) * Math.PI / 180) * Math.sin((90+cameraYaw) * Math.PI / 180);
   			this.getChildByName("text").y = this.Radius *1.5 * Math.sin((90-cameraPitch) * Math.PI / 180);
   			this.getChildByName("text").z = -this.Radius *1.5 * Math.cos((90-cameraPitch) * Math.PI / 180) * Math.cos((90+cameraYaw) * Math.PI / 180);
   			this.getChildByName("text").rotationX = 90 - cameraPitch;
   			this.getChildByName("text").rotationY = -90 - cameraYaw;
		}
	}
}