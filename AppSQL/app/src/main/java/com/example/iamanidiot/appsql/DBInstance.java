package com.example.iamanidiot.appsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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

    public DBInstance(Context context)
    {
        super(context, DBNAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public boolean checkInstance()
    {
        //TODO
        return true;
    }
}
