package com.example.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailActivity;
import com.example.myapplication.Model.Item;
import com.example.myapplication.R;

import java.util.Vector;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    Vector<Item> itemVector;
    Context context;

    // Constructor vector


    public ItemAdapter(Context context, Vector<Item> itemVector) {
        this.context = context;
        this.itemVector = itemVector;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        Item item = itemVector.get(position);

        holder.image.setImageResource(item.getImage());
        holder.name.setText(item.getName());
        holder.artist.setText(item.getArtist());
        holder.description.setText(item.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("ITEM_NAME", item.getName());
            intent.putExtra("ITEM_ARTIST", item.getArtist());
            intent.putExtra("ITEM_DESCRIPTION", item.getDescription());
            intent.putExtra("ITEM_IMAGE", item.getImage());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return itemVector.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView description;
        TextView artist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.itemImage);
            name = itemView.findViewById(R.id.itemName);
            artist = itemView.findViewById(R.id.itemArtist);
            description = itemView.findViewById(R.id.itemDescription);
        }
    }
}
