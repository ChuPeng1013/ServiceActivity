package com.example.administrator.serviceactivity;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

/**
 * Created by ChuPeng on 2016/12/14.
 */

public class ForegroundService extends Service
{
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //创建点击跳转的Intent
        Intent foregroundIntent = new Intent(ForegroundService.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, foregroundIntent, 0);
        //构建通知
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("2016年12月14日")
                .setContentText("今天空气质量：非常不利于健康")
                .setContentIntent(pendingIntent);//设置跳转的Intent到通知中
        //构建通知
        Notification notification = builder.build();
        startForeground(1, notification);
        return super.onStartCommand(intent, flags, startId);
    }
}
