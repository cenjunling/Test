package com.sk.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by sk on 2015/11/5.
 */
public class SecondLayout extends FrameLayout {
	public SecondLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater.from(context).inflate(R.layout.second_layout, this);
		
		DatePicker datePicker = (DatePicker) findViewById(R.id.date_picker);
		Calendar calendar = Calendar.getInstance();
		datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				Log.i("", year + " " + monthOfYear + " " + dayOfMonth);
			}
		});
		
		TimePicker timePicker = (TimePicker) findViewById(R.id.time_picker);
		timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				Log.i("", hourOfDay + " " + minute);
			}
		});
		
		TextClock textClock = (TextClock) findViewById(R.id.text_clock);
		textClock.setFormat24Hour("yyyy-dd-MM hh:mm");
	}
}
