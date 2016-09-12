package org.iii.tw.listtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

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
