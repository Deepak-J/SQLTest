package com.example.iamanidiot.appsql;

import android.util.Log;

/**
 * Created by iamanidiot on 11/4/16.
 */
public class DataSource
{
    private final String DATA_LOGTAG = "DataSourceLog";

    public void createActivity(String data)
    {
        String splitData [];
        splitData = data.split("~");

        try
        {
            String createActivity = "INSERT INTO ACTIVITY (NICKNAME, ACTIVITY) VALUES ('" +
                    splitData[1] +
                    "' , '" +
                    splitData[0] +
                    "');";
        }
        catch (Exception w)
        {
            Log.e(DATA_LOGTAG, w.getMessage());
        }
        Log.e(DATA_LOGTAG,"Done with Activity insert for " + splitData[1]);
    }
    public void recordOccurence(String data,int chooser)
    {
        String recordOccurence = "INSERT INTO FREQUENCY VALUES (" +
                data +
                " , datetime());";
    }

}
