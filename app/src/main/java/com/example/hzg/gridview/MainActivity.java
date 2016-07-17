package com.example.hzg.gridview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;
    private int[] img={ R.drawable.address_book, R.drawable.calendar,
            R.drawable.camera, R.drawable.clock, R.drawable.games_control,
            R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
            R.drawable.speech_balloon, R.drawable.weather,
            R.drawable.world, R.drawable.youtube };
    String[] name={"联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置",
            "语音", "天气", "浏览器", "Youtube" };

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gridView);
        dataList = new ArrayList<Map<String,Object>>();
        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"img", "name"}, new int[]{R.id.img, R.id.name});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);
    }

    public List<Map<String,Object>> getData(){
        for (int i = 0; i < img.length; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("img", img[i]);
            map.put("name", name[i]);
            dataList.add(map);
        }
        Log.i("Main", "size=" + dataList.size());
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "我是" + name[position], Toast.LENGTH_LONG).show();
    }
}
