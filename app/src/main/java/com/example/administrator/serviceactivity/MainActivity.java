package com.example.administrator.serviceactivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private Button Start;
    private Button Stop;
    private Button Bind;
    private Button Unbind;
    private Button StartForeground;
    private Button StopForeground;
    private Intent StartIntent;
    private Intent BindIntent;
    private Intent ForegroundIntent;
    private String ShowFirstStr;
    private String ShowSecondStr;
    private TextView Content;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start = (Button) findViewById(R.id.StartService);
        Stop = (Button) findViewById(R.id.StopService);
        Bind = (Button) findViewById(R.id.BindService);
        Unbind = (Button) findViewById(R.id.UnbindService);
        StartForeground = (Button) findViewById(R.id.StartForegroundService);
        StopForeground = (Button) findViewById(R.id.StopForegroundService);
        Content = (TextView) findViewById(R.id.Content);
        StartIntent = new Intent(MainActivity.this, StartService.class);
        BindIntent = new Intent(MainActivity.this, BindService.class);
        ForegroundIntent = new Intent(MainActivity.this, ForegroundService.class);
        Start.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Content.setText("");
                startService(StartIntent);
            }
        });
        Stop.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Content.setText("");
                stopService(StartIntent);
            }
        });
        Bind.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Content.setText("");
                bindService(BindIntent, connection, BIND_AUTO_CREATE);
            }
        });
        Unbind.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Content.setText("");
                unbindService(connection);
            }
        });
        StartForeground.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startService(ForegroundIntent);
            }
        });
        StopForeground.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                stopService(ForegroundIntent);
            }
        });
    }

    ServiceConnection connection = new ServiceConnection()
    {
        //连接到服务
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            Log.d("BindService", "onServiceConnected");
            //拿到后台服务代理对象
            BindService.MyBinder myBinder = (BindService.MyBinder) service;
            //调用后台的方法
            ShowFirstStr = myBinder.showFirst() + "\n";
            ShowSecondStr = myBinder.showSecond() + "\n";
            String str = ShowFirstStr + ShowSecondStr;
            Content.setText(str);
        }

        //断开服务
        public void onServiceDisconnected(ComponentName name)
        {
            Log.d("BindService", "onServiceDisconnected");
        }
    };
}
