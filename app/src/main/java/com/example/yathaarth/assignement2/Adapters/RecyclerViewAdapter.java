package com.example.yathaarth.assignement2.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yathaarth.assignement2.Models.SocialItem;
import com.example.yathaarth.assignement2.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<SocialItem> items;
    Activity context;

    public RecyclerViewAdapter(Activity context, List<SocialItem> items){
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Inflate view and create ViewHolder

        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.socialitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Use holder to bind values
        SocialItem item = items.get(position);
        holder.desc.setText(item.getDesc());
        holder.name.setText(item.getName());
        holder.icon.setImageResource(item.getImage_resource_id());

    }

    @Override
    public int getItemCount() {
//        Return size of list
        return items.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView desc;
        ImageView icon;
        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            desc = v.findViewById(R.id.description);
            icon = v.findViewById(R.id.app_icon);
        }
    }
}

