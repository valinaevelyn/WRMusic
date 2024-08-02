package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.ItemAdapter;
import com.example.myapplication.Model.Item;
import com.example.myapplication.R;

import java.util.Vector;

public class ItemFragment extends Fragment {

    RecyclerView recyclerView;
    ItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

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

        adapter = new ItemAdapter(getContext(), itemVector);

        recyclerView.setAdapter(adapter);
    }
}
