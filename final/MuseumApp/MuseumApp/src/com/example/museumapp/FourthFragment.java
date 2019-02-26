package com.example.museumapp;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
public class FourthFragment extends Fragment {
	Button load_img;
    ImageView img;
    Bitmap bitmap;
    ProgressDialog pDialog;
    private static final String KEY_MESSAGE = "message";
public FourthFragment(){
}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fourth_frag, container, false);
    img = (ImageView)v.findViewById(R.id.imgmp);
    new LoadImage().execute(DatabaseOperations.mapUrl);        
    return v;
}
public static Fragment newInstance(String message) {
    Bundle bundle = new Bundle();
    bundle.putString(KEY_MESSAGE, message);
    FourthFragment fragment = new FourthFragment();
    fragment.setArguments(bundle);
    return fragment;
}
public Bitmap getBitmapFromURL(String src) {
	try {
		URL url = new URL(src);
		HttpURLConnection connection = (HttpURLConnection) url
				.openConnection();
		connection.setDoInput(true);
		connection.connect();
		InputStream input = connection.getInputStream();
		Bitmap myBitmap = BitmapFactory.decodeStream(input);
		return myBitmap;

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return null;
	}
}

private class LoadImage extends AsyncTask<String, String, Bitmap> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Patientez ....");
        pDialog.show();

    }
     protected Bitmap doInBackground(String... args) {
         try {
               bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

        } catch (Exception e) {
              e.printStackTrace();
        }
         pDialog.dismiss();
        return bitmap;
     }

     protected void onPostExecute(Bitmap image) {

         if(image != null){
         img.setImageBitmap(image);
         pDialog.dismiss();

         }else{

         pDialog.dismiss();
         Toast.makeText(getActivity(), "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

         }
     }
 }    
}