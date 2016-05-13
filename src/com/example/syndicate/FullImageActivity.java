package com.example.syndicate;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FullImageActivity extends Activity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.full_image); 
		
		// get intent data
		Intent i = getIntent();
		
		// Selected image id
		//String f = i.getStringExtra("id");
		int position = i.getExtras().getInt("id");
		//ImageAdapter imageAdapter = new ImageAdapter(this);
		ArrayList<String> x = ImageAdapter.imageList;
		String f = x.get(position);
		
		ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
		imageView.setImageURI(Uri.parse(f));
		//imageView.setImageResource(imageAdapter.imageList.get(position));
		//imageView.setImageResource(getImageId(imageAdapter, imageAdapter.imageList);
	}
	
	
	

}
