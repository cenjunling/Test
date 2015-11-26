package com.sk.test.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sk on 2015/11/15.
 */
public class RunningReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("RunningReceiver", "onReceive");
		context.startService(new Intent(context, RunningService.class));
	}
}
