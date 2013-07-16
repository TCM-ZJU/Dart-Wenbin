package dart
{
	
	import flash.events.MouseEvent;
	
	import org.papervision3d.events.InteractiveScene3DEvent;
	
	public class frame extends PaperBase
	{
		private var lastMouseX:Number;
    	private var lastMouseY:Number;
    	private var doRotation:Boolean = false;
    	private var cameraPitch:Number = 90;
    	private var cameraYaw:Number = -90;
    	
    	private var ball1:ball;
    	private var ball2:ball;
    	private var ball3:ball;
    	private var ball4:ball;
    	private var ball5:ball;
    	private var ball6:ball;
    	private var ball7:ball;
    	private var ball8:ball;
    	private var ball9:ball;
    	private var ball10:ball;
    	private var ball11:ball;
    	private var ball12:ball;
    	private var ball13:ball;
    	private var ball14:ball;
    	private var ball15:ball;
    	private var ball16:ball;
    	private var ball17:ball;
    	private var ball18:ball;
    	private var ball19:ball;
    	private var ball20:ball;
    	
    	private var yinaxis:arrowline;
    	private var yangaxis:arrowline;
    	private var tempratureaxis:arrowline;
    	private var airnumaxis:arrowline;
    	private var speedaxis:arrowline;
    	
    	private var textstr:String;
    	private var textyin:MyText;
    	private var textyang:MyText;
    	private var texttemprature:MyText;
    	private var textairnum:MyText;
    	private var textspeed:MyText;
    	
    	public var ballin:Boolean = false;
    	private var sa:Array = new Array();
    	private var flag:Boolean = true;
    	
		public function frame(name:String)
		{
			
			
			switch (name) {

                case "肝气" :
						sa=["肝气", "肝阴虚", "肝阴盛", "肝阳虚", "肝阳盛", "阴阳两虚", "阳虚阴盛", "阴虚阳盛", "阴阳两盛",
						"肝气虚证", "肝阴虚证", "气脱", "肝阳上亢", "肝阳虚证", "肝火炽盛", "肝虚寒证", "气滞", "寒滞肝脉", 
						"", "气闭"];
                        break;
                case "肝血" :
                        break;
                case "肝精" :

                        break;
                case "肝神" :

                        break;
                case "肝律液" :

                        break;
                case "肺气" :
						sa=["肺气", "肺阴虚", "肺阴盛", "肺阳虚", "肺阳盛", "阴阳两虚", "阳虚阴盛", "阴虚阳盛", "阴阳两盛",
						"肺气虚证", "肺阴虚证", "气脱", "阴虚火旺", "肺阳虚证", "肺热炽盛", "寒饮蕴肺", "气滞", "寒痰阻肺", 
						"肺气壅盛", "气闭"];
                        break;
                case "肺血" :

                        break;
                case "肺精" :

                        break;
                case "肺神" :

                        break;
                case "肺律液" :

                        break;
                case "肾气" :
						sa=["肾气", "肾阴虚", "肾阴盛", "肾阳虚", "肾阳盛", "阴阳两虚", "阳虚阴盛", "阴虚阳盛", "阴阳两盛",
						"肾虚不固", "肾阴虚证", "气脱", "阴虚火旺", "肾阳虚证", "", "阳虚水泛", "气滞", "", 
						"", "气闭"];
                        break;
                case "肾血" :

                        break;
                case "肾精" :

                        break;
                case "肾神" :

                        break;
                case "肾律液" :

                        break;
                case "脾气" :
						sa=["脾气", "脾阴虚", "脾阴盛", "脾阳虚", "脾阳盛", "阴阳两虚", "阳虚阴盛", "阴虚阳盛", "阴阳两盛",
						"脾气虚证", "脾阴虚证", "气脱", "阴虚火旺", "脾阳虚证", "湿热蕴脾", "阳虚脾寒", "气滞", "寒湿困脾", 
						"", "气闭"];
                        break;
                case "脾血" :

                        break;
                case "脾精" :

                        break;
                case "脾神" :

                        break;
                case "脾律液" :

                        break;
                case "心气" :
						sa=["心气", "心阴虚", "心阴盛", "心阳虚", "心阳盛", "阴阳两虚", "阳虚阴盛", "阴虚阳盛", "阴阳两盛",
						"心气虚证", "心阴虚证", "气脱", "阴虚火旺", "心阳虚证", "心火亢盛", "心阳虚寒", "气滞", "寒凝心脉", 
						"", "气闭"];
                        break;
                case "心血" :

                        break;
                case "心精" :

                        break;
                case "心神" :

                        break;
                case "心律液" :

                        break;

                default :
						;

        	}


			init();
   			//stage.addEventListener(MouseEvent.MOUSE_DOWN, onMouseDown);
      		//stage.addEventListener(MouseEvent.MOUSE_UP, onMouseUp);
		}
		
		override protected function init3d():void
  		{
  			var length:Number = 700;
  			var color:uint = 0xaaaaaa;
  			var distance:Number = 150;
  			var radius:Number = 70;
  			if (flag)
  			{
  				textstr = "阴";
  				yinaxis = new arrowline(700, 550, 0, -700, 550, 0, 0, 0, 0xffffff,0x000000, 3, 6, 30);
  				yangaxis = new arrowline(-700, -450, 0, -700, 550, 0, 0, 0, 0xffffff,0x000000, 3, 6, 30);
  			}
  			tempratureaxis = new arrowline(-length / 2 * Math.sqrt(2), -length / 2 * Math.sqrt(2), 0, length / 2 * Math.sqrt(2), length / 2 * Math.sqrt(2), 0, 0, 0, 0xffffff,0xaaaaaa, 20, 30, 60);
  			airnumaxis = new arrowline(length / 2 * Math.sqrt(2), -length / 2 * Math.sqrt(2), 0, -length / 2 * Math.sqrt(2), length / 2 * Math.sqrt(2), 0, 0, 0, 0xffffff,0xaaaaaa, 20, 30, 60);
  			speedaxis = new arrowline(0, 0, -length, 0, 0, length, 0, 0, 0xffffff,0xaaaaaa, 20, 30, 60);
  			if (sa[0] != null && sa[0] != "")
  			{
  				ball1 = new ball(sa[0], 0x92d14f, color, radius);
  				ball1.x = 0;
  				ball1.y = 0;
  				ball1.z = 0;
  				ball1.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball1.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[1] != null && sa[1] != "")
  			{
  				ball2 = new ball(sa[1], 0xffc000, color, radius);
	  			ball2.x = -distance * Math.sqrt(2);
	  			ball2.y = 0;
	  			ball2.z = 0;
	  			ball2.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball2.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[2] != null && sa[2] != "")
  			{
  				ball3 = new ball(sa[2], 0x72bfd3, color, radius);
	  			ball3.x = distance * Math.sqrt(2);
	  			ball3.y = 0;
	  			ball3.z = 0;
	  			ball3.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball3.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[3] != null && sa[3] != "")
  			{
  				ball4 = new ball(sa[3], 0x507bae, color, radius);
	  			ball4.x = 0;
	  			ball4.y = distance * Math.sqrt(2);
	  			ball4.z = 0;
	  			ball4.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball4.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[4] != null && sa[4] != "")
  			{
  				ball5 = new ball(sa[4], 0xc00002, color, radius);
	  			ball5.x = 0;
	  			ball5.y = -distance * Math.sqrt(2);
	  			ball5.z = 0;
	  			ball5.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball5.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[5] != null && sa[5] != "")
  			{
  				ball6 = new ball(sa[5], 0xd9d9d9, color, radius);
	  			ball6.x = -distance;
	  			ball6.y = distance;
	  			ball6.z = 0;
	  			ball6.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball6.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[6] != null && sa[6] != "")
  			{
  				ball7 = new ball(sa[6], 0x3878d2, color, radius);
	  			ball7.x = distance;
	  			ball7.y = distance;
	  			ball7.z = 0;
	  			ball7.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball7.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[7] != null && sa[7] != "")
  			{
  				ball8 = new ball(sa[7], 0xfe0005, color, radius);
	  			ball8.x = -distance;
	  			ball8.y = -distance;
	  			ball8.z = 0;
	  			ball8.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball8.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[8] != null && sa[8] != "")
  			{
  				ball9 = new ball(sa[8], 0x698135, color, radius);
	  			ball9.x = distance;
	  			ball9.y = -distance;
	  			ball9.z = 0;
	  			ball9.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball9.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[9] != null && sa[9] != "")
  			{
  				ball10 = new ball(sa[9], 0xffffff, color, radius);
	  			ball10.x = - 2 * distance;
	  			ball10.y = 2 * distance;
	  			ball10.z = 0;
	  			ball10.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball10.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[10] != null && sa[10] != "")
  			{
  				ball11 = new ball(sa[10], 0xffffff, color, radius);
	  			ball11.x = -2 * distance * Math.sqrt(2);
	  			ball11.y = 0;
	  			ball11.z = 0;
	  			ball11.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball11.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[11] != null && sa[11] != "")
  			{
  				ball12 = new ball(sa[11], 0xffffff, color, radius);
	  			ball12.x = 0;
	  			ball12.y = 0;
	  			ball12.z = -2 * distance * Math.sqrt(2);
	  			ball12.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball12.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[12] != null && sa[12] != "")
  			{
  				ball13 = new ball(sa[12], 0xffffff, color, radius);
	  			ball13.x = - 2 * distance;
	  			ball13.y = - 2 * distance;
	  			ball13.z = 0;
	  			ball13.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball13.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[13] != null && sa[13] != "")
  			{
  				ball14 = new ball(sa[13], 0xffffff, color, radius);
	  			ball14.x = 0;
	  			ball14.y = 2 * distance * Math.sqrt(2);
	  			ball14.z = 0;
	  			ball14.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball14.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[14] != null && sa[14] != "")
  			{
  				ball15 = new ball(sa[14], 0xffffff, color, radius);
	  			ball15.x = 0;
	  			ball15.y = -2 * distance * Math.sqrt(2);
	  			ball15.z = 0;
	  			ball15.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball15.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[15] != null && sa[15] != "")
  			{
  				ball16 = new ball(sa[15], 0xffffff, color, radius);
	  			ball16.x = 2 * distance;
	  			ball16.y = 2 * distance;
	  			ball16.z = 0;
	  			ball16.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball16.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[16] != null && sa[16] != "")
  			{
  				ball17 = new ball(sa[16], 0xffffff, color, radius);
	  			ball17.x = 0;
	  			ball17.y = 0;
	  			ball17.z = distance * Math.sqrt(2);
	  			ball17.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball17.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[17] != null && sa[17] != "")
  			{
  				ball18 = new ball(sa[17], 0xffffff, color, radius);
	  			ball18.x = 2 * distance * Math.sqrt(2);
	  			ball18.y = 0;
	  			ball18.z = 0;
	  			ball18.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball18.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[18] != null && sa[18] != "")
  			{
  				ball19 = new ball(sa[18], 0xffffff, color, radius);
	  			ball19.x = 2 * distance;
	  			ball19.y = -2 * distance;
	  			ball19.z = 0;
	  			ball19.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball19.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			if (sa[19] != null && sa[19] != "")
  			{
  				ball20 = new ball(sa[19], 0xffffff, color, radius);
	  			ball20.x = 0;
	  			ball20.y = 0;
	  			ball20.z = 2 * distance * Math.sqrt(2);
	  			ball20.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				ball20.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			
  			if (flag)
  			{
  				textyin = new MyText(textstr, "40", "#0000000");
	  			textyin.x = yinaxis.x;
	  			textyin.y = yinaxis.y;
	  			textyin.z = yinaxis.z - yinaxis.Radius;
	  			textstr = "阳";
	  			textyang = new MyText(textstr, "40", "#000000");
	  			textyang.x = yangaxis.x;
	  			textyang.y = yangaxis.y;
	  			textyang.z = yangaxis.z - yangaxis.Radius;
  			}
  			
  			textstr = "温度";
  			texttemprature = new MyText(textstr, "40", "#000000");
  			texttemprature.x = tempratureaxis.x;
  			texttemprature.y = tempratureaxis.y;
  			textyang.z = tempratureaxis.z - tempratureaxis.Radius;
  			textstr = "气数";
  			textairnum = new MyText(textstr, "40", "#000000");
  			textairnum.x = airnumaxis.x;
  			textairnum.y = airnumaxis.y;
  			textairnum.z = airnumaxis.z - airnumaxis.Radius;
  			textstr = "气机速度";
  			textspeed = new MyText(textstr, "40", "#000000");
  			textspeed.x = speedaxis.x;
  			textspeed.y = speedaxis.y;
  			textspeed.z = speedaxis.z - speedaxis.Radius;
  			if (flag)
  			{
  				textyin.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				textyang.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				yinaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  				yangaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  			}
  			
  			texttemprature.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  			textairnum.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  			textspeed.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  			tempratureaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  			airnumaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  			speedaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OVER, overInteractiveHandle);
  			
  			
  			if (flag)
  			{
  				textyin.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
	  			textyang.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
	  			yinaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
	  			yangaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			}
  			
  			texttemprature.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			textairnum.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			textspeed.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			
  			tempratureaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			airnumaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			speedaxis.addEventListener(InteractiveScene3DEvent.OBJECT_OUT, outInteractiveHandle);
  			
  			
  			if (flag)
  			{
  				default_scene.addChild(textyin);
	  			default_scene.addChild(textyang);
	  			default_scene.addChild(yinaxis);
	  			default_scene.addChild(yangaxis);
  			}
  			
  			default_scene.addChild(texttemprature);
  			default_scene.addChild(textairnum);
  			default_scene.addChild(textspeed);
  			default_scene.addChild(tempratureaxis);
  			default_scene.addChild(airnumaxis);
  			default_scene.addChild(speedaxis);
  			if (sa[0] != null && sa[0] != "")
  				default_scene.addChild(ball1);
  			if (sa[1] != null && sa[1] != "")
  				default_scene.addChild(ball2);
  			if (sa[2] != null && sa[2] != "")
  				default_scene.addChild(ball3);
  			if (sa[3] != null && sa[3] != "")
  				default_scene.addChild(ball4);
  			if (sa[4] != null && sa[4] != "")
  				default_scene.addChild(ball5);
  			if (sa[5] != null && sa[5] != "")
  				default_scene.addChild(ball6);
  			if (sa[6] != null && sa[6] != "")
  			    default_scene.addChild(ball7);
  			if (sa[7] != null && sa[7] != "")
  				default_scene.addChild(ball8);
  			if (sa[8] != null && sa[8] != "")
  				default_scene.addChild(ball9);
  			if (sa[9] != null && sa[9] != "")
  				default_scene.addChild(ball10);
  			if (sa[10] != null && sa[10] != "")
  				default_scene.addChild(ball11);
  			if (sa[11] != null && sa[11] != "")
  				default_scene.addChild(ball12);
  			if (sa[12] != null && sa[12] != "")
  				default_scene.addChild(ball13);
  			if (sa[13] != null && sa[13] != "")
  				default_scene.addChild(ball14);
  			if (sa[14] != null && sa[14] != "")
  				default_scene.addChild(ball15);
  			if (sa[15] != null && sa[15] != "")
  				default_scene.addChild(ball16);
  			if (sa[16] != null && sa[16] != "")
  				default_scene.addChild(ball17);
  			if (sa[17] != null && sa[17] != "")
  				default_scene.addChild(ball18);
  			if (sa[18] != null && sa[18] != "")
  				default_scene.addChild(ball19);
  			if (sa[19] != null && sa[19] != "")
  				default_scene.addChild(ball20);
  		}
  		
  		override protected function processFrame():void
  		{
  			if (doRotation) {
		        // convert the change in mouse position into a change in camera angle
		        var panelx:Number = 325;
		        var panely:Number = -25;
		        var dPitch:Number = (mouseY + panely - lastMouseY) / 2;
		        var dYaw:Number = (mouseX + panelx - lastMouseX) / 2;
		        trace(mouseY)
		        trace(lastMouseY)
		        trace(mouseX)
		        trace(lastMouseX)
		        trace(dPitch)
		        trace(dYaw)
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
        		textyin.setrotate(cameraPitch, cameraYaw, yinaxis.Radius, yinaxis.x, yinaxis.y, yinaxis.z);
        		textyang.setrotate(cameraPitch, cameraYaw, yangaxis.Radius, yangaxis.x, yangaxis.y, yangaxis.z);
        		texttemprature.setrotate(cameraPitch, cameraYaw, tempratureaxis.Radius, tempratureaxis.x, tempratureaxis.y, tempratureaxis.z);
        		textairnum.setrotate(cameraPitch, cameraYaw, airnumaxis.Radius, airnumaxis.x, airnumaxis.y, airnumaxis.z);
        		textspeed.setrotate(cameraPitch, cameraYaw, speedaxis.Radius, speedaxis.x, speedaxis.y, speedaxis.z);
        		if (sa[0] != null && sa[0] != "")
	        		ball1.setrotate(cameraPitch, cameraYaw);
	        	if (sa[1] != null && sa[1] != "")
	        		ball2.setrotate(cameraPitch, cameraYaw);
	        	if (sa[2] != null && sa[2] != "")
	        		ball3.setrotate(cameraPitch, cameraYaw);
	        	if (sa[3] != null && sa[3] != "")
	        		ball4.setrotate(cameraPitch, cameraYaw);
	        	if (sa[4] != null && sa[4] != "")
	        		ball5.setrotate(cameraPitch, cameraYaw);
	        	if (sa[5] != null && sa[5] != "")
	        		ball6.setrotate(cameraPitch, cameraYaw);
	        	if (sa[6] != null && sa[6] != "")
	        		ball7.setrotate(cameraPitch, cameraYaw);
	        	if (sa[7] != null && sa[7] != "")
	        		ball8.setrotate(cameraPitch, cameraYaw);
	        	if (sa[8] != null && sa[8] != "")
	        		ball9.setrotate(cameraPitch, cameraYaw);
	        	if (sa[9] != null && sa[9] != "")
	        		ball10.setrotate(cameraPitch, cameraYaw);
	        	if (sa[10] != null && sa[10] != "")
	        		ball11.setrotate(cameraPitch, cameraYaw);
	        	if (sa[11] != null && sa[11] != "")
	        		ball12.setrotate(cameraPitch, cameraYaw);
	        	if (sa[12] != null && sa[12] != "")
	        		ball13.setrotate(cameraPitch, cameraYaw);
	        	if (sa[13] != null && sa[13] != "")
	        		ball14.setrotate(cameraPitch, cameraYaw);
	        	if (sa[14] != null && sa[14] != "")
	        		ball15.setrotate(cameraPitch, cameraYaw);
	        	if (sa[15] != null && sa[15] != "")
	        		ball16.setrotate(cameraPitch, cameraYaw);
	        	if (sa[16] != null && sa[16] != "")
	        		ball17.setrotate(cameraPitch, cameraYaw);
	        	if (sa[17] != null && sa[17] != "")
	        		ball18.setrotate(cameraPitch, cameraYaw);
	        	if (sa[18] != null && sa[18] != "")
	        		ball19.setrotate(cameraPitch, cameraYaw);
	        	if (sa[19] != null && sa[19] != "")
	        		ball20.setrotate(cameraPitch, cameraYaw);
        		default_camera.orbit(cameraPitch, cameraYaw);
        		
   				//default_camera.orbit(90, -90);    //default camera angle
   				//wood.setrotate(cameraPitch, cameraYaw);
   				
   				//wood.getChildByName("aaa").rotationX = 90 - xx;
   				//wood.getChildByName("aaa").rotationY = -90 - yy;
        		
        		
      		}
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
    		{
      			doRotation = false;
      		}
    	}
    	private function overInteractiveHandle(e:InteractiveScene3DEvent):void
		{
			ballin = true;
		}
		private function outInteractiveHandle(e:InteractiveScene3DEvent):void
		{
			ballin = false;
		}
	}
}