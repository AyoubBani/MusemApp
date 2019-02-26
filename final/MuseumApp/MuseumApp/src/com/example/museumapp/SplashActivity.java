package com.example.museumapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SplashActivity extends Activity {
	// Splash screen timer 	
	private static int SPLASH_TIME_OUT = 20000;
	private KenBurnsView mKenBurns;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_splash);
	setAnimation();
	getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
	mKenBurns = (KenBurnsView) findViewById(R.id.ken_burns_images);
	mKenBurns.setImageResource(R.drawable.splash_background);
	/*
	new Handler().postDelayed(new Runnable() {
		
	@Override
	public void run() {
	Intent i = new Intent(SplashActivity.this, MainActivity.class);
	startActivity(i);

	finish();
	}
	}, SPLASH_TIME_OUT);
	*/
	Button btn=(Button) findViewById(R.id.btnsc);
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
		}
	});
	Button btne=(Button) findViewById(R.id.btnex);
	btne.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent inte= new Intent(SplashActivity.this, MainActivity.class);
			startActivity(inte);
		}
	});
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
           if (resultCode == RESULT_OK) {
               
              String contents = intent.getStringExtra("SCAN_RESULT");
              String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
              
         //   formatTxt.setText("FORMAT: " + ""+format);
            //contentTxt.setText("Resultat QR : " + " "+contents);
              Intent in = new Intent(SplashActivity.this, Article.class);
              in.putExtra("cd", contents);
              startActivity(in);
              // Handle successful scan
                                        
           } else if (resultCode == RESULT_CANCELED) {
              // Handle cancel
              Log.i("App","Scan unsuccessful");
           }
      }
   }
	

	private void setAnimation() {
	ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(findViewById(R.id.welcome_text), "scaleX", 5.0F, 1.0F);
	scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
	scaleXAnimation.setDuration(1200);
	ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(findViewById(R.id.welcome_text), "scaleY", 5.0F, 1.0F);
	scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
	scaleYAnimation.setDuration(1200);
	ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(findViewById(R.id.welcome_text), "alpha", 0.0F, 1.0F);
	alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
	alphaAnimation.setDuration(1200);
	AnimatorSet animatorSet = new AnimatorSet();
	animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
	animatorSet.setStartDelay(500);
	animatorSet.start();

	findViewById(R.id.imagelogo).setAlpha(1.0F);
	Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
	findViewById(R.id.imagelogo).startAnimation(anim);
	}
	}