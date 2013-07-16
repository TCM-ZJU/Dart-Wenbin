package dart
{
	import flash.events.Event;
	public class LoadEvent extends Event
	{
		public static  const LOADXML:String="loadxml";
		public var result:XML;
		public function LoadEvent(type:String,bubbles:Boolean=false,cancelable:Boolean=false)
		{
			super(type,false,false);
		}
		override public  function clone():Event
		{
			return new LoadEvent(result);
		}
	}
}
