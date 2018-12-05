package com.adgvit.appathon2k18.appathon2k18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Settings extends AppCompatActivity {

    private LinearLayout lr;
    private ImageButton sponsors,developers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try {
            setContentView(R.layout.activity_settings);

            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH");
            // you can get seconds by adding  "...:ss" to it
            date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
            String localTime = date.format(currentLocalTime);
            Log.w(localTime, "1");

            lr = (LinearLayout) findViewById(R.id.back);
            if (localTime.equals("06") || localTime.equals("07") || localTime.equals("08") || localTime.equals("09") || localTime.equals("10") || localTime.equals("11") || localTime.equals("12")) {
                lr.setBackgroundResource(R.drawable.back1);

            }
            if (localTime.equals("13") || localTime.equals("14") || localTime.equals("15") || localTime.equals("16")) {
                lr.setBackgroundResource(R.drawable.back2);

            }
            if (localTime.equals("17") || localTime.equals("18") || localTime.equals("19") || localTime.equals("20") || localTime.equals("21") || localTime.equals("22") || localTime.equals("23") || localTime.equals("24") || localTime.equals("00") || localTime.equals("01") || localTime.equals("02") || localTime.equals("03") || localTime.equals("04") || localTime.equals("05")) {
                lr.setBackgroundResource(R.drawable.back3);

            }


            developers = (ImageButton) findViewById(R.id.developers);
            sponsors = (ImageButton) findViewById(R.id.sponsors);

            developers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Settings.this, Developers.class);
                    startActivity(i);
                }
            });


            sponsors.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Settings.this, Sponsors.class);
                    startActivity(i);
                }
            });
        }
        catch (Exception e){
            Toast.makeText(Settings.this, "Connection Issue.Try Again", Toast.LENGTH_SHORT).show();
        }


    }
    public void backHome(View v){
        try {
            Intent intent = new Intent(Settings.this, HomeScreen.class);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(Settings.this, "Connection Issue.Try Again", Toast.LENGTH_SHORT).show();
        }
    }
}
