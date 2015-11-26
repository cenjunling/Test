package com.sk.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sk.test.server.RunningReceiver;
import com.sk.test.server.RunningService;

public class MainActivity extends AppCompatActivity {
	enum Strategy{
		WALK,PLANE,SUBWAY,ABC,EBF
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Strategy strategy = Math.random() > 0.5? Strategy.SUBWAY : Strategy.WALK;
		if (strategy == Strategy.WALK) {
			Log.i("", "");
		}
		switch (strategy) {
			case WALK:
				break;
			case PLANE:
				break;
			case SUBWAY:
				break;
		}
		Log.i("MainActivity", "onCreate");
		Intent I = new Intent(this, RunningService.class);
		startService(I);
		//FifthLayout layout = new FifthLayout(this, null);
		//addContentView(layout, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		TextView tv = $(R.id.edit_1);
		tv.getText();
	}
	
	
	public <T extends View> T $(int id) {
		return (T) findViewById(id);
	}
	
}
