package com.example.syndicate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class recogniser extends Activity{
	Button b1;
	   ImageView iv;
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         this.setContentView(R.layout.addimage);
         b1=(Button)findViewById(R.id.btnCamera);
         iv=(ImageView)findViewById(R.id.imageView);
         
         b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(intent, 0);
            }
         });
        
    }
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	      
	      super.onActivityResult(requestCode, resultCode, data);
	      
	      
	      Bitmap bp = (Bitmap) data.getExtras().get("data");
	      iv.setImageBitmap(bp);
	      String root = Environment.getExternalStorageDirectory().toString();
	        File myDir = new File(root + "/Syndicate");    
	        myDir.mkdirs();
	        Random generator = new Random();
	        int n = 10000;
	        n = generator.nextInt(n);
	        String fname = "syndicate"+ n +".jpg";
	        File file = new File (myDir, fname);
	        if (file.exists ()) file.delete (); 
	        try {
	            FileOutputStream out = new FileOutputStream(file);
	            bp.compress(Bitmap.CompressFormat.JPEG, 100, out);
	            
	            out.flush();
	            out.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
	        Uri contentUri = Uri.fromFile(file);
	        mediaScanIntent.setData(contentUri);
	        getApplicationContext().sendBroadcast(mediaScanIntent);
	   }
	   
	   @Override
	   protected void onDestroy() {
	      super.onDestroy();
	   }
	   
	   @Override
	    public void onBackPressed()
	    {
	       super.onBackPressed();
	    }
	   
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	   }
	   @Override
	   public boolean onOptionsItemSelected(MenuItem item) {
	      
	      
	      int id = item.getItemId();
	      
	      
	      if (id == R.id.action_settings) {
	         return true;
	      }
	      return super.onOptionsItemSelected(item);
	   }
		
}