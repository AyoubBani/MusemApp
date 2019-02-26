package com.example.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button startIntro = (Button) findViewById(R.id.start_intro);
        startIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

                Intent introIntent;
               
                    
               
                    introIntent = new Intent(MainActivity.this, MaterialIntroActivity.class);
                

                

                startActivity(introIntent);

            }
        });
    }

   

   // @Override
   // public boolean onOptionsItemSelected(MenuItem item) {
       
    //}
}