package dart 
{
	import flash.net.*;
	import flash.events.*;
	import flash.utils.*;
	import flash.net.URLLoaderDataFormat;
	
	public class XMLManager extends  EventDispatcher
	{   
		public function XMLManager()
		{
               
		}		
		public function LoadXML(pach:String):void
		{
			var ld:URLLoader=new URLLoader();
			ld.dataFormat = URLLoaderDataFormat.BINARY;
			ld.load(new URLRequest(pach));
			ld.addEventListener(Event.COMPLETE,resultHandle);
			ld.addEventListener(IOErrorEvent .IO_ERROR,errorhandle);
		}
		
		private function resultHandle(e:Event):void
		{
		
			var bytes:ByteArray = ByteArray(e.target.data);
			trace(bytes)
		    var xmlStr:String = bytes.readMultiByte(bytes.length,"utf-8");
		    trace("************");
		    trace(xmlStr);
			var myxml:XML=XML(xmlStr);
			var sendevent:LoadEvent=new LoadEvent(LoadEvent.LOADXML);
			sendevent.result=myxml;
			this.dispatchEvent(sendevent);
			 
		}
		private function errorhandle(e:Event):void
		{
			throw new Error("加载失败");
			
		}
		
	}
}
