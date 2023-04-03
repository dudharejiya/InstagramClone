package com.example.instagramclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<CardItem> cardItemList;

    public CardAdapter(List<CardItem> cardItemList) {
        this.cardItemList = cardItemList;
    }

    @NonNull

    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_cardview, parent, false);
        return new CardViewHolder(view);
    }


    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem currentItem = cardItemList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.image.setImageResource(currentItem.getImageResource());
    }


    public int getItemCount() {
        return cardItemList.size();
    }
}

