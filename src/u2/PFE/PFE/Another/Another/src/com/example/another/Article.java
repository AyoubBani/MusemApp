package com.example.another;

import java.util.Timer;
import java.util.TimerTask;


import android.content.Intent;
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
import android.widget.TextView;
public class Article extends FragmentActivity {
	private ViewPager viewPager;
	
	String code_qr;
	String url;
	String oeuvre_name;
	
	String position;
	
    private ViewPagerArrowIndicator viewPagerArrowIndicator;
    InkPageIndicator mIndicator;       
    
   // private static final String TAG_PID = "code_qr";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article);
		
		DatabaseOperations db=new DatabaseOperations();
		//////////////////////////////////////::
		Intent intent = getIntent();
		code_qr=intent.getStringExtra("code_qr");
		oeuvre_name=intent.getStringExtra("oeuvre_name");
		url=intent.getStringExtra("url");
		////////////////////////////////////::
        db.select(code_qr);  
        ////////////////////::::::::::::::::::::
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
        	
	}
	private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {
              
                case 1:
                    return SecondFragment.newInstance("Page 2");
                case 2:
                    return ThirdFragment.newInstance("Page 3");
                case 3:
                    return FourthFragment.newInstance("Page 4"); 
                default:
                    return FourthFragment.newInstance("Page 99");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }        
    }	
}
