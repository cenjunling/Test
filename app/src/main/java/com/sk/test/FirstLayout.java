package com.sk.test;

import android.content.Context;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

/**
 * Created by sk on 2015/11/5.
 */
public class FirstLayout extends FrameLayout {
	
	public FirstLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater.from(context).inflate(R.layout.first_layout, this);
		
		init();
		initHandler();
	}
	
	private ProgressBar progressbas;
	private void initHandler() {
		Thread thread = new Thread(myRun);
		thread.start();
//		thread.run();
		progressbas = (ProgressBar) findViewById(R.id.progress);
	}
	
	android.os.Handler handler2 = new android.os.Handler(new android.os.Handler.Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			progressbas.setProgress(msg.arg1);
			return false;
		}
	});
	
	private Runnable myRun = new Runnable() {
		int progressValue;
		@Override
		public void run() {
			while (true) {
				Log.i("run", "");
				progressValue +=5;
				Message msg = new Message();
				msg.arg1 = progressValue;
				handler2.sendMessage(msg);
				if (progressValue > 100) {
					progressValue = 0;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	};
	
	EditText editText1;
	EditText editText2;
	private void init() {
		final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
		checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//Snackbar.make(buttonView, R.layout.snackbar, Snackbar.LENGTH_LONG).show();
				Log.i("", "isChecked:"+checkBox.isChecked());
			}
		});
		
		final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Log.i("", "checkId:" + (checkedId == R.id.radio_2));
				group.getCheckedRadioButtonId();
			}
		});
		
		editText1 = (EditText) findViewById(R.id.edit_1);
		editText2 = (EditText) findViewById(R.id.edit_2);
		editText1.setOnFocusChangeListener(A);
		editText2.setOnFocusChangeListener(A);
		Button btn = (Button) findViewById(R.id.btn);
	}
	
	OnFocusChangeListener A = new OnFocusChangeListener() {
		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			if (v.getId() == editText1.getId()) {
				Log.i("", "1111111111 " + hasFocus);
				Snackbar.make(v, "1111111111 " + hasFocus, Snackbar.LENGTH_SHORT);
			}
			else if (v.getId() == editText2.getId()) {
				Log.i("", "222222222222 " + hasFocus);
				Snackbar.make(v, "2222222222 " + hasFocus, Snackbar.LENGTH_SHORT);
			}
		}
	};
}
