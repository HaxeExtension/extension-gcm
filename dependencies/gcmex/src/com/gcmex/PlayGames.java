package com.gcmex;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.app.Activity;

import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.ConnectionResult;

public class PlayGames implements GameHelper.GameHelperListener {
	
	private static PlayGames instance=null;
	private GoogleApiClient mClient=null;
	private static Activity mActivity=null;
	private static GameHelper mHelper=null;

	public static PlayGames getInstance(){
		if(instance==null) instance=new PlayGames();
		return instance;
	}

	public void init(Activity mainActivity){
		if(mHelper!=null){
	        Log.i(GCM.TAG, "PlayGames: SIGN OUT CALL");
			mHelper.signOut();
			return;
		}

		mActivity=mainActivity;
		mActivity.runOnUiThread(new Runnable() {
                public void run() { 
			        Log.i(GCM.TAG, "PlayGames: INIT CALL");
					mHelper = new GameHelper(mActivity, GameHelper.CLIENT_GAMES);
					getInstance().connect();
			        Log.i(GCM.TAG, "PlayGames: INIT COMPLETE");
                }
        });
	}	

	public void connect(){
        Log.i(GCM.TAG, "PlayGames: CONNECT begin");

		if(mHelper.isSignedIn()){
	        Log.i(GCM.TAG, "PlayGames: - CONNECT - Doing nothing... Already SignedIn");
			return;
		}
		if(mHelper.isConnecting()){
	        Log.i(GCM.TAG, "PlayGames: - CONNECT - Doing nothing... Still connecting");
			return;
		}
	    mHelper.setup(this);
//	    mHelper.connect();
	    mHelper.onStart(mActivity);
//	    mHelper.beginUserInitiatedSignIn();
        Log.i(GCM.TAG, "PlayGames: CONNECT complete");
     }

	public void useLeaderBoard(){
		if(mHelper.isConnecting()){
	        Log.i(GCM.TAG, "PlayGames: useLeaderBoard - WAIT... Still connecting!");
			return;
		}
		if(!mHelper.isSignedIn()){
	        Log.i(GCM.TAG, "PlayGames: useLeaderBoard - Signing IN!");
			mHelper.beginUserInitiatedSignIn();
			return;
		}
        Log.i(GCM.TAG, "PlayGames: useLeaderBoard begin");
		Games.Leaderboards.submitScore(mClient, "111", 1337);
        Log.i(GCM.TAG, "PlayGames: useLeaderBoard complete");
	}


	@Override
    public void onSignInFailed() {
        Log.i(GCM.TAG, "PlayGames: onSignInFailed");
    }

    @Override
    public void onSignInSucceeded() {
        Log.i(GCM.TAG, "PlayGames: onSignInSucceeded");
    }

/*
	@Override
    public void onConnected(Bundle connectionHint) {
        Log.i(GCM.TAG, "onConnected: connected!");
        if (connectionHint != null) {
            Log.i(GCM.TAG, "onConnected: connection hint provided. Maybe was an invitation?");
        }
        connected=true;
    }

    @Override
    public void onConnectionSuspended(int cause) {
        Log.i(GCM.TAG, "onConnectionSuspended, cause=" + cause);
        connected=false;
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // save connection result for later reference
        Log.i(GCM.TAG, "onConnectionFailed");
        connected=false;

        Log.i(GCM.TAG, "Connection failure:");
        Log.i(GCM.TAG, "   - code: " + GameHelperUtils.errorCodeToString(result.getErrorCode()));
        Log.i(GCM.TAG, "   - resolvable: " + result.hasResolution());
        Log.i(GCM.TAG, "   - details: " + result.toString());
    }
*/

}
