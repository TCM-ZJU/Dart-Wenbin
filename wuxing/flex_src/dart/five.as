package dart
{
	import flash.events.MouseEvent;
	import flash.events.TimerEvent;
	import flash.utils.Timer;
	
	import org.papervision3d.core.proto.MaterialObject3D;
	import org.papervision3d.events.InteractiveScene3DEvent;
	import org.papervision3d.lights.PointLight3D;
	import org.papervision3d.materials.*;
	import org.papervision3d.materials.shadematerials.GouraudMaterial;
	import org.papervision3d.materials.special.Letter3DMaterial;
	import org.papervision3d.objects.DisplayObject3D;
	import org.papervision3d.typography.fonts.*;
 	
	public class five extends PaperBase
	{
		private var wood:ball;
		private var fire:ball;
		private var water:ball;
		private var gold:ball;
		private var soil:ball;
		
		public var btn1:round;
		private var btn2:round;
		
		private var watertowood:arrowline;
		private var woodtofire:arrowline;
		private var firetosoil:arrowline;
		private var soidtogold:arrowline;
		private var goldtowater:arrowline;
		private var watertofire:arrowline;
		private var woodtosoil:arrowline;
		private var firetogold:arrowline;
		private var soiltowater:arrowline;
		private var goldtowood:arrowline;
		
		private var soiltowood:arrowline;
		private var soiltofire:arrowline;
		
		private var lastMouseX:Number;
    	private var lastMouseY:Number;
    	private var doRotation:Boolean = false;
    	private var cameraPitch:Number = 90;
    	private var cameraYaw:Number = -90;
    	
    	private var tempcameraPitch:Number;
    	private var tempcameraYaw:Number;
    	
    	private var flag:Boolean = false; 
    	public var model:Boolean = false;
    	public var ballin:Boolean = false;
    	
    	public var na:String;
    	
    	private var time1:Timer = new Timer(30,10);
    	private var time2:Timer = new Timer(30,10);
    	
    	
    	//private var btn:but
    	
    	private var textMaterial:Letter3DMaterial = new Letter3DMaterial(0x123456, 1);
    	
		public function five():void
  		{
   			init();
   			//stage.addEventListener(MouseEvent.MOUSE_DOWN, onMouseDown);
      		//stage.addEventListener(MouseEvent.MOUSE_UP, onMouseUp);
      		time1.addEventListener(TimerEvent.TIMER, timer1);
      		time1.addEventListener(TimerEvent.TIMER_COMPLETE,onComplete1); 
      		time2.addEventListener(TimerEvent.TIMER, timer2);
      		time2.addEventListener(TimerEvent.TIMER_COMPLETE,onComplete2);
  		}
  		
		override protected function init3d():void
  		{
  			//var woodMaterial:MaterialObject3D = new ColorMaterial(0x00ffff,1,false);
  			//wood = new Sphere(woodMaterial,50,20,20);
  			wood = new ball("木", 0x00ffff);
  			wood.name = "wood";  			
  			fire = new ball("火", 0xff0000);
  			fire.name = "fire"; 			
  			water = new ball("水", 0x000000);
  			water.name = "water";
  			gold = new ball("金", 0xffffff);
  			gold.name = "gold";
  			soil = new ball("土", 0xffff00);
  			soil.name = "soil";
  			
  			btn1 = new round(0xee7d22, 0xffffff, "中土模式", 0, 0, 20);
  			btn2 = new round(0xee7d22, 0xffffff, "五行模式", 0, 0, 20);
  			//wood.pitch(-50);
  			//wood.addChild(shaderText,"aaa");
  			var distance:Number = 300;
  			wood.y = distance;
  			wood.z = distance * Math.cos(18 * Math.PI / 180);
  			
  			water.x = -distance * Math.cos(18 * Math.PI / 180);
  			water.y = distance * Math.sin(18 * Math.PI / 180);
  			water.z = distance * Math.sin(36 * Math.PI / 180);
  			
  			fire.x = distance * Math.cos(18 * Math.PI / 180);
  			fire.y = distance * Math.sin(18 * Math.PI / 180);
  			fire.z = -distance * Math.sin(36 * Math.PI / 180);
  			
  			gold.y = -distance * Math.cos(36 * Math.PI / 180);
  			gold.x = -distance * Math.sin(36 * Math.PI / 180);
  			gold.z = -distance * Math.cos(18 * Math.PI / 180);
  			
  			soil.y = -distance * Math.cos(36 * Math.PI / 180);
  			soil.x = distance * Math.sin(36 * Math.PI / 180);
  				
  			watertowood = new arrowline(wood.x, wood.y, wood.z, water.x, water.y, water.z, 50, 50, 0xffffff);
			woodtofire = new arrowline(fire.x, fire.y, fire.z, wood.x, wood.y, wood.z, 50, 50, 0xffffff);
			firetosoil = new arrowline(soil.x, soil.y, soil.z, fire.x, fire.y, fire.z, 50, 50, 0xffffff);
			soidtogold = new arrowline(gold.x, gold.y, gold.z, soil.x, soil.y, soil.z, 50, 50, 0xffffff);
			goldtowater = new arrowline(water.x, water.y, water.z, gold.x, gold.y, gold.z, 50, 50, 0xffffff);
			watertofire = new arrowline(fire.x, fire.y, fire.z, water.x, water.y, water.z, 50, 50, 0x000000);
			woodtosoil = new arrowline(soil.x, soil.y, soil.z, wood.x, wood.y, wood.z, 50, 50, 0x000000);
			firetogold = new arrowline(gold.x, gold.y, gold.z, fire.x, fire.y, fire.z, 50, 50, 0x000000);
			soiltowater = new arrowline(water.x, water.y, water.z, soil.x, soil.y, soil.z, 50, 50, 0x000000);
			goldtowood = new arrowline(wood.x, wood.y, wood.z, gold.x, gold.y, gold.z, 50, 50, 0x000000);
			
			soiltowood = new arrowline(wood.x, wood.y, wood.z, soil.x, soil.y, soil.z, 50, 50, 0x123456);
			soiltofire = new arrowline(fire.x, fire.y, fire.z, soil.x, soil.y, soil.z, 50, 50, 0x123456);
			
			soil.addEventListener(InteractiveScene3DEvent.OBJECT_CLICK, clickInteractiveHandle);
			gold.addEventListener(InteractiveScene3DEvent.OBJECT_CLICK, clickInteractiveHandle);
			wood.addEventListener(InteractiveScene3DEvent.OBJECT_CLICK, clickInteractiveHandle);
			fire.addEventListener(InteractiveScene3DEvent.OBJECT_CLICK, clickInteractiveHandle);
			water.addEventListener(InteractiveScene3DEvent.OBJECT_CLICK, clickInteractiveHandle);
			soil.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			gold.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			wood.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			fire.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			water.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			soil.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			gold.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			wood.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			fire.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			water.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			
			watertowood.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			woodtofire.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			firetosoil.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			soidtogold.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			goldtowater.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			watertofire.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			woodtosoil.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			firetogold.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			soiltowater.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			goldtowood.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			soiltowood.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			soiltofire.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
			
			watertowood.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			woodtofire.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			firetosoil.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			soidtogold.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			goldtowater.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			watertofire.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			woodtosoil.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			firetogold.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			soiltowater.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			goldtowood.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			soiltowood.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
			soiltofire.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  		
  			default_scene.addChild(wood);
  			default_scene.addChild(fire);
  			default_scene.addChild(water);
  			default_scene.addChild(gold);
  			default_scene.addChild(soil);
  			default_scene.addChild(watertowood);
  			default_scene.addChild(woodtofire);
  			default_scene.addChild(firetosoil);
  			default_scene.addChild(soidtogold);
  			default_scene.addChild(goldtowater);
  			default_scene.addChild(watertofire);
  			default_scene.addChild(woodtosoil);
  			default_scene.addChild(firetogold);
  			default_scene.addChild(soiltowater);
  			default_scene.addChild(goldtowood);
  			btn1.x = -100;
  			btn1.y = 40;
  			btn2.x = -100;
  			btn2.y = 100
  			//btn1.addEventListener(MouseEvent.CLICK, mouseclick1);
  			//btn2.addEventListener(MouseEvent.CLICK, mouseclick2);
  			//stage.addChild(btn1);
  			//stage.addChild(btn2);
  		}
  		
  		override protected function processFrame():void
  		{
  			if (doRotation) {
		        // convert the change in mouse position into a change in camera angle
		        var panelx:Number = 328;
		        var panely:Number = -25;
		        var dPitch:Number = (mouseY + panely - lastMouseY) / 2;
		        var dYaw:Number = (mouseX + panelx - lastMouseX) / 2;
		        trace("mouseY"+mouseY)
		        trace("mouseX"+mouseX)
		        trace("lastMouseX"+lastMouseX)
		        trace("lastMouseY"+lastMouseY)
		        
		        
		        // update the camera angles
		        cameraPitch -= dPitch;
		        cameraYaw -= dYaw;
		        // limit the pitch of the camera
		        if (cameraPitch < 0) 
		        {
		        	cameraPitch = 0.1;
		    	} 
		    	else if (cameraPitch >= 180) 
		    	{
		          	cameraPitch = 179.9;
		    	}
		    	// reset the last mouse position
        		
        		lastMouseX = mouseX + panelx;
        		lastMouseY = mouseY + panely;
        		
        		// reposition the camera
        		default_camera.orbit(cameraPitch, cameraYaw);
   				//default_camera.orbit(90, -90);    //default camera angle
   				wood.setrotate(cameraPitch, cameraYaw);
   				water.setrotate(cameraPitch, cameraYaw);
   				fire.setrotate(cameraPitch, cameraYaw);
   				soil.setrotate(cameraPitch, cameraYaw);
   				gold.setrotate(cameraPitch, cameraYaw);
    	
   				//wood.getChildByName("aaa").rotationX = 90 - xx;
   				//wood.getChildByName("aaa").rotationY = -90 - yy;
        		
        		
      		}


  			//default_camera.orbit((mouseY - (stage.height/2))/stage.height,0);
  		}
  		
		public function onMouseDown(event:MouseEvent):void 
		{
			if (!ballin)
			{
      			doRotation = true;
      			lastMouseX = event.localX//event.stageX;
      			lastMouseY = event.localY//event.stageY;
   			}
    	}
    	// called when mouse up on stage
    	public function onMouseUp(event:MouseEvent):void 
    	{
    		if (!ballin)
      			doRotation = false;
    	}
    	
    	public function mouseclick1():void 
    	{
    		
      		//cameraPitch = tempPtich;
		    //cameraYaw = tempYaw;
		    
		    
		  //  for (var i:int = 1; i <= n; )
		  //  {
		    	 
		    	
		    //	default_camera.orbit(cameraPitch, cameraYaw);
		    //	
			//    wood.setrotate(cameraPitch, cameraYaw);
	   		//	water.setrotate(cameraPitch, cameraYaw);
	   		//	fire.setrotate(cameraPitch, cameraYaw);
	   		//	soil.setrotate(cameraPitch, cameraYaw);
	   		//	gold.setrotate(cameraPitch, cameraYaw);
	   		tempcameraPitch = cameraPitch;
	   		tempcameraYaw = cameraYaw;
	   			
	   		time1.reset();
	   		time1.start();
	   		
	   			
	   		//	if(10 == timecount)
	   		//	{
	   		//		cameraPitch += dertaPitch;
		   // 	cameraYaw += dertaYaw;
	   		//		++i;
	   		//	}
   			//}
    	}
    	
    	public function mouseclick2():void 
    	{
    		tempcameraPitch = cameraPitch;
	   		tempcameraYaw = cameraYaw;
	   		
    		time2.reset();
	   		time2.start();
	   		
   			
    	}
    	
    	public function distance(sphere1:ball, sphere2:ball):Number
		{
			return Math.sqrt(Math.pow(sphere1.x - sphere2.x, 2) + Math.pow(sphere1.y - sphere2.y, 2) + Math.pow(sphere1.z - sphere2.z, 2));
		}
		
		private function timer1(event:TimerEvent):void 
		{ 
			var tempPitch:Number = 30;
    		var tempYaw:Number = -200;
      		var n:int = 10;
      		var dertaPitch:Number = (tempPitch - tempcameraPitch)/n;
      		var dertaYaw:Number = (tempYaw - tempcameraYaw)/n
			ro1(cameraPitch += dertaPitch, cameraYaw += dertaYaw); 		    
		} 
		private function ro1(cameraPitch:Number, cameraYaw:Number):void
		{
			if(!flag)
		    {
				default_camera.orbit(cameraPitch, cameraYaw);
			    
				wood.setrotate(cameraPitch, cameraYaw);
		   		water.setrotate(cameraPitch, cameraYaw);
		   		fire.setrotate(cameraPitch, cameraYaw);
		   		soil.setrotate(cameraPitch, cameraYaw);
		   		gold.setrotate(cameraPitch, cameraYaw);
	   		}
		}
		private function onComplete1(e:TimerEvent):void{   
        	var light:PointLight3D = new PointLight3D(true);
      		light.x = 0;
      		light.y = 0;
      		light.z = 0;
			var Material:MaterialObject3D = new GouraudMaterial(light,0xaaaaaa,0x123456);
			
			soiltowater.setChildMaterial(soiltowater.cylinder, Material, soiltowater.cylinder.material);
			soiltowater.setChildMaterial(soiltowater.cone, Material, soiltowater.cone.material);
			soidtogold.setChildMaterial(soidtogold.cylinder, Material, soidtogold.cylinder.material);
			soidtogold.setChildMaterial(soidtogold.cone, Material, soidtogold.cone.material);
			var Material1:MaterialObject3D = new GouraudMaterial(light,0xaaaaaa,0x654321);
		    goldtowater.setChildMaterial(goldtowater.cylinder, Material1, goldtowater.cylinder.material);
			goldtowater.setChildMaterial(goldtowater.cone, Material1, goldtowater.cone.material);
			watertofire.setChildMaterial(watertofire.cylinder, Material1, watertofire.cylinder.material);
			watertofire.setChildMaterial(watertofire.cone, Material1, watertofire.cone.material);
			woodtofire.setChildMaterial(woodtofire.cylinder, Material1, woodtofire.cylinder.material);
			woodtofire.setChildMaterial(woodtofire.cone, Material1, woodtofire.cone.material);
			firetogold.setChildMaterial(firetogold.cylinder, Material1, firetogold.cylinder.material);
			firetogold.setChildMaterial(firetogold.cone, Material1, firetogold.cone.material);
			watertowood.setChildMaterial(watertowood.cylinder, Material1, watertowood.cylinder.material);
			watertowood.setChildMaterial(watertowood.cone, Material1, watertowood.cone.material);
			goldtowood.setChildMaterial(goldtowood.cylinder, Material1, goldtowood.cylinder.material);
			goldtowood.setChildMaterial(goldtowood.cone, Material1, goldtowood.cone.material);
             if(!flag)
		    {
		    	default_scene.removeChild(goldtowood);
		    	default_scene.removeChild(watertofire);
		    	default_scene.removeChild(woodtosoil);
		    	default_scene.removeChild(firetosoil);
		    	default_scene.addChild(soiltowood);
		    	default_scene.addChild(soiltofire);
		    }
		    flag = true;
		    
        }   
		private function timer2(event:TimerEvent):void 
		{ 
			var tempPitch:Number = 90;
    		var tempYaw:Number = -90;
      		var n:int = 10;
      		var dertaPitch:Number = (tempPitch - tempcameraPitch)/n;
      		var dertaYaw:Number = (tempYaw - tempcameraYaw)/n
			ro2(cameraPitch += dertaPitch, cameraYaw += dertaYaw); 
		    
		   
		    
		} 
		private function ro2(cameraPitch:Number, cameraYaw:Number):void
		{
			if(flag)
		    {
				default_camera.orbit(cameraPitch, cameraYaw);
			    
				wood.setrotate(cameraPitch, cameraYaw);
		   		water.setrotate(cameraPitch, cameraYaw);
		   		fire.setrotate(cameraPitch, cameraYaw);
		   		soil.setrotate(cameraPitch, cameraYaw);
		   		gold.setrotate(cameraPitch, cameraYaw);
	   		}
		}
		private function onComplete2(e:TimerEvent):void
		{   
            var light:PointLight3D = new PointLight3D(true);
      		light.x = 0;
      		light.y = 0;
      		light.z = 0;
      		var Material:MaterialObject3D = new GouraudMaterial(light,0xaaaaaa,0xffffff);
		    watertowood.setChildMaterial(watertowood.cylinder, Material, watertowood.cylinder.material);
			watertowood.setChildMaterial(watertowood.cone, Material, watertowood.cone.material);
			woodtofire.setChildMaterial(woodtofire.cylinder, Material, woodtofire.cylinder.material);
			woodtofire.setChildMaterial(woodtofire.cone, Material, woodtofire.cone.material);
			firetosoil.setChildMaterial(firetosoil.cylinder, Material, firetosoil.cylinder.material);
			firetosoil.setChildMaterial(firetosoil.cone, Material, firetosoil.cone.material);
			soidtogold.setChildMaterial(soidtogold.cylinder, Material, soidtogold.cylinder.material);
			soidtogold.setChildMaterial(soidtogold.cone, Material, soidtogold.cone.material);
			goldtowater.setChildMaterial(goldtowater.cylinder, Material, goldtowater.cylinder.material);
			goldtowater.setChildMaterial(goldtowater.cone, Material, goldtowater.cone.material);
			var Material1:MaterialObject3D = new GouraudMaterial(light,0xaaaaaa,0x000000);
			watertofire.setChildMaterial(watertofire.cylinder, Material1, watertofire.cylinder.material);
			watertofire.setChildMaterial(watertofire.cone, Material1, watertofire.cone.material);
			woodtosoil.setChildMaterial(woodtosoil.cylinder, Material1, woodtosoil.cylinder.material);
			woodtosoil.setChildMaterial(woodtosoil.cone, Material1, woodtosoil.cone.material);
			firetogold.setChildMaterial(firetogold.cylinder, Material1, firetogold.cylinder.material);
			firetogold.setChildMaterial(firetogold.cone, Material1, firetogold.cone.material);
			soiltowater.setChildMaterial(soiltowater.cylinder, Material1, soiltowater.cylinder.material);
			soiltowater.setChildMaterial(soiltowater.cone, Material1, soiltowater.cone.material);
			goldtowood.setChildMaterial(goldtowood.cylinder, Material1, goldtowood.cylinder.material);
			goldtowood.setChildMaterial(goldtowood.cone, Material1, goldtowood.cone.material);
			
		    if(flag)
		    {
		    	default_scene.addChild(goldtowood);
		    	default_scene.addChild(watertofire);
		    	default_scene.removeChild(soiltowood);
		    	default_scene.removeChild(soiltofire);
		    	default_scene.addChild(woodtosoil);
		    	default_scene.addChild(firetosoil);
		    }
		    flag = false;
        } 
        
        public function changname():void
        {
        	wood.changename("木","肝",cameraPitch,cameraYaw);
        	water.changename("水","肾",cameraPitch,cameraYaw);
        	fire.changename("火","心",cameraPitch,cameraYaw);
        	gold.changename("金","肺",cameraPitch,cameraYaw);
        	soil.changename("土","脾",cameraPitch,cameraYaw);
        	cameraPitch = 90;
    		cameraYaw = -90;
    		default_camera.orbit(cameraPitch, cameraYaw);
   				//default_camera.orbit(90, -90);    //default camera angle
   			wood.setrotate(cameraPitch, cameraYaw);
   			water.setrotate(cameraPitch, cameraYaw);
   			fire.setrotate(cameraPitch, cameraYaw);
   			soil.setrotate(cameraPitch, cameraYaw);
   			gold.setrotate(cameraPitch, cameraYaw);
        }
        
        private function clickInteractiveHandle(e:InteractiveScene3DEvent):void
		{
			
			var object:DisplayObject3D = e.displayObject3D;
			if (model)
			{
				switch(object.name)
				{
					case "wood":
						na ="肝";
					break;
					case "fire":
						na ="心";
					break;
					case "water":
						na ="肾";
					break;
					case "gold":
						na ="肺";
					break;
					case "soil":
						na ="脾";
					break;
				}
			}
			
			else
				na = "";
				trace(na)
		}
		private function overInteractiveHandle(e:InteractiveScene3DEvent):void
		{
			ballin = true;
		}
		private function outInteractiveHandle(e:InteractiveScene3DEvent):void
		{
			ballin = false;
			na="";
			trace("adsfas")	
		}
	}
}