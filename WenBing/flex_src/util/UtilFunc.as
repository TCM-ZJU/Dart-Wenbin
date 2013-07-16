package util
{
	import mx.collections.ArrayCollection;
	
	public class UtilFunc
	{
		public static function hash(string:String, val:int = 10):int
		{
			if (val < 1)
			{
				return -1;
			}
			var res:int = 0;
			for (var i:int = 0; i < string.length; i++)
			{
				res = res + string.charCodeAt(i);
			}
			return res%val;
		}
			
		public static function find(source:Object, target:Object, fieldName:String = ""):Object
		{
			var i:int;
			var len:int;
			var item:Object;
			var s:Array;
			if (source is ArrayCollection)
			{
				s = (source as ArrayCollection).source;
			}
			if (source is Array)
			{
				s = source as Array;
			}
			if (s != null)
			{
				len = s.length;
				for (i = 0; i < len; i++)
				{
					item = s[i];
					if (fieldName == "")
					{
						if (item == target)
						{
							return item;
						}
					}
					else
					{
						if(item[fieldName] == target[fieldName])
						{
							return item;
						}
					}
				}
			}
			return null;
		}
		
		public static function findIndex(source:Object, target:Object, fieldName:String = ""):int
		{
			var i:int;
			var len:int;
			var item:Object;
			var s:Array;
			if (source is ArrayCollection)
			{
				s = (source as ArrayCollection).source;
			}
			if (source is Array)
			{
				s = source as Array
			}
			if (s != null)
			{
				len = s.length;
				for (i = 0; i < len; i++)
				{
					item = s[i];
					if (fieldName == "")
					{
						if (item == target)
						{
							return i;
						}
					}
					else
					{
						if(item[fieldName] == target[fieldName])
						{
							return i;
						}
					}
				}
			}
			return -1;
		}
	}
}