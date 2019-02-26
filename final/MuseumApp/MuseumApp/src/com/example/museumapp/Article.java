package com.example.museumapp;
import java.util.Random;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
public class Article extends FragmentActivity {
	private ViewPager viewPager;
    private ViewPagerArrowIndicator viewPagerArrowIndicator;
    InkPageIndicator mIndicator;       
    int[] myColors={Color.parseColor("#f44336"), Color.parseColor("#e91e63") , Color.parseColor("#9c27b0"), Color.parseColor("#2196f3"), Color.parseColor("#00bcd4"), Color.parseColor("#009688"), Color.parseColor("#76ff03"), Color.parseColor("#eeff41"), Color.parseColor("#ffeb3b"), Color.parseColor("#00e676")};	
	int last;	
	static int currentColor; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article);
		DatabaseOperations db=new DatabaseOperations();
        //db.select("code001");
		db.select(getIntent().getStringExtra("cd"));
		viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerArrowIndicator = (ViewPagerArrowIndicator) findViewById(R.id.viewPagerArrowIndicator);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        viewPagerArrowIndicator.bind(viewPager);
        mIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPager);     
        TextView desc=(TextView) findViewById(R.id.description);
        TextView tit=(TextView) findViewById(R.id.title);        
        desc.setText(DatabaseOperations.descrp);
        String titl="<h2>"+DatabaseOperations.title+"</h2>";
        tit.setText(Html.fromHtml(titl));
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);				
		last=viewGroup.getSolidColor();			
		startColorAnimation(viewGroup);		
		final Handler ha=new Handler();
        ha.postDelayed(new Runnable() {
            @Override
            public void run() {
                //call function
            	startColorAnimation(viewGroup);
            	ha.postDelayed(this, 10000);
            	}}, 10000);
	}
	private void startColorAnimation(View v) {
        int colorStart=last;
        //int colorEnd = 0xFFFF0000;
        //int colorEnd = 0xEA80FC00;        
        int colorEnd=myColors[new Random().nextInt(myColors.length)];
        last=colorEnd;
        ValueAnimator colorAnim = ObjectAnimator.ofInt(v, "backgroundColor", colorStart, colorEnd);                
        ValueAnimator colorAnimImg = ObjectAnimator.ofInt(findViewById(R.id.ButtonTestPlayPause), "backgroundColor", colorStart, colorEnd);        
//        ValueAnimator colorAnimSeekbr = ObjectAnimator.ofInt(findViewById(R.id.SeekBarTestPlay), "backgroundColor", colorStart, colorEnd);
        colorAnim.setDuration(10000);
        colorAnimImg.setDuration(10000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnimImg.setEvaluator(new ArgbEvaluator());        
        colorAnim.setRepeatCount(1);
        colorAnimImg.setRepeatCount(1);
//        colorAnim.setRepeatCount(colorAnim.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimImg.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
        colorAnimImg.start();
    }
	private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {
                case 0:
                    return FirstFragment.newInstance("Page 1");
                case 1:
                    return SecondFragment.newInstance("Page 2");
                case 2:
                    return ThirdFragment.newInstance("Page 3");
                case 3:
                    return FourthFragment.newInstance("Page 4"); 
                default:
                    return FirstFragment.newInstance("Page 99");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }        
    }	
}
