package com.example.iamanidiot.appsql;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class HomeScreen extends Activity
{
    private final static String MAINLOGTAG = "MainActivity";
    //Log.i(MAINLOGTAG,"in the main Activity");

    Context mainActivityContext = getApplicationContext();
    public void DBCheck()
    {
        DBInstance dbCheck = new DBInstance(mainActivityContext);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Log.i(MAINLOGTAG, "In the OnCreate for HomeScreen");
    }
}
