package com.example.administrator.application_calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int mark = 0;
    int dotmark = 0;
    String txt = "";
    String txt2 = "";
    String lastsub = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
    public void n_0(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "0";
        mark=0;
        text.setText(txt);
    }
    public void n_1(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "1";
        mark=0;
        text.setText(txt);
    }
    public void n_2(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "2";
        mark=0;
        text.setText(txt);
    }
    public void n_3(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "3";
        mark=0;
        text.setText(txt);
    }
    public void n_4(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "4";
        mark=0;
        text.setText(txt);
    }
    public void n_5(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "5";
        mark=0;
        text.setText(txt);
    }
    public void n_6(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "6";
        mark=0;
        text.setText(txt);
    }
    public void n_7(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "7";
        mark=0;
        text.setText(txt);
    }
    public void n_8(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "8";
        mark=0;
        text.setText(txt);
    }public void n_9(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "9";
        mark=0;
        text.setText(txt);
    }
    public void dot(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        if(mark == 0 && dotmark == 0){
            txt += ".";
            dotmark = 1;
        }
        mark = 1;
        text.setText(txt);
    }
    public void h(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        txt += "/100";
        text.setText(txt);
    }
    public void delete(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        lastsub = txt.substring(txt.length()-1,txt.length());
        if(lastsub.equals(".")){
          dotmark = 0;
        }
        if(txt!="" && txt!=null && txt.length()>0){
            txt = txt.substring(0,txt.length()-1);
        }else{
            txt = "";
        }
        mark = 0;
        text.setText(txt);

    }

     public void add(View v){
        TextView text=(TextView)findViewById(R.id.textView);
         if(mark == 0){
        txt += "+";
         }else{
             txt = txt.substring(0,txt.length()-1);
             txt += "+";
         }
         mark = 1;
         dotmark = 0;
        text.setText(txt);
    }
    public void reduce(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        if(mark == 0){
            txt += "-";
        }else{
            txt = txt.substring(0,txt.length()-1);
            txt += "-";
        }
        mark = 1;
        text.setText(txt);
    }
public void X(View v){
    TextView text=(TextView)findViewById(R.id.textView);
    if(mark == 0){
        txt += "*";
    }else{
        txt = txt.substring(0,txt.length()-1);
        txt += "*";
    }
    mark = 1;
    text.setText(txt);

}
    public void divide(View v){
        TextView text=(TextView)findViewById(R.id.textView);
        if(mark == 0){
            txt += "/";
        }else{
            txt = txt.substring(0,txt.length()-1);
            txt += "/";
        }
        mark = 1;
        text.setText(txt);
    }
    public void result(View v) {
        TextView text2 = (TextView) findViewById(R.id.textView2);

        CalculateStack cl = CalculateStack.getCalculateInstance();
        txt2 = cl.Calculate(txt, 5);
        text2.setText(txt2);
    }
    public void C(View v) {
        TextView text = (TextView) findViewById(R.id.textView);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        mark = 0;
        dotmark = 0;
        txt = "";
        txt2 = "";
        text.setText("");
        text2.setText("");
    }
}
