HOW TO BUILD HAXELIB:
$./build.sh  (on MAC and Linux).
>build.bat (on Windows)

HOW TO INSTALL HAXELIB:
$./install.sh (on MAC and Linux).
>install.bat (on Windows)

HOW TO BUILD AND INSTALL:
$./build.sh && ./install.sh (on MAC and Linux).

>build.bat
>install.bat (on Windows)


HOW TO USE FROM HAXE:
// on some place of your haxe APP
import gcmex.GCM;

function sendMessage(){
	trace("Sending message");
	GCM.sendMessage('{"field1":"HI! How are you...","FIELD2":"TESTING"}');
}

function initGCM() {
	GCM.init('834089498325');
	if(!GCM.checkPlayServices()){
		trace("GCM is not available!");
		return;
	}
	trace("GCM is available!");
	trace("Reg ID: "+GCM.getRegistrationId());
	GCM.onReceive=function(type:String,json:String){
		trace("I've received a message type '"+type+"' containing the json: '"+json+"'");
	}
}
