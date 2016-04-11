package com.example.iamanidiot.appsql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by iamanidiot on 11/4/16.
 */
public class DataSource
{
    private final String DATA_LOGTAG = "DataSourceLog";
    private Context thisContext;
    DBInstance dbConnect = new DBInstance(thisContext);
    SQLiteDatabase initDB;

    public DataSource(Context context)
    {
        thisContext = context;
    }

    public void createActivity(String data)
    {
        initDB = dbConnect.getWritableDatabase();
        String splitData [];
        splitData = data.split("~");

        try
        {
            String createActivity = "INSERT INTO ACTIVITY (NICKNAME, ACTIVITY) VALUES ('" +
                    splitData[1] +
                    "' , '" +
                    splitData[0] +
                    "');";
            initDB.execSQL(createActivity);
        }
        catch (Exception w)
        {
            Log.e(DATA_LOGTAG, w.getMessage());
            Toast.makeText(thisContext, w.getMessage(), Toast.LENGTH_LONG).show();
        }
        Log.e(DATA_LOGTAG,"Done with Activity insert for " + splitData[1]);
        initDB.close();
    }
    public void recordOccurence(String data,int chooser)
    {
        initDB = dbConnect.getWritableDatabase();
        try
        {
            String recordOccurence = "INSERT INTO FREQUENCY VALUES (" +
                    data +
                    " , datetime());";
            initDB.execSQL(recordOccurence);
        }
        catch (Exception w)
        {
            Log.e(DATA_LOGTAG, w.getMessage());
            Toast.makeText(thisContext, w.getMessage(), Toast.LENGTH_LONG).show();
        }
        initDB.close();
    }
    public boolean checkInstance()
    {
        initDB = dbConnect.getReadableDatabase();
        return initDB.isOpen();
    }

    public int countActivities()
    {
        int countActivities = 0;
        initDB = dbConnect.getWritableDatabase();
        try
        {
            String countQuery = "SELECT count(ID) FROM ACTIVITY";
            Cursor resultCount = initDB.rawQuery(countQuery, null);
            resultCount.moveToFirst();
            resultCount.close();
            return resultCount.getCount();
        }
        catch (Exception w)
        {
            Log.e(DATA_LOGTAG, "Cursor - countActivities\n" + w.getMessage());
            Toast.makeText(thisContext, "Cursor - countActivities\n" + w.getMessage(), Toast.LENGTH_LONG).show();
        }
        initDB.close();

        return countActivities;
    }
}
