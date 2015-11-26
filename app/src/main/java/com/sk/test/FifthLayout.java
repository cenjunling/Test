package com.sk.test;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sk on 2015/11/7.
 */
public class FifthLayout extends LinearLayout {
	
	public FifthLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setOrientation(LinearLayout.VERTICAL);
		LayoutInflater.from(context).inflate(R.layout.fifth_layout, this);
		
		initSpinner(context);
		initChronometer();
		initScroll();
		initTextSwitcher(context);
	}
	
	private void initTextSwitcher(Context context) {
		final TextSwitcher text = (TextSwitcher) findViewById(R.id.text_switcher);
		Button button = (Button) findViewById(R.id.text_switcher_button);
		Animation in = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
		Animation out = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
		text.setInAnimation(in);
		text.setOutAnimation(out);
		text.setText("12312312");
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				text.setText(Math.random() > 0.5 ? "555555555" : "123123123");
			}
		});
	}
	
	private void initScroll() {
		TextView text = (TextView) findViewById(R.id.scroll_text);
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
		text.append("aaaa\n");
	}
	
	private void initChronometer() {
		Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
		chronometer.setFormat(null);
		chronometer.start();
		chronometer.setBase(SystemClock.elapsedRealtime());
	}
	
	private void initSpinner(Context context) {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Log.i("Spinner", view.toString() + " " + position + " " + id);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Log.i("Spinner", "onNothingSelected");
			}
		});
		
		spinner.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.i("Spinner", "onTouch");
				return false;
			}
		});
		
		spinner.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				Log.i("Spinner", "onFocusChange");
			}
		});
	}
	
}
