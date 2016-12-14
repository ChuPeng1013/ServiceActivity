package com.example.administrator.serviceactivity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by ChuPeng on 2016/12/13.
 */

public class BindService extends Service
{
    //代理类
    class MyBinder extends Binder
    {
        public String showFirst()
        {
            Log.d("BindService", "First");
            return "BindService, First";
        }

        public String showSecond()
        {
            Log.d("BindService", "Second");
            return "BindService, Second";
        }
    }
    //创建服务时调用
    public void onCreate()
    {
        Log.d("BindService", "onCreate");
        super.onCreate();
    }

    //绑定服务时调用
    public IBinder onBind(Intent intent)
    {
        Log.d("BindService", "onBind");
        return new MyBinder();
    }

    //解除绑定服务时调用
    public boolean onUnbind(Intent intent)
    {
        Log.d("BindService", "onUnbind");
        return super.onUnbind(intent);
    }

    //销毁服务时调用
    public void onDestroy()
    {
        Log.d("BindService", "onDestroy");
        super.onDestroy();
    }
}
