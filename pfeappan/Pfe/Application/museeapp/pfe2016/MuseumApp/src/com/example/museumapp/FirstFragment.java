package com.example.museumapp;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
public class FirstFragment extends Fragment {
	private static final String KEY_MESSAGE = "message";

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	/*
        View rootView = inflater.inflate(R.layout.first_frag, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.frg1);
        String msg = getArguments().getString(KEY_MESSAGE);
        textView.setText(msg);

        */
        View view = inflater.inflate(R.layout.first_frag, container, false);
		YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
		FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_fragment, youTubePlayerFragment).commit();
        youTubePlayerFragment.initialize("AIzaSyBPEhlxLwxwjgCFB40_5SLyyzXlo4RLitI", new OnInitializedListener() {           
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    //player.loadVideo("psu3pPdfYSM");
                    player.loadVideo(DatabaseOperations.videoUrl);
                    player.play();
                }
            }            
            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });                
        return view;
    }

    public static Fragment newInstance(String message) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE, message);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
