package com.example.instagramclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class postRVadapter extends RecyclerView.Adapter<postRVadapter.Viewholder>{

    private List<CardViewItem> cardViewItemList;

    public postRVadapter(List<CardViewItem> cardViewItemList){
        this.cardViewItemList = cardViewItemList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_cardview, parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        CardViewItem item = cardViewItemList.get(position);
        holder.titleTextView.setText(item.getTitle());

        Glide.with(holder.itemView.getContext())
                .load(item.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return cardViewItemList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder{

        //cardView items to be changed
        public ImageView imageView;
        public TextView titleTextView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.post_image_view);
            titleTextView = itemView.findViewById(R.id.post_title_text_view);
        }
    }

}
