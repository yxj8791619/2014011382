package com.example.application_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //SharedPreferences文件名
    private final static String SharedPreferencesFileName="config";    //键
    private final static String Key_UserName="UserName";//用户名
    private final static String Key_LoginDate="LoginDate";//登录时间
    private final static String Key_UserType="UserType";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得SharedPreferences实例
        preferences=getSharedPreferences(SharedPreferencesFileName,MODE_PRIVATE);
        editor=preferences.edit();

    }

    public void onWriteClick(View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strLoginDate = simpleDateFormat.format(new Date());
        //写入键值对
        editor.putString(Key_UserName, "Zhang san");
        editor.putString(Key_LoginDate, strLoginDate);
        editor.putInt(Key_UserType, 1);
        editor.apply();
        Toast.makeText(this,"数据写入",Toast.LENGTH_LONG).show();
    }

    public void onReadClick(View view) {
        String strUserName = preferences.getString(Key_UserName, null);
        String strLoginDate = preferences.getString(Key_LoginDate, null);
        int nUserType=preferences.getInt(Key_UserType,0);

        if (strUserName != null && strLoginDate != null)
            Toast.makeText(MainActivity.this, "用户名:" + strUserName + "登录时间:" + strLoginDate+"用户类型:"+nUserType, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
    }
}
