package com.example.gamesinfo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvHolder> {
    public final List<Data> list = new ArrayList<>();
    private ClickGame clickGame;

    @NonNull
    @Override
    public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RvHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RvHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RvHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;
        private final View root;

        public RvHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(v -> {
                clickGame.onClick(getAdapterPosition());
            });
            root = itemView;
        }

        public void onBind(int position) {
            Glide.with(root.getContext())
                    .load(list.get(position).img)
                    .into(imageView);
            textView.setText(list.get(position).name);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<Data> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setClickGame(ClickGame clickGame) {
        this.clickGame = clickGame;
    }
}

