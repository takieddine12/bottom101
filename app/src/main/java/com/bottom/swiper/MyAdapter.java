package com.bottom.swiper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Model> arrayList;
    public MyAdapter(ArrayList<Model> arrayList) {
        this.arrayList  = arrayList;
    }

    public OnSizeListener onSizeListener;
    public interface OnSizeListener {
        void onClicked(int height , int width);
    }
    public void onSized(OnSizeListener onSizeListener){
        this.onSizeListener = onSizeListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Model item = arrayList.get(position);
        holder.imageView.setImageResource(item.getImage());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onSizeListener != null){
                    int pos = holder.getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        onSizeListener.onClicked(v.getHeight(),v.getWidth());
                    }
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // Provide a reference to the views for each data item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
