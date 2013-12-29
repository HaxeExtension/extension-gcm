package gcmex;

class GCM {
	public static var checkPlayServices(default,null):Void->Bool=
	#if android
		openfl.utils.JNI.createStaticMethod("com/gcmex/GCM", "checkPlayServices", "()Z");
	#else
		function():Bool{return false;}
	#end

	public static var getRegistrationId(default,null):Void->String=
	#if android
		openfl.utils.JNI.createStaticMethod("com/gcmex/GCM", "getRegistrationId_Static", "()Ljava/lang/String;");
	#else
		function():String{return null;}
	#end

	public static var init(default,null):String->Void=
	#if android
		openfl.utils.JNI.createStaticMethod("com/gcmex/GCM", "init", "(Ljava/lang/String;)V");
	#else
		function(senderId:String):Void{}
	#end

	public static var sendMessage(default,null):String->Void=
	#if android
		openfl.utils.JNI.createStaticMethod("com/gcmex/GCM", "sendMessage", "(Ljava/lang/String;)V");
	#else
		function(msg:String):Void{}
	#end

}
