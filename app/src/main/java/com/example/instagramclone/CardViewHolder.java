package com.example.instagramclone;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CardViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    ImageView image;

    public CardViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.card_title);
        image = itemView.findViewById(R.id.card_image);
    }

}
