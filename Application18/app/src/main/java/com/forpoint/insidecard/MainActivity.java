package com.forpoint.insidecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    //文件名
    private final static String MyFileName="myfile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnWrite=(Button)findViewById(R.id.button);
        Button btnRead=(Button)findViewById(R.id.button2);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out=null;
                try {
                    FileOutputStream fileOutputStream=openFileOutput(MyFileName,MODE_PRIVATE);
                    out=new BufferedOutputStream(fileOutputStream);
                    EditText editText1 = (EditText) findViewById(R.id.EditText);
                    EditText editText2 = (EditText) findViewById(R.id.EditText2);
                    String e1=editText1.getText().toString().trim();
                    String e2=editText2.getText().toString().trim();
                    try {
                        e1 = "学号:" + e1 + '\n';
                        e2 = "姓名:" + e2 + '\n';
                        out.write(e1.getBytes(StandardCharsets.UTF_8));
                        out.write(e2.getBytes(StandardCharsets.UTF_8));
                    }
                    finally {
                        if(out!=null)
                            out.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream in=null;
                try {
                    FileInputStream fileInputStream = openFileInput(MyFileName);
                    in = new BufferedInputStream(fileInputStream);

                    int c;
                    StringBuilder stringBuilder = new StringBuilder("");
                    try {
                        while ((c = in.read()) != -1) {
                            stringBuilder.append((char) c);
                        }
                            TextView t1 = (TextView) findViewById(R.id.textView3);


                            t1.setText(stringBuilder.toString());
                        }

                        finally{
                            if (in != null)
                                in.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

        });
    }
}
