package com.sk.test.server;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by sk on 2015/11/15.
 */
public class RunningService extends Service {
	
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		final PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, new Intent(this, RunningReceiver.class), 0);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				int num = 0;
				while(num < 5){
					num ++;
					Log.i("RunningService", "while num:" + num);
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Long time = SystemClock.elapsedRealtime() + 1000 * 2;
				Log.i("RunningService", "time:" + time);
				AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
				alarmManager.setExact(AlarmManager.ELAPSED_REALTIME, time, pIntent);
			}
		}).start();
		
		return super.onStartCommand(intent, flags, startId);
	}
}
