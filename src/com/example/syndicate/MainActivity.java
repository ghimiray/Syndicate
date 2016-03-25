package com.example.syndicate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;




public class MainActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View btnGalleryClick = findViewById(R.id.btnGallery);
		View btnHelpClick = findViewById(R.id.btnHelp);
		View btnRecogniser = findViewById(R.id.btnRecogniser);
        //set event listener
		btnGalleryClick.setOnClickListener(this);
		btnHelpClick.setOnClickListener(this);
		btnRecogniser.setOnClickListener(this);
		
        
    }
	
	@Override
	public void onClick(View arg0) {
		if(arg0.getId() == R.id.btnGallery){
			//define a new Intent for the second Activity
			Intent intent = new Intent(this,gallery.class);
			//start the second Activity
			this.startActivity(intent);
			
		}
		if(arg0.getId() == R.id.btnHelp){
			//define a new Intent for the second Activity
			Intent intent = new Intent(this,help.class);
			//start the second Activity
			this.startActivity(intent);
			
		}
		if(arg0.getId() == R.id.btnRecogniser){
			//define a new Intent for the second Activity
			Intent intent = new Intent(this,recogniser.class);
			//start the second Activity
			this.startActivity(intent);
			
		}
		
	}
}

