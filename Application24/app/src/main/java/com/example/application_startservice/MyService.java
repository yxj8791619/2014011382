package com.example.application_startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private static final String TAG="ServiceTag";
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.v(TAG,"onCreate()");
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG,"onStartCommand()");
        Toast.makeText(getApplicationContext(),"onStartCommand",Toast.LENGTH_SHORT).show();
        int n=intent.getIntExtra("num",0);
        Log.v(TAG,"random int is:"+n);
        Toast.makeText(getApplicationContext(),"random int is:"+n,Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.v(TAG,"onDestroy()");
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG,"onBind()");
        Toast.makeText(getApplicationContext(),"onBind",Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(TAG,"onUnbind()");
        Toast.makeText(getApplicationContext(),"onUnbind",Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }
}
