package com.sk.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by sk on 2015/11/6.
 */
public class ThirdLayout extends FrameLayout {
	public ThirdLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater.from(context).inflate(R.layout.third_layout, this);
		
		
		final EditText editText2 = (EditText) findViewById(R.id.edit_text_2);
		editText2.setSelection(2);
		
		final EditText editText = (EditText) findViewById(R.id.edit_text);
		editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				Log.i("ThirdLayout", "" + actionId + " " + event);
				editText.setSelection(2, 4);
				return false;
			}
		});
		
		final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_horizontal);
		progressBar.incrementProgressBy(1);
		
		View btn = findViewById(R.id.third_btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				progressBar.incrementProgressBy(1);
			}
		});
		
		SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar);
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				Log.i("SeekBar", "onProgressChanged " + seekBar.getProgress() + " " + progress + " " + fromUser);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				Log.i("SeekBar", "onStartTrackingTouch " + seekBar.getProgress());
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				Log.i("SeekBar", "onStopTrackingTouch " + seekBar.getProgress());
			}
		});
		seekBar.setProgress(80);
	}
}
