package com.example.another;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


//import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
public class MediaAdapter extends BaseAdapter implements Filterable{
	 
	ArrayList<Media> mediaList;
	Context context;
	ArrayList<String> Original_Names;
	ArrayList<String> Names;
	LayoutInflater vi;
	ViewHolder holder;
	ImageLoader imageLoader;	
	private ArrayList<Media> Itemslist = null;
	filter_here friendFilter;	
	
	private static final String TAG_PID = "code_qr";
	public  MediaAdapter(Context context, ArrayList<Media> Itemslist) {
		this.context = context;
		this.Itemslist=Itemslist;			
		
		vi= LayoutInflater.from(context);
		this.mediaList= new ArrayList<Media>();
		this.mediaList.addAll(Itemslist);		
		imageLoader = new ImageLoader(context);								
		this.Original_Names=new ArrayList<String>();
		//this.Names=new ArrayList<String>();
		for(int i=0; i<Itemslist.size(); i++){
			Original_Names.add(Itemslist.get(i).getTitre());	
			//Names.add(Itemslist.get(i).getTitre());
		}
		
				 	
	}
	@Override
	public int getCount() {
		return mediaList.size();
	} //
	@Override
	public Media getItem(int position) {
		return mediaList.get(position);
	}
	@Override
	public long getItemId(int position) {
		return position;
	} 

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		int loader = R.drawable.ic_launcher;
		if (view == null) {
			holder = new ViewHolder();
			view = vi.inflate(R.layout.row, null);
			
			holder.imageview = (ImageView) view.findViewById(R.id.urlImage);
			
			holder.titre = (TextView) view.findViewById(R.id.titre);
									
			holder.artist = (TextView) view.findViewById(R.id.artist);
											  												
			holder.button1 = (Button) view.findViewById(R.id.btnOne);
			holder.button2 = (Button) view.findViewById(R.id.btnTwo);
			view.setTag(holder);
			
		}else{
			holder = (ViewHolder) view.getTag();	
		}
		imageLoader.DisplayImage(mediaList.get(position).getUrl(), loader, holder.imageview );
		holder.titre.setText(mediaList.get(position).getTitre());
		holder.artist.setText(mediaList.get(position).getArtist());
		
		holder.button1.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {		        	        	 

		        	//holder=(ViewHolder)v.getTag(); 
		        	v.setTag(holder);
		    		 //onShareItem( v);
		            int i=	(int) getItemId( position);
		        	v.getTag(i);
		        	// v.getTag(holder);
		        	 
		        	 //partager *****************************************
		        	 
		        	 Drawable mDrawable =  holder.imageview.getDrawable();
			     	 Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();
			     		
		             Intent sharingIntent = new Intent(Intent.ACTION_SEND);

		             sharingIntent.setType("image/png");

		        	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		        	 
		        	 mBitmap.compress(Bitmap.CompressFormat.PNG, 1, bytes);
		        	 
		        	 String path = Images.Media.insertImage(context.getContentResolver(), 
				     		    mBitmap, "Image Description", null);
		        	 
		        	 Uri imageUri = Uri.parse(path);
		        	 sharingIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
		        	 sharingIntent.setType("image/*");
			            
		        	 sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			            context.startActivity( sharingIntent); 
                 /////:::::::::::::::::::::::::::::::::::::::::::
				        		                                                             
	         }								
		});			
		
		//String code_qr= mediaList.get(position).getCodeQr();
		
		holder.button2.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {	    
	        	
	        	 /* Intent intent = new Intent(context ,Article.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	             context.startActivity(intent);
	        	 */
	        	 /*Intent intent=new Intent(context, Article.class);
	        	 String code_qr=mediaList.get(position).getCodeQr();
	             intent.putExtra(TAG_PID, code_qr);
	               
	        	 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        	 context.startActivity(intent);*/
	        	 
	        	 Intent i = new Intent(context, Article.class);
	                i.putExtra("code_qr", mediaList.get(position).getCodeQr());
	                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                context.startActivity(i);
						        	 
	         }
	      }); 
		
			
		
		return view;
	}
	/*
	public View getView(final int position, View convertView,  ViewGroup parent) {
		// convert view = design
		View v = convertView;
		v = vi.inflate(Resource, null);		
			holder = new ViewHolder();
			int loader = R.drawable.ic_launcher;				
		   //l url d image 
		    holder.imageview = (ImageView) v.findViewById(R.id.urlImage);		 
		   // load image		  
		  imageLoader.DisplayImage(mediaList.get(position).getUrl(), loader, holder.imageview );				  		   
			holder.titre = (TextView) v.findViewById(R.id.titre);
			holder.titre.setText(mediaList.get(position).getTitre());						
			holder.artist = (TextView) v.findViewById(R.id.artist);
			holder.artist.setText(mediaList.get(position).getArtist());								  
			v.setTag(holder);									
			holder.button = (Button) v.findViewById(R.id.btnOne);
			holder.button.setOnClickListener(new View.OnClickListener() {
		         @Override
		         public void onClick(View v) {		        	        	 
                     Uri pictureUri = getLocalBitmapUri(holder.imageview);                    		                     
                     if (pictureUri != null) {
                         // Construct a ShareIntent with link to image                    	 
                    	 String text = "image : "+mediaList.get(position).getTitre();
                         Intent shareIntent = new Intent();
                         shareIntent.setAction(Intent.ACTION_SEND);
                         shareIntent.putExtra(Intent.EXTRA_TEXT, text);
                         shareIntent.putExtra(Intent.EXTRA_STREAM, pictureUri);
                         shareIntent.setType("image/*");
                         // Launch sharing dialog for image
                         shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                         context.startActivity(shareIntent);    
                     } else {
                         // ...sharing failed, handle error
                     }                                                                                                         
		        	/* Intent sendIntent = new Intent(); 
		        	 sendIntent.setAction(Intent.ACTION_SEND); 
		        	// sendIntent.putExtra(Intent.EXTRA_TEXT, mediaList.get(position).getUrl()); 
		        	 sendIntent.setType("image/png"); 
		        	 //sendIntent.putExtra(Intent.EXTRA_STREAM, mediaList.get(position).getUrl());		        	 
		        	 sendIntent.setAction(Intent.ACTION_SEND);
		        	 sendIntent.putExtra(Intent.EXTRA_STREAM, pictureUri);
		        	 sendIntent.setType("image/*");
		        	 sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		        	 sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		        	 context.startActivity(sendIntent); */		        	                      		        	 
		       /* 	 Intent sendIntent = new Intent(); 
		        	 sendIntent.setAction(Intent.ACTION_SEND); 
		        	 sendIntent.putExtra(Intent.EXTRA_TEXT, mediaList.get(position).getUrl()); 
		        	 sendIntent.setType("image/JPEG"); 
		        	 //sendIntent.putExtra(Intent.EXTRA_STREAM, mediaList.get(position).getUrl());
		        	 sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		        	 context.startActivity(sendIntent); */		        	 
		        //Toast.makeText(v.getContext(), "Button 1  clicked for row position=" + position, Toast.LENGTH_SHORT).show();	 
		        //Toast.makeText(v.getContext(), "BJDHJKHJDHJKDJKSDJKDJKFJK", Toast.LENGTH_SHORT).show();
	/*
		         }								
			});					        			
		return v;
	}
	*/
	
	
	/*
	public Object getResource(){
		return mediaList;
	}*/		
	private Uri getLocalBitmapUri(ImageView imageview) {	
		// TODO Auto-generated method stub
		 // Extract Bitmap from ImageView drawable
	    Drawable drawable =holder.imageview.getDrawable();
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
	

	  public class ViewHolder {
		public ImageView imageview;
		public TextView titre;
		public TextView artist;
		public Button button1;	
		public Button button2;	
		
		}
	  /*
	  public void filter(String charText) {
			charText = charText.toLowerCase(Locale.getDefault());
			Itemslist.clear();
			if (charText.length() == 0) {
				Itemslist.addAll(mediaList);
			} else {
				for (Media i : mediaList) {
					if (i.getTitre().toLowerCase(Locale.getDefault()).contains(charText)) {						
						Itemslist.add(i);
					}
				}
			}
			notifyDataSetChanged();
		}			
*/
	  @Override
	    public Filter getFilter() {
	        if (friendFilter == null) {
	            friendFilter = new filter_here();
	        }

	        return friendFilter;
	    }
	  
	  public class filter_here extends Filter {

	        @Override
	        protected FilterResults performFiltering(CharSequence constraint) {
	            FilterResults filterResults = new FilterResults();
	            if (constraint!=null && constraint.length()>0) {
	                ArrayList<Media> tempList = new ArrayList<Media>();

	                // search content in friend list
	                for (Media media : Itemslist) {
	                    if ((media.getTitre().toLowerCase().contains(constraint.toString().toLowerCase()))||((media.getArtist().toLowerCase().contains(constraint.toString().toLowerCase())))) {
	                        tempList.add(media);
	                    }
	                }

	                filterResults.count = tempList.size();
	                filterResults.values = tempList;
	            } else {
	                filterResults.count = Itemslist.size();
	                filterResults.values = Itemslist;
	            }

	            return filterResults;
	        }

	        /**
	         * Notify about filtered list to ui
	         * @param constraint text
	         * @param results filtered result
	         */
	        @SuppressWarnings("unchecked")
	        @Override
	        protected void publishResults(CharSequence constraint, FilterResults results) {
	        	mediaList = (ArrayList<Media>) results.values;	        	
	            notifyDataSetChanged();
	        }
	    }
	  
}