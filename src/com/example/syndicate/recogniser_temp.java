package com.example.syndicate;


 
 
	import java.util.*;
	import java.io.ByteArrayOutputStream;
	import java.io.ByteArrayOutputStream;
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import android.app.Activity;
	import android.content.Intent;
	import android.graphics.Bitmap;
	import android.os.Bundle;
	import android.provider.MediaStore;
	import android.util.Log;
	import android.view.View;
	import android.widget.Button;
	import android.widget.ImageView;
	import android.widget.Toast;
	import java.io.File;
	import java.text.SimpleDateFormat;
	import android.app.Activity;
	import android.content.Intent;
	import android.net.Uri;
	import android.os.Bundle;
	import android.os.Environment;
	import android.provider.MediaStore;
	import android.util.Log;
	import android.view.View;
	import android.widget.Button;
	import android.widget.TextView;
	import android.widget.Toast;
	 
	
	 
	public class recogniser_temp extends Activity{
		private Button captureButton;
	      private ImageView showImage;
	      private Bitmap bitmap;
	      @Override
	      public void onCreate(Bundle savedInstanceState)
	      {
	          super.onCreate(savedInstanceState);
	          setContentView(R.layout.addimage);
	 
	        
	             showImage=(ImageView)findViewById(R.id.imageView);
	 
	              captureButton=(Button)findViewById(R.id.btnCamera);
	             // captureButton.setText("Open Camera");
	              captureButton.setOnClickListener(new Button.OnClickListener()
	              {
	                  @Override
	                  public void onClick(View v)
	                  {
	                      startCamera();
	                  }
	             });
	         
	        
	    }
	 
	    private void startCamera()
	    {
	       Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	       intent.putExtra(MediaStore.EXTRA_OUTPUT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
	       startActivityForResult(intent, 1);
	   }
	 
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data)
	    {
	        super.onActivityResult(requestCode, resultCode, data);
	        switch (resultCode)
	        {
	           case -1:     Log.i("StartUpActivity", "Photo Captured");
	                        bitmap=(Bitmap) data.getExtras().get("data");
	                        SaveImage(bitmap);
	                        MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,null,null);
	                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	                       // bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
	                        showImage.setImageBitmap(bitmap);
	                        break;
	          default:      Log.i("StartUpActivity", "Cancelled Camera"); break;
	      }
	        
	   }
	    
	    public void SaveImage(Bitmap showedImgae){

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
	            showedImgae.compress(Bitmap.CompressFormat.JPEG, 100, out);
	            
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
	    public void onBackPressed()
	    {
	       super.onBackPressed();
	    }
	 
	    

	
	}