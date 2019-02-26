package com.example.museumapp;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.SearchView;
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
import java.util.Locale;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.text.Editable;
import android.text.TextWatcher;

public class AccueilFrag extends Fragment {
	private String ln=null;
	private String results=null;
	private InputStream isa=null;	
	static String OEUVRE_NAME = "oeuvre_name";
	static String URL = "url";
	static String ARTISTE_NAME = "artiste_name";
	HttpURLConnection urlConnection=null;	
	ArrayList<Media> mediaList;
	EditText inputSearch;
	MediaAdapter adapter;		 
	private ImageButton btnSpeak;
	private final int REQ_CODE_SPEECH_INPUT = 100;	
public AccueilFrag(){}
@SuppressLint("NewApi")
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
	StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
	//FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
	
	View rootView = inflater.inflate(R.layout.frag_accueil, container, false);
	mediaList = new ArrayList<Media>();		
	select();		
	ListView listview = (ListView) rootView.findViewById(R.id.list);			
	adapter = new MediaAdapter(getActivity().getApplicationContext(), mediaList);		
	listview.setAdapter(adapter);		
	
	
	
	
	
	
	
	listview.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long id) {
			// TODO Auto-generated method stub
			 Toast.makeText(getActivity().getApplicationContext(), mediaList.get(position).getTitre(), Toast.LENGTH_LONG).show();								
		}
	});		
//////////////////////////////////////////////			      
	
/////////////////////////////////////////////////////						
	Intent intent = getActivity().getIntent();					
		inputSearch=(EditText) rootView.findViewById(R.id.reseafield);			
		inputSearch.addTextChangedListener(new TextWatcher() {			
		@Override
		public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
			// When user changed the Text
			//MainActivity.this.adapter.getFilter().filter(cs);					
			//MainActivity.this.adapter.getFilter().filter(cs.toString());
			//MainActivity.this.adapter.getFilter().filter(cs.toString());
			AccueilFrag.this.adapter.getFilter().filter(cs);
			//String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
			//adapter.filter(cs.toString());						
		}			
		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub				
		}			
		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub							
		}
	});		

		btnSpeak = (ImageButton) rootView.findViewById(R.id.btnSpeak);

		// hide the action bar
		//getActionBar().hide();

		btnSpeak.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				promptSpeechInput();
			}
		});
    return rootView;
}


/**
 * Showing google speech input dialog
 * */
private void promptSpeechInput() {
	Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
			RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "fr-FR");
	intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
			getString(R.string.speech_prompt));
	try {
		startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
	} catch (ActivityNotFoundException a) {
		Toast.makeText(getActivity().getApplicationContext(),
				getString(R.string.speech_not_supported),
				Toast.LENGTH_SHORT).show();
	}
}
/**
 * Receiving speech input
 * */
@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);

	switch (requestCode) {
	case REQ_CODE_SPEECH_INPUT: {
		if (resultCode == Activity.RESULT_OK && null != data) {

			ArrayList<String> result = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
		//	txtSpeechInput.setText(result.get(0));
			//Toast.makeText(getContext(), "res: "+result.get(0).toString(), Toast.LENGTH_LONG).show();
			inputSearch.setText(result.get(0).toString());
		}
		break;
	}
	}
}

@SuppressLint("NewApi")
public void select(){
	/*
	ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();		
   	nameValuePairs.add(new BasicNameValuePair("code_qr",code_qr));*/
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
		 String urlParameters = "oeuvre_name="+OEUVRE_NAME;
		//String urlParameters = null ;			 
		byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;			
		String request        = "http://192.168.1.5:8080/show.php";
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
    	Toast.makeText(getActivity().getApplicationContext(), "Invalid IP Address",
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
		media.setCodeQr(object.getString("code_qr"));
		mediaList.add(media);												 			        												
	}   
	Log.e("Pass", "SUccess !!");
	}
    catch(Exception e)
	{
    	Log.e("Fail 3 line 207", e.toString());
	}								
}		
 @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {		 
        //MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.accueil, menu);
        super.onCreateOptionsMenu(menu,inflater);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =(SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =(SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getActivity().getComponentName()));
        
    }
}

