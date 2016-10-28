package com.example.application_fileinputoutput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final String fileName = "testfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onWriteClick(View view) {
        OutputStream out=null;
        try {
            FileOutputStream fileOutputStream=openFileOutput(fileName,MODE_PRIVATE);
            out=new BufferedOutputStream(fileOutputStream);
            String content="hello world";
            try {
                out.write(content.getBytes(StandardCharsets.UTF_8));
            }
            finally {
                if(out!=null)
                    out.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(this,"数据写入",Toast.LENGTH_LONG).show();
    }

    public void onReadClick(View view) {
        InputStream in=null;
        try {
            FileInputStream fileInputStream = openFileInput(fileName);
            in=new BufferedInputStream(fileInputStream);
            int c;
            StringBuilder stringBuilder=new StringBuilder("");
            try{
                while ((c=in.read())!=-1) {
                    stringBuilder.append((char)c);
                }
                Toast.makeText(MainActivity.this,stringBuilder.toString(),Toast.LENGTH_LONG).show();
            }
            finally {
                if(in!=null)
                    in.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
