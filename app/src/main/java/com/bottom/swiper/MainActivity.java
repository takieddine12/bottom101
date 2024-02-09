package com.bottom.swiper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
        //recyclerView1 = findViewById(R.id.rv1);
        recyclerView2 = findViewById(R.id.rv2);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

       // setRecyclerView1();
        setRecyclerView2();

        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mBottomSheetBehavior.setPeekHeight(50);

        mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            float prevOffset = 0;

            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                switch (newState) {
//                    case BottomSheetBehavior.STATE_EXPANDED:
//                        mBottomSheetBehavior.setPeekHeight(800);
//                        break;
//                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
//                        mBottomSheetBehavior.setPeekHeight(400);
//                        break;
//                    case BottomSheetBehavior.STATE_COLLAPSED:
//                        mBottomSheetBehavior.setPeekHeight(50);
//                        break;
//                    case BottomSheetBehavior.STATE_DRAGGING:
//                    case BottomSheetBehavior.STATE_SETTLING:
//                    case BottomSheetBehavior.STATE_HIDDEN:
//                        break;
//                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                if (slideOffset < 0.25) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else if (slideOffset < 0.75) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                } else {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });
    }

    private void setRecyclerView2(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView2.setLayoutManager(gridLayoutManager);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setNestedScrollingEnabled(false);
        myAdapter = new MyAdapter(Utils.getImages());
        recyclerView2.setAdapter(myAdapter);
    }

}