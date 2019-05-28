package com.freetek.freeapp.greatgriotapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.TextView;

import com.freetek.freeapp.greatgriotapp.Interface.ItemClickListener;
import com.freetek.freeapp.greatgriotapp.R;

public class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView user, comment;

    private ItemClickListener itemClickListener;

    public CommentViewHolder(View itemView) {
        super(itemView);

        user = (TextView) itemView.findViewById(R.id.user);
        comment = (TextView) itemView.findViewById(R.id.comment);

        itemView.setOnClickListener(this);

    }

        public void setItemClickListener (ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }


        @Override
        public void onClick (View view){
        itemClickListener.onClick(view, getAdapterPosition(), false);

    }

    }