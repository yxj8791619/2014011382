package com.example.administrator.application4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final static String PRODUCT="product";
    private final static String PRICE="price";
    private final static String CONFIGURATION="configuration";

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

        String[] names={"张三","李四","王五","赵六"};
        String[] sexs={"男","女","男","女"};
        String[] nums={"123456","234567","345678","456789"};
        String[] phones={"13000000000","13000000001","13000000002","13000000003"};

        List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();

        for(int i=0;i<names.length;i++)
        {
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("name",names[i]);
            item.put("sex",sexs[i]);
            item.put("num",nums[i]);
            item.put("phone",phones[i]);
            items.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.item,
                new String[]{"name","sex","num","phone"},
                new int[]{R.id.txtName,R.id.txtSex,R.id.txtNum,R.id.txtPhone}
        );

        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
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
