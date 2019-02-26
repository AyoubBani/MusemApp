package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Exmp extends Fragment {
	public Exmp(){}
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.activity_exmp, container, false);
	}	
	//android:id="@+id/txt"
}
