package gcmex;

class GCM {
	public static var checkPlayServices(default,null):Void->Bool=
	#if android
		openfl.utils.JNI.createStaticMethod("gcmex/GCM", "checkPlayServices", "()Z");
	#else
		function():Bool{return false;}
	#end

}
