package com.example.administrator.application3;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    public void ok(View view){
        TextView txt = (TextView)findViewById(R.id.textView_content);
        txt.setText("确认选择");
    }

  public void radioButton1(View view){
       EditText editText = (EditText)findViewById(R.id.editText_content);
      editText.setText("单选1");
  }
    public void radioButton2(View view){
        EditText editText = (EditText)findViewById(R.id.editText_content);
        editText.setText("单选2");
    }
    public void checkBox1(View view){
        String choose = "";
        CheckBox checkbox1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox checkbox2 = (CheckBox)findViewById(R.id.checkBox2);
        if(checkbox1.isChecked())choose += checkbox1.getText().toString() + " ";
        if(checkbox2.isChecked())choose += checkbox2.getText().toString() + " ";
        TextView text = (TextView)findViewById(R.id.editText_content);
        text.setText(choose);
    }

}
