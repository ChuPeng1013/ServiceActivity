package com.example.administrator.serviceactivity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by ChuPeng on 2016/12/13.
 */

public class StartService extends Service
{

    //绑定服务时调用
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    //创建服务时调用
    public void onCreate()
    {
        Log.d("StartService", "onCreate");
        super.onCreate();
    }

    //执行startService时调用
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.d("StartService", "onStartCommand");
        new Thread()
        {
            public void run()
            {
                while(true)
                {
                    try
                    {
                        Log.d("StartService", "doSomething");
                        sleep(2000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    //销毁服务时调用
    public void onDestroy()
    {
        Log.d("StartService", "onDestroy");
        super.onDestroy();
    }




}
