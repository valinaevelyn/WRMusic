package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.util.Log;

import com.example.myapplication.Model.Album;
import com.example.myapplication.R;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    public AlbumAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        Log.d("AlbumAdapter", "Binding album: " + album.getTitle());
        holder.albumTitle.setText(album.getTitle());
        holder.albumArtist.setText(album.getArtist());
        holder.albumGenre.setText(album.getGenre());
        holder.albumRating.setText(String.valueOf(album.getRating()));
        holder.albumCover.setImageResource(album.getImage());
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        ImageView albumCover;
        TextView albumTitle, albumArtist, albumGenre, albumRating;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            albumCover = itemView.findViewById(R.id.albumCover);
            albumTitle = itemView.findViewById(R.id.albumTitle);
            albumArtist = itemView.findViewById(R.id.albumArtist);
            albumGenre = itemView.findViewById(R.id.albumGenre);
            albumRating = itemView.findViewById(R.id.albumRating);
        }
    }
}
