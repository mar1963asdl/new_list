package com.example.cjcucsie.new_list;

import android.arch.persistence.room.Dao;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

//   import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Entity> mData;
    private com.example.cjcucsie.new_list.Dao mDb;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
//            public View itemView;

        public ViewHolder(View v) {
            super(v);
//                itemView=v;
            txtButton1 = v.findViewById(R.id.button3);
            mTextView = (TextView) v.findViewById(R.id.info_text);
        }
    }

    public MyAdapter(List<Entity> data, com.example.cjcucsie.new_list.Dao db) {
        mData = data;
        mDb=db;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    Button txtButton1;

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mData.get(position).name);


        txtButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Entity entity = mData.get(position);
                mDb.delete(entity);
                mData.remove(position);
                MyAdapter.this.notifyDataSetChanged();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
          //      Toast.makeText(MainActivity.this, "Item " + position + " is long clicked.", Toast.LENGTH_SHORT).show();
                return true;
            }

        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.button:
//                String itemEntered=item.getText().toString();
//        }
//    }
}