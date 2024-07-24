package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adapters.ItemAdapter;
import com.example.myapplication.Model.Item;

import java.util.Vector;

public class ItemActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        Vector<Item> itemVector = new Vector<>();
        itemVector.add(new Item(1, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode, "K-Pop", 500000, 4.5));
        itemVector.add(new Item(2, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts, "Pop", 900000, 4.8));
        itemVector.add(new Item(3, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage, "Jazz", 650000, 4.7));

        itemVector.add(new Item(4, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode, "K-Pop", 500000, 4.5));
        itemVector.add(new Item(5, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts, "Pop", 900000, 4.8));
        itemVector.add(new Item(6, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage, "Jazz", 650000, 4.7));

        itemVector.add(new Item(7, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode, "K-Pop", 500000, 4.5));
        itemVector.add(new Item(8, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts, "Pop", 900000, 4.8));
        itemVector.add(new Item(9, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage, "Jazz", 650000, 4.7));

        itemVector.add(new Item(10, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode, "K-Pop", 500000, 4.5));
        itemVector.add(new Item(11, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts, "Pop", 900000, 4.8));
        itemVector.add(new Item(12, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage, "Jazz", 650000, 4.7));

        itemVector.add(new Item(13, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode, "K-Pop", 500000, 4.5));
        itemVector.add(new Item(14, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts, "Pop", 900000, 4.8));
        itemVector.add(new Item(15, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage, "Jazz", 650000, 4.7));

        adapter = new ItemAdapter(this, itemVector);

        recyclerView.setAdapter(adapter);
    }
}