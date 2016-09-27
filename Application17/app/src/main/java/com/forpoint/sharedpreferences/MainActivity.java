package com.forpoint.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        //SharedPreferences文件名
        private final static String SharedPreferencesFileName="config";

        //键
        private final static String Key_Id="0001";//用户名
        private final static String Key_Name="Name";//登录时间

        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //获得SharedPreferences实例
            preferences = getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
            editor = preferences.edit();

            Button btnWrite = (Button) findViewById(R.id.button);
            Button btnRead = (Button) findViewById(R.id.button2);
            btnWrite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    EditText editTextId = (EditText) findViewById(R.id.EditText);
                    EditText editTextName = (EditText) findViewById(R.id.EditText2);
                    String sId = editTextId.getText().toString().trim();

                    String sName = editTextName.getText().toString().trim();
                    //写入键值对
                    editor.putString(Key_Id, sId);
                    editor.putString(Key_Name, sName);

                    //提交修改，此处换成commit()也可以
                    editor.apply();
                }
            });

            btnRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String strUserName = preferences.getString(Key_Id, null);
                    String strLoginDate = preferences.getString(Key_Name, null);


                    if (strUserName != null && strLoginDate != null) {
                        Toast.makeText(MainActivity.this, "Id:" + strUserName + "Name:" + strLoginDate, Toast.LENGTH_LONG).show();
                        TextView textView = (TextView) findViewById(R.id.textView3);
                        TextView textView2 = (TextView) findViewById(R.id.textView4);

                        textView.setText(strUserName);
                        textView2.setText(strLoginDate);
                    }
                    else
                        Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
                }
            });
        }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
