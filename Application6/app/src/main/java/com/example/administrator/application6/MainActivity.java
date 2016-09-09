package com.example.administrator.application6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
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
       TextView textView=(TextView)findViewById(R.id.textView3);
        registerForContextMenu(textView);
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
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "settings",
                Toast.LENGTH_SHORT).show();
                TextView txt_settings =(TextView)findViewById(R.id.textView_menu);
                txt_settings.setText("用户点击了设置选项");
                break;
            case R.id.menu_another:
                Toast.makeText(this, "another",
                Toast.LENGTH_SHORT).show();
                TextView txt_another =(TextView)findViewById(R.id.textView_menu);
                txt_another.setText("用户点击了其它选项");
                break;
            case R.id.menu_about:
                Toast.makeText(this, "about",
                 Toast.LENGTH_SHORT).show();
                TextView txt_about =(TextView)findViewById(R.id.textView_menu);
                txt_about.setText("用户点击了关于选项");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_content, menu);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "settings",
            Toast.LENGTH_SHORT).show();
                TextView txt_settings =(TextView)findViewById(R.id.textView_contextmenu);
                txt_settings.setText("用户点击了设置选项");
                break;
            case R.id.menu_another:
                Toast.makeText(this, "another",
            Toast.LENGTH_SHORT).show();
                TextView txt_another =(TextView)findViewById(R.id.textView_contextmenu);
                txt_another.setText("用户点击了其它选项");
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "settings",
                        Toast.LENGTH_SHORT).show();
                TextView txt_settings =(TextView)findViewById(R.id.textView_popupmenu);
                txt_settings.setText("用户点击了设置选项");
                break;
            case R.id.menu_another:
                Toast.makeText(this, "another",
                        Toast.LENGTH_SHORT).show();
                TextView txt_another =(TextView)findViewById(R.id.textView_popupmenu);
                txt_another.setText("用户点击了其它选项");
                break;
        }
        return false;
    }


}
