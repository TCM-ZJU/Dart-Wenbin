package dart
{
 	import flash.display.Sprite;
 	import flash.events.Event;
 	
 	import org.papervision3d.cameras.*;
 	import org.papervision3d.core.proto.CameraObject3D;
 	import org.papervision3d.render.BasicRenderEngine;
 	import org.papervision3d.scenes.Scene3D;
 	import org.papervision3d.view.Viewport3D; //为了让舞台上的对象能显示必须要有一个渲染器
 
 	public class PaperBase extends Sprite { //此处自定义的类PaperBase继承于Sprite
  
	  	public var viewport:Viewport3D; //定义3D观察区或称3D窗口区
	  	public var renderer:BasicRenderEngine; //定义渲染器
	  
	  	public var current_scene:Scene3D;
	  	public var current_camera:CameraObject3D;
	  	public var current_viewport:Viewport3D;
	
	  	public var default_scene:Scene3D; //定义默认的3D场景
	
	  	public var default_camera:Camera3D; //定义默认3D相机
	  	
	  	
	  	
    	

	  
	  	public function init(vpWidth:Number = 550, vpHeight:Number = 400):void {
	   		initPapervision(vpWidth, vpHeight); // 设置初始papervision
	   		init3d(); // 设置3D内容初始值
	   		init2d(); // 设置初始接口
	   		initEvents(); // 设置事件侦听
	   		

	  	}
	  
	  	protected function initPapervision(vpWidth:Number, vpHeight:Number):void 
	  	{
	   		// 本函数功能是初始我们所需要的每一个对象
	   		// 渲染papervision场景
	   		if (vpWidth == 0) 
	   		{//设置3D观察区的范围，也就是在场景中能看到的所有3D对象区域
	    		viewport = new Viewport3D(stage.width, stage.height, true, true);
	   		}
	   		else
	   		{
	    		viewport = new Viewport3D(vpWidth, vpHeight, false, true);
	   		}
	
	   		addChild(viewport); // 在Flash场景中3D观察区是一个对象，我们“看到”的3D对象都是通过此区域范围显示出来，所以必须把其添加到舞台上
	
	   		renderer = new BasicRenderEngine();//定义一个渲染器
	
	   		default_scene = new Scene3D();//定义初始默认3D场景
	
	   		default_camera = new Camera3D();//定义初始默认3D相机
	   		default_camera.x = 0;
	   		default_camera.y = 0;
	   		default_camera.z = -1000;
	   
	   		current_camera = default_camera;
	   		current_scene = default_scene;
	   		current_viewport = viewport;
	   
	  	}
	  
	  	protected function init3d():void 
	  	{
	   		// 由于本类定义的是一个模板，相当于一个基类，
	   		// 所以此处初始后的3D对象相关的属性、方法等的设置，
	   		// 可以在其子类中重新修改定义，
	   		//这里在定义函数时使用了protected限定符，
	   		//在子类就可以使用override来重定义本函数，
	  		//使用override时必须是override protected function init3d():void{...}这样的格式。
	  	}
	  
	  	protected function init2d():void 
	  	{
	   		// 此功能函数作用类似于上述函数，
	   		// 但这里是实现相关的接口，
	   		// 以便进一步扩展类的功能。
	  	}
	  
	  	protected function initEvents():void 
	  	{
	   		// 此函数实现帧频函数功能，
	   		// 目的是为了实现事件侦听。
	   		addEventListener(Event.ENTER_FRAME, onEnterFrame);
	  	}
	  
	  	protected function processFrame():void 
	  	{
	   		// 此函数这样设计是为了更加的灵活处理相关的事件侦听
	   		//当然也可以不用这样定义这个函数，
	   		//直接把相关代码放在下面的onEnterFrame函数中也是一样的效果。
	  	}
	  
	  	protected function onEnterFrame( ThisEvent:Event ):void 
	  	{
	   		//当我们更改了场景中3D对象的属性等时需要刷新它，
	   		//要刷新必须要重新进行渲染场景，
	   		//这样才能让我们看到场景上的3D对象的变化。
	   		processFrame();
	   		renderer.renderScene(current_scene, current_camera, current_viewport);
	  	}
	  	
	  	
  
 	} 
}

