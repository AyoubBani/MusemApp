package com.example.basededonnees;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.util.Base64;
import android.util.Log;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RatingBar.OnRatingBarChangeListener;


import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.widget.LikeView;


public class MainActivity extends ActionBarActivity     {

	private String ln=null;
	private String results=null;
	private InputStream isa=null;
	

	String oeuvre_name;
	String url;
	String artiste_name;
	
	HttpURLConnection urlConnection=null;
	
	ArrayList<Media> mediaList;
	MediaAdapter adapter;

	
	 
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		  FacebookSdk.sdkInitialize(this.getApplicationContext());
		  
	
		  
		//FacebookSdk.sdkInitialize(getApplicationContext());
        // AppEventsLogger.activateApp(this);
		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
		super.onCreate(savedInstanceState);
		
	
		setContentView(R.layout.activity_main);
		
		///////////////////////////

		
	
	//////////////////////////////////////
		 

			 
		
		mediaList = new ArrayList<Media>();
		
		ListView listview = (ListView)findViewById(R.id.list);
	
		
		adapter = new MediaAdapter(getApplicationContext(), R.layout.row, mediaList);
		
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				 Toast.makeText(getApplicationContext(), mediaList.get(position).getTitre(), Toast.LENGTH_LONG).show();				
				
			}
		});
		
	//////////////////////////////////////////////
		
	      
	  /* b1.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 
	        	 Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.logo);

	             Intent sharingIntent = new Intent(Intent.ACTION_SEND);

	             sharingIntent.setType("image/png");

	        	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	        	 
	        	 b.compress(Bitmap.CompressFormat.PNG, 10, bytes);
	        	 
	        	 String path = MediaStore.Images.Media.insertImage(getContentResolver(), b, "Share image using", null);
	        	 Uri imageUri = Uri.parse(path);
	        	 sharingIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
	        	 startActivity(Intent.createChooser(sharingIntent,"Share image using"));
	        	 
	        	 
	        	 
	         }
	      }); */
	   
/////////////////////////////////////////////////////
		
		
		
		Intent intent = getIntent();


	}
	
	
	
	@SuppressLint("NewApi")
	class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {
		
		ProgressDialog dialog;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setMessage("Loading, please wait");
			dialog.setTitle("Connecting server");
			dialog.show();
			dialog.setCancelable(false);
		}
		
		@Override
		protected Boolean doInBackground(String... urls) {
			try
			{
				/*
			    HttpClient httpclient = new DefaultHttpClient();	        
				HttpPost httppost = new HttpPost("http://192.168.168.1/select.php");
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        HttpResponse response = httpclient.execute(httppost); 
		        HttpEntity entity = response.getEntity();
		        isa = entity.getContent();
		        Log.e("pass 1 slc", "connection success ");*/
				//URL url=new URL("http://192.168.1.5:8080/select.php");
				
				 String urlParameters = "oeuvre_name="+oeuvre_name;
				//String urlParameters = null ;
				 
				byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
				int    postDataLength = postData.length;
				String request        = "http://192.168.1.4:80/miniprojetphp/show.php";
				URL    url            = new URL( request );			
				urlConnection=(HttpURLConnection) url.openConnection();

				urlConnection.setDoOutput( true );
				urlConnection.setInstanceFollowRedirects( false );
				urlConnection.setRequestMethod( "POST" );
				urlConnection.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
				urlConnection.setRequestProperty( "charset", "utf-8");
				urlConnection.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
				urlConnection.setUseCaches( false );			
				urlConnection.getOutputStream().write(postData);
				//String body = "?code_qr="+code_qr;
				//urlConnection.getOutputStream().write(body.getBytes("UTF8"));
				isa=urlConnection.getInputStream();
				Log.e("pass 1 slc", "connection success ");						
		}
		    catch(Exception e)
		{
		    	Log.e("Fail 1", e.toString());
		    	Toast.makeText(getApplicationContext(), "Invalid IP Address",
				Toast.LENGTH_LONG).show();
		}             
		    try
		    {
		    	BufferedReader reader = new BufferedReader(new InputStreamReader(isa, "UTF-8"),8);
		        	StringBuilder sb = new StringBuilder();
		        	while ((ln = reader.readLine()) != null)
			{
		        		
		   		    sb.append(ln + "\n");
		       	}
		        	isa.close();
		        	results = sb.toString();
		        Log.e("pass 2 slc", "connection success ");
		}
		    catch(Exception e)
			{
			Log.e("Fail 2", e.toString());
		}            
			try
			{  
				
			
				
			JSONArray jArray = new JSONArray(results);  
			
			
			StringBuffer sb=new StringBuffer();
			for(int i=0; i < jArray.length();i++){
				JSONObject object = jArray.getJSONObject(i);

				Media media = new Media();

				media.setTitre(object.getString("oeuvre_name"));
				
				media.setUrl(object.getString("url"));
				
				media.setArtist(object.getString("artiste_name"));

				mediaList.add(media);
				
				
							 			        												
			}   
			Log.e("Pass", "SUccess !!");
			}
		    catch(Exception e)
			{
		    	Log.e("Fail 3 line 207", e.toString());
			}		
			
			
			return false;
		}
		
		protected void onPostExecute(Boolean result) {
			dialog.cancel();
			adapter.notifyDataSetChanged();
			if(result == false)
				Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();

		}
	}
	 
}

