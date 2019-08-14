package com.example.luis.androidrestudy.activity.item_activity.recycler_view;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> mDatas = new ArrayList<>();

    public ItemAdapter(List<Item> mDatas) {
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.base_recyclerview_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Item item = mDatas.get(i);
        final String itemD = mDatas.get(i).getmName();
        viewHolder.itemImage.setImageResource(item.getmImageRes());
        viewHolder.itemDescription.setText(item.getmName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LuisApplication.getContext(),"点击了 "+itemD+" ",Toast.LENGTH_LONG).show();
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(LuisApplication.getContext(),"长按了 "+itemD+" ",Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size() ;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;

        TextView itemDescription;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.recycler_item_image);
            itemDescription = itemView.findViewById(R.id.recycler_item_description);
        }
    }
}
