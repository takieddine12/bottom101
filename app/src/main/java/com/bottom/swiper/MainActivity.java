package com.bottom.swiper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    private RecyclerView recyclerView1,recyclerView2;
    private MyAdapter myAdapter;
    private TextView mTextViewState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        recyclerView1 = findViewById(R.id.rv1);
        recyclerView2 = findViewById(R.id.rv2);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        setRecyclerView1();
        setRecyclerView2();
    }

    private void setRecyclerView1(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        recyclerView1.setLayoutManager(gridLayoutManager);
        recyclerView1.setHasFixedSize(true);

        myAdapter = new MyAdapter(Utils.getImages());
        recyclerView1.setAdapter(myAdapter);
    }
    private void setRecyclerView2(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setHasFixedSize(true);

        myAdapter = new MyAdapter(Utils.getImages());
        recyclerView2.setAdapter(myAdapter);
    }
}