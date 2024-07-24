package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String itemName = getIntent().getStringExtra("ITEM_NAME");
        String itemArtist = getIntent().getStringExtra("ITEM_ARTIST");
        String itemDescription = getIntent().getStringExtra("ITEM_DESCRIPTION");
        int itemImage = getIntent().getIntExtra("ITEM_IMAGE", -1);

        ImageView detailImage = findViewById(R.id.detailImage);
        TextView detailName = findViewById(R.id.detailName);
        TextView detailArtist = findViewById(R.id.detailArtist);
        TextView detailDescription = findViewById(R.id.detailDescription);

        detailImage.setImageResource(itemImage);
        detailName.setText(itemName);
        detailArtist.setText(itemArtist);
        detailDescription.setText(itemDescription);

    }
}