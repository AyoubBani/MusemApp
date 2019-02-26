package com.example.basededonnees;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.facebook.FacebookSdk;
import android.view.View.OnClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.content.ClipData.Item;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareDialog;

//import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;



public class MediaAdapter extends ArrayAdapter<Media> {
	 
	ArrayList<Media> mediaList;
	Context context;
	int Resource;
	
	LayoutInflater vi;
	ViewHolder holder;
	ImageLoader imageLoader;
	
	
	
	
	
	public  MediaAdapter(Context context, int resource, ArrayList<Media> objects) {
		super(context, resource, objects);
		
		imageLoader = new ImageLoader(context);	
		vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Resource = resource;
		mediaList = objects;
		this.context = context;
		 
	
	}
	
	public Object getResource(){
		return mediaList;
	}

	
    
	@Override
	public View getView( int position, View convertView,  ViewGroup parent) {
		// convert view = design
		View v = convertView;
		v = vi.inflate(Resource, null);
		
			holder = new ViewHolder();
			int loader = R.drawable.ic_launcher;	
			
		   //l url d image 
		   
		
			holder.titre = (TextView) v.findViewById(R.id.titre);
			holder.titre.setText(mediaList.get(position).getTitre());
			
			
			holder.artist = (TextView) v.findViewById(R.id.artist);
			holder.artist.setText(mediaList.get(position).getArtist());
			
			
			holder.imageview = (ImageView) v.findViewById(R.id.urlImage);
			imageLoader.DisplayImage(mediaList.get(position).getUrl(), loader, holder.imageview );
			
			
			holder.button = (Button) v.findViewById(R.id.btnOne);
			holder.button.setOnClickListener(new View.OnClickListener() {
		         @Override
		         public void onClick( View arg0) {
		        	
		         Drawable mDrawable =  holder.imageview.getDrawable();
		     		Bitmap image = ((BitmapDrawable)mDrawable).getBitmap();
		        	 
		        			 SharePhoto photo = new SharePhoto.Builder()
		        			         .setBitmap(image)
		        			         .build();
		        			 SharePhotoContent content = new SharePhotoContent.Builder()
		        			         .addPhoto(photo)
		        			         .build(); 
		         }

				
				
			});
			
			
			
 			v.setTag(holder);
       	 
		        			
		return v;

	}

	
	/*public void setupFacebookShareIntent() {
	      ShareDialog shareDialog;
	      FacebookSdk.sdkInitialize(getApplicationContext());
	      shareDialog = new ShareDialog(this);

	      ShareLinkContent linkContent = new ShareLinkContent.Builder()
	              .setContentTitle("Title")
	              .setContentDescription(
	                      "\"Body Of Test Post\"")
	              .setContentUrl(Uri.parse("http://someurl.com/here"))
	              .build();
	      
	      shareDialog.show(linkContent);
	  }*/
	
	
	
	
	
	
	
	
	private Uri getLocalBitmapUri(ImageView imageview) {
		
	
	/*	ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		Drawable mDrawable =  holder.imageview.getDrawable();
		Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

		String path = Images.Media.insertImage(context.getContentResolver(), 
		    mBitmap, "Image Description", null);
		mBitmap.compress(Bitmap.CompressFormat.PNG, 60, bytes);
		Uri uri = Uri.parse(path);
		return uri;*/
		
		
		
		
	  Drawable drawable = holder.imageview.getDrawable();
	    Bitmap bmp = null;
	    if (drawable instanceof BitmapDrawable){
	       bmp = ((BitmapDrawable) holder.imageview.getDrawable()).getBitmap();
	    } else {
	       return null;
	    }
	    // Store image to default external storage directory
	    Uri bmpUri = null;
	    try {
	        File file =  new File(Environment.getExternalStoragePublicDirectory(  
	            Environment.DIRECTORY_DOWNLOADS), "share_image_" + System.currentTimeMillis() + ".png");
	        file.getParentFile().mkdirs();
	        FileOutputStream out = new FileOutputStream(file);
	        bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
	        out.close();
	        bmpUri = Uri.fromFile(file);
	       
	    } catch (IOException e) {
	        e.printStackTrace();
	        
	    }
	  
	    return bmpUri;
	    
	}     
	
	
	
	 private void shareImage() {
		 
		
	        ImageView ivImage = holder.imageview;
	     
	        Uri bmpUri = getLocalBitmapUri(ivImage);
	        if (bmpUri != null) {
	           
	            Intent shareIntent = new Intent();
	            shareIntent.setAction(Intent.ACTION_SEND);
	            shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
	            shareIntent.setType("image/*");
	            
	            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	            context.startActivity(shareIntent);
	        } else {
	            // ...sharing failed, 
	        }
	    }


	
	
	
	
	
/*	public Uri getImageUri(Context inContext, Bitmap inImage) {
	    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	    inImage.compress(Bitmap.CompressFormat.PNG, 60, bytes);
	    String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
	    return Uri.parse(path);
	}*/
 
 
	
	 public void onShareItem(View v) {
		    // Get access to bitmap image from view
		    ImageView ivImage = holder.imageview;
		    // Get access to the URI for the bitmap
		    Uri bmpUri = getLocalBitmapUri(ivImage);
		    if (bmpUri != null) {
		        // Construct a ShareIntent with link to image
		        Intent shareIntent = new Intent();
		        shareIntent.setAction(Intent.ACTION_SEND);
		        shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
		        shareIntent.setType("image/*");
		        // Launch sharing dialog for image
		        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		        context.startActivity(shareIntent);	
		    } else {
		        // ...sharing failed, handle error
		    }
		}

	 
	 

	static class ViewHolder {
		public ImageView imageview;
		public TextView titre;
		public TextView artist;
		public Button button;
				
		}


}