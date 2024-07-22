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
        itemVector.add(new Item(1, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode));
        itemVector.add(new Item(1, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts));
        itemVector.add(new Item(1, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage));

        itemVector.add(new Item(1, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode));
        itemVector.add(new Item(1, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts));
        itemVector.add(new Item(1, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage));

        itemVector.add(new Item(1, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode));
        itemVector.add(new Item(1, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts));
        itemVector.add(new Item(1, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage));

        itemVector.add(new Item(1, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode));
        itemVector.add(new Item(1, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts));
        itemVector.add(new Item(1, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage));

        itemVector.add(new Item(1, "An Ode", "Seventeen", "Album Seventeen Yang Keren", R.drawable.anode));
        itemVector.add(new Item(1, "Face The Sun", "Seventeen", "Album Seventeen Yang Bagus", R.drawable.fts));
        itemVector.add(new Item(1, "Teenage", "Seventeen", "Album Seventeen Yang Lucu", R.drawable.teenage));


        adapter = new ItemAdapter(itemVector);

        recyclerView.setAdapter(adapter);
    }
}