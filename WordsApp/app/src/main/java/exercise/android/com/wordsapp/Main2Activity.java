package exercise.android.com.wordsapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2Activity extends Activity {
    private EditText searchText;
    private Button btn_search;
    private TextView  searchresult;
    private String YOUDAO_URL ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        searchText=(EditText)findViewById(R.id.searchcontent);
        btn_search=(Button)findViewById(R.id.btn_search);
        searchresult=(TextView)findViewById(R.id.searchresult);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String SearchContent=searchText.getText().toString().trim();
                if(SearchContent.equals("")){
                    Toast.makeText(Main2Activity.this, "请输入要查询的内容！", Toast.LENGTH_LONG).show();
                }else{

                    YOUDAO_URL ="http://fanyi.youdao.com/openapi.do?keyfrom=haobaoshui&key=1650542691&type=data&doctype=json&version=1.1&q="+SearchContent;
                    try{
                        Thread t = new NetworkThread();
                        t.start();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });


    }



    class NetworkThread extends Thread{
        public void run(){

            Looper.prepare();

            try {
                Analyze analyze = new Analyze();
                analyze.AnalyzingOfJson(YOUDAO_URL);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    class Analyze extends Activity {
        public  void AnalyzingOfJson(String youDaoUrl) throws Exception {
            // TODO Auto-generated method stub
            HttpGet httpGet= new HttpGet(youDaoUrl);
            HttpResponse httpResponse= new DefaultHttpClient().execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode()==200){
                // String result= EntityUtils.toString(httpResponse.getEntity());
                BufferedReader input1= new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent())) ;
                StringBuilder sb= new StringBuilder();

                for(String s=input1.readLine();s!=null;s=input1.readLine()){
                    sb.append(s);
                }
                String result=sb.toString();
                System.out.println("result="+result);
                JSONArray jsonArray= new JSONArray("["+result+"]");
                // String message=null;
                StringBuilder message=new StringBuilder();
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);
                    if(jsonObject!=null) {
                        String errorCode = jsonObject.getString("errorCode");

                        if (errorCode.equals("0")) {
                            String query = jsonObject.getString("query");
                            //message=query;
                            message.append(query);
                            String translation = jsonObject.getString("translation");
                            // message+="\t"+translation;
                            message.append("\t" + translation);

                            if (jsonObject.has("basic")) {
                                JSONObject basic = jsonObject.getJSONObject("basic");
                                if (basic.has("phonetic")) {
                                    String phonetic = basic.getString("phonetic");
                                    // message+="\n\t"+phonetic;
                                    message.append("\n\t音标：[" + phonetic + "]");
                                }
                                if (basic.has("explains")) {
                                    String explains = basic.getString("explains");
                                    //message+="\n\t"+explains;
                                    message.append("\n\t" + explains);
                                }
                            }
                            if (jsonObject.has("web")) {
                                String web = jsonObject.getString("web");
                                JSONArray webstring = new JSONArray("[" + web + "]");
                                // message+="\n网络释义：";
                                message.append("\n网络释义：");
                                JSONArray webArray = webstring.getJSONArray(0);
                                int count = 0;
                                while (!webArray.isNull(count)) {
                                    if (webArray.getJSONObject(count).has("key")) {
                                        String key = webArray.getJSONObject(count).getString("key");
                                        //message+="\n\t<"+(count+1)+">"+key;
                                        message.append("\n\t<" + (count + 1) + ">" + key);

                                    }
                                    if (webArray.getJSONObject(count).has("value")) {
                                        String value = webArray.getJSONObject(count).getString("value");
                                        //message+="\n\t "+value;
                                        message.append("\n\t " + value);

                                    }
                                    count++;
                                }

                            }


                        } else{
                            Toast.makeText(getApplicationContext(), "Bad request", Toast.LENGTH_LONG).show();
                         }
                    }else{
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
                searchresult.setText(message.toString());

            }
            else{
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        }
    }

}
