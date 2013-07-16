package util
{
	import flash.events.Event;
	
	import mx.controls.Alert;
	public class checkEvent extends Event
	{
		public var isSel:Boolean;
  		public var data:Object;
		public function checkEvent(_data:Object,_isSel:Boolean)
		{
			isSel = _isSel;
			data = _data;
			super("AddSel");
		}

	}
}