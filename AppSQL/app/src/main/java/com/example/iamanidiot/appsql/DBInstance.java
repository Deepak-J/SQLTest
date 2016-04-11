package com.example.iamanidiot.appsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by iamanidiot on 11/4/16.
 */

public class DBInstance extends SQLiteOpenHelper
{
    private  final String DATA_LOGTAG = "DBLog";
    private static final String DBNAME = "TrackAPPDB";
    private static final String ACTIVITY_TABLE_NAME = "Activity";
    private static final String FREQUENCY_TABLE_NAME = "Frequency";
    private static final int VERSION = 1;
    Context thisContext;

    public DBInstance(Context thisContext)
    {
        super(thisContext, DBNAME, null, VERSION);
        this.thisContext = thisContext;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Toast.makeText(thisContext,"In the onCreate Method", Toast.LENGTH_LONG).show();
        String createActivityTable =
                "CREATE TABLE" +
                ACTIVITY_TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NICKNAME TEXT" +
                "ACTIVITY TEXT);";
//        log.i(LOGTAG, "In the DB Concstructor");
        String createFrequencyTable =
                "CREATE TABLE" +
                        FREQUENCY_TABLE_NAME +
                        "(ID INTEGER, " +
                        "OCCURENCE TIMESTAMP NOT NULL DEFAULT current_timestamp, " +
                        " FOREIGN KEY(ID) REFERENCES " +
                        ACTIVITY_TABLE_NAME +
                        "(ID));";
        try
        {
            db.execSQL(createActivityTable);
            db.execSQL(createFrequencyTable);
        }
        catch (Exception e)
        {
            Log.e(DATA_LOGTAG, e.getMessage());
            Toast.makeText(thisContext, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Toast.makeText(thisContext,"In the onUpgrade Method", Toast.LENGTH_LONG).show();
    }
}
