package com.example.iamanidiot.appsql;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class HomeScreen extends Activity
{
    private final static String MAINLOGTAG = "MainActivity";
    //Log.i(MAINLOGTAG,"in the main Activity");
    DataSource dSource;
    Context mainActivityContext = getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        TextView statusCheck = (TextView) findViewById(R.id.statusCheck);


        dSource = new DataSource(getApplicationContext());

        Log.i(MAINLOGTAG, "In the OnCreate for HomeScreen");

        if(dSource.checkInstance())
            statusCheck.setText("DB Success");
        else
            statusCheck.setText("No Success");
        statusCheck.setVisibility(View.VISIBLE);
    }

    public void checkActivities(View view)
    {
        TextView activityCountText = (TextView) findViewById(R.id.activityCountText);
        activityCountText.setText("The number of activities: \n" + dSource.countActivities());
    }

}
