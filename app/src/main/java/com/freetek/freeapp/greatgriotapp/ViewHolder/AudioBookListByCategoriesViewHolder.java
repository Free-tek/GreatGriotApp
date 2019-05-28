package com.freetek.freeapp.greatgriotapp.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freetek.freeapp.greatgriotapp.Interface.ItemClickListener;
import com.freetek.freeapp.greatgriotapp.R;

public class AudioBookListByCategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

    public ImageView image;
    public TextView name, author, publisher;

    private ItemClickListener itemClickListener;

    public AudioBookListByCategoriesViewHolder(View itemView) {
        super(itemView);

        image = (ImageView) itemView.findViewById(R.id.image);
        name = (TextView) itemView.findViewById(R.id.name);
        author = (TextView) itemView.findViewById(R.id.author);
        publisher = (TextView) itemView.findViewById(R.id.publisher);

        itemView.setOnClickListener(this);

    }
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }


    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(), false);

    }
}
