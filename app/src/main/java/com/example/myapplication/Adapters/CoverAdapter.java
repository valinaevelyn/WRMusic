package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Cover;
import com.example.myapplication.R;

import java.util.List;

public class CoverAdapter extends RecyclerView.Adapter<CoverAdapter.CoverViewHolder> {

    private Context context;
    private List<Cover> coverList;

    public CoverAdapter(Context context, List<Cover> coverList) {
        this.context = context;
        this.coverList = coverList;
    }

    @NonNull
    @Override
    public CoverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cover, parent, false);
        return new CoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoverViewHolder holder, int position) {
        Cover cover = coverList.get(position);
        holder.coverImage.setImageResource(cover.getImageResId());
        holder.coverLabel.setText(cover.getLabel());
    }

    @Override
    public int getItemCount() {
        return coverList.size();
    }

    public static class CoverViewHolder extends RecyclerView.ViewHolder {

        ImageView coverImage;
        TextView coverLabel;

        public CoverViewHolder(@NonNull View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.coverImage);
            coverLabel = itemView.findViewById(R.id.coverLabel);
        }
    }
}