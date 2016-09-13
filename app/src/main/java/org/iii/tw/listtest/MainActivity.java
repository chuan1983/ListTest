package org.iii.tw.listtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private LinkedList<HashMap<String,String>> data;
    private String[] from = {"title","Object"};
    private int[] to = {R.id.item_title,R.id.item_content};
    private EditText inputTitle;
    private SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTitle = (EditText)findViewById(R.id.inputTitle);

        list = (ListView)findViewById(R.id.list);
        initListview();
    }
    private void initListview(){
        data = new LinkedList<>();

        adapter = new SimpleAdapter(
                        this,data,R.layout.layout_item ,from,to);
        list.setAdapter(adapter);

//        list.setOnClickListener(new View.OnClickListener() {      //錯誤寫法
//            @Override
//            public void onClick(View v) {
//                Log.d("brad","ok");
//            }
//        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long 1) {
                Log.d("brad","i=" + i);
                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();   //這裡的this 代表AdapterView而不是context  ,Toast.LENGTH_SHORT顯示ok的時間
            }
        });
    }
    public void addItem(){
        String input = inputTitle.getText().toString();
        HashMap<String,String> dd
                = new HashMap<>();
        dd.put(from[0],input);
        dd.put(from[1],"data.....");
        data.add(dd);
        adapter.notifyDataSetChanged();
    }

    private class R {
    }
}
