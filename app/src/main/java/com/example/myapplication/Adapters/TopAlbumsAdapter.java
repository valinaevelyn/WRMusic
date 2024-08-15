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
import com.example.myapplication.Model.Album;
import com.example.myapplication.R;

import java.util.List;

public class TopAlbumsAdapter extends RecyclerView.Adapter<TopAlbumsAdapter.AlbumViewHolder> {

    private Context context;
    private List<Album> albumList;

    // Constructor for the adapter
    public TopAlbumsAdapter(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.albumCover.setImageResource(album.getImage());
        holder.albumGenre.setText(album.getGenre());
        holder.albumTitle.setText(album.getTitle());
        holder.albumArtist.setText(album.getArtist());
        holder.albumDescription.setText(album.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start DetailActivity
                Intent intent = new Intent(context, DetailActivity.class);

                // Pass album details to DetailActivity
                intent.putExtra("ITEM_NAME", album.getTitle());
                intent.putExtra("ITEM_ARTIST", album.getArtist());
                intent.putExtra("ITEM_DESCRIPTION", album.getDescription());
                intent.putExtra("ITEM_IMAGE", album.getImage());
                intent.putExtra("ITEM_GENRE", album.getGenre());
                intent.putExtra("ITEM_PRICE", album.getPrice());
                intent.putExtra("ITEM_RATING", album.getRating());

                // Start DetailActivity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    // ViewHolder class to hold the views for each album item
    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        ImageView albumCover;
        TextView albumGenre, albumTitle, albumArtist, albumDescription;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            albumCover = itemView.findViewById(R.id.albumCover);
            albumGenre = itemView.findViewById(R.id.albumGenre);
            albumTitle = itemView.findViewById(R.id.albumTitle);
            albumArtist = itemView.findViewById(R.id.albumArtist);
            albumDescription = itemView.findViewById(R.id.albumDescription);
        }
    }
}