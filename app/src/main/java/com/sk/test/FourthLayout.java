package com.sk.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.ZoomButton;
import android.widget.ZoomControls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sk on 2015/11/6.
 */
public class FourthLayout extends FrameLayout {
	
	public FourthLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater.from(context).inflate(R.layout.fourth_layout, this);
		AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.auto_text);
		
		List<String> arr = new ArrayList<String>();
		arr.add("aabc");
		arr.add("aaa");
		arr.add("aab");
		arr.add("baa");
		arr.add("bba");
		arr.add("aabba");
		ArrayAdapter<String> adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, arr);
		auto.setAdapter(adapter);
		auto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Log.i("AutoCompleteTextView", "" + position + " " + id);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Log.i("AutoCompleteTextView", "onNothingSelected");
			}
		});
		
		
		MultiAutoCompleteTextView mAuto = (MultiAutoCompleteTextView) findViewById(R.id.multi_auto_text);
		mAuto.setAdapter(adapter);
		mAuto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		mAuto.setThreshold(2);
		mAuto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Log.i("Multi AutoCompleteTextView", "" + position + " " + id);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Log.i("Multi AutoCompleteTextView", "onNothingSelected");
			}
		});
		
		final ZoomControls zoomControls = (ZoomControls) findViewById(R.id.zoom_controls);
		OnClickListener clickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("zoom" + v, ""+zoomControls);
				if (v == zoomControls) {
					Log.i("zoom", "+++++");
				} else {
					Log.i("zoom", "-------");
					
				}
			}
		};
		zoomControls.setOnZoomInClickListener(clickListener);
		zoomControls.setOnZoomOutClickListener(clickListener);
		zoomControls.setZoomSpeed(12);
		zoomControls.setIsZoomInEnabled(true);
		
		RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_bar);
		ratingBar.setNumStars(6);
		ratingBar.setMax(6);
		ratingBar.setProgress(4);
		ratingBar.setRating(1.3f);
		ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				Log.i("RatingBar", rating + " " + fromUser);
			}
		});
//		findViewById(R.id.view_stub_1).setVisibility(View.VISIBLE);
//		findViewById(R.id.view_stub_2).setVisibility(View.VISIBLE);
		//((ViewStub) findViewById(R.id.view_stub_2)).inflate();
	}
	
}
