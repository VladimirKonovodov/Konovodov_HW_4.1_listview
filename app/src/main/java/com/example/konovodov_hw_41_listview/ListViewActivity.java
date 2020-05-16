package com.example.konovodov_hw_41_listview;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListViewActivity extends AppCompatActivity {
    public static final String KEY_1 = "one";
    public static final String KEY_2 = "two";

    public List<Map<String, String>> mapList = new ArrayList<>();
    //public Map<String, String> map = new HashMap<>();
    //private ListView simpleListView;
    private ListView list;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = findViewById(R.id.list);

        prepareContent();

        list.setAdapter(createSimpleAdapter(mapList));

    }

    @NonNull
    private BaseAdapter createSimpleAdapter(List<Map<String, String>> values) {
        return new SimpleAdapter(this, values, R.layout.activity_main,
                new String[]{KEY_1, KEY_2}, new int[]{R.id.oneTttv, R.id.twoTttv});
        //simpleListView.setAdapter(list);
    }

    @NonNull
    private void prepareContent() {

        for (int i = 0; i < getString(R.string.large_text).split("\n\n").length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(KEY_2, String.valueOf(getString(R.string.large_text).split("\n\n")[i].length()));
            map.put(KEY_1, getString(R.string.large_text).split("\n\n")[i]);
            mapList.add(map);
        }
    }
}
