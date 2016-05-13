package com.example.syndicate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;

import android.os.Environment;
import android.support.v4.view.ViewGroupCompat;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;




public class gallery extends Activity{
	private ImageAdapter imageAdapter;
	ArrayList<File> list;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.setContentView(R.layout.gallery);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        //list = imageReader(Environment.getExternalStorageDirectory());
        
            
        
        
        imageAdapter = new ImageAdapter(this);
        gridview.setAdapter(imageAdapter);
 
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
 
        String targetPath = ExternalStorageDirectoryPath + "/Syndicate";
 
        //Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);
 
        File[] files = targetDirector.listFiles();
        for (File file : files){
            imageAdapter.add(file.getAbsolutePath());
        }
        
        
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				// Sending image id to FullScreenActivity
				Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
				// passing array index
				i.putExtra("id",position);
				startActivity(i);
			}
		});
        
        
        
    }
	
	
}