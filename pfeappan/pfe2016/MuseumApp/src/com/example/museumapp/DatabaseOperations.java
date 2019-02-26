package com.example.museumapp;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
public class DatabaseOperations {
private String ln=null;
private String results=null;
private InputStream isa=null;	
HttpURLConnection urlConnection=null;	
public static String videoUrl;
public static String imgUrl;
public static String mp3Url;
public static String mapUrl;
public static String descrp;
public static String title;
@SuppressLint("NewApi")
public void select(String code_qr){
	StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
	try
	{
		String urlParameters  = "code_qr="+code_qr;
		byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		String request        = "http://192.168.1.5:8080/selecta.php";
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
		isa=urlConnection.getInputStream();
		Log.e("pass 1 slc", "connection success ");						
}
    catch(Exception e)
{
    	Log.e("Fail 1", e.toString());
    	//Toast.makeText(getApplicationContext(), "Invalid IP Address",
		//Toast.LENGTH_LONG).show();
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
	for(int i=0; i<jArray.length();i++){
		JSONObject json = jArray.getJSONObject(i);    								
		title=json.getString("oeuvre_name");
		descrp=json.getString("oeuvre_description");						
		videoUrl=json.getString("youtube");
		imgUrl=json.getString("image");
		mp3Url=json.getString("audio");
		mapUrl=json.getString("map");
	}   
	Log.e("Pass", "SUccess !!");
	}
    catch(Exception e)
	{
    	Log.e("Fail 3 line 207", e.toString());
	}			
}
}
