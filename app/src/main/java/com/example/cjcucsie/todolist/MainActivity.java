package com.example.cjcucsie.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private RecyclerView rv;
    private MyAdapter adapter;
    private ArrayList<String> mData = new ArrayList<>();
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //準備資料，塞50個項目到ArrayList裡
        for (int i=0;i<50;i++)
        {
            mData.add("項目"+i);
        }

        //連結元件
        rv=(RecyclerView)findViewById(R.id.recycler_view);
        btnAdd=(Button)findViewById(R.id.btnAdd);

        //設置RecyclerView為列表型態
        rv.setLayoutManager(new LinearLayoutManager(this));

        //設置路線
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //將資料交給adapter
        adapter=new MyAdapter(mData);

        //設置adapter給recycler_view
        rv.setAdapter(adapter);

        //新增一個項目
        btnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                adapter.addItem("New Item");
            }
        });
    }


}
