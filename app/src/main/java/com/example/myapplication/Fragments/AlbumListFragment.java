package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.AlbumAdapter;
import com.example.myapplication.Model.Album;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;



public class AlbumListFragment extends Fragment {

    private RecyclerView recyclerView;
    private AlbumAdapter adapter;
    private List<Album> albumList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        albumList = new ArrayList<>();
        albumList.add(new Album("Expectation", "D.O.", "K-Pop", 4.5, R.drawable.album1, 150000));
        albumList.add(new Album("Loveshot", "EXO", "K-Pop", 4.5, R.drawable.album2, 250000));
        albumList.add(new Album("Obsession", "EXO", "K-Pop", 4.5, R.drawable.album3, 300000));

        adapter = new AlbumAdapter(getContext(), albumList);
        recyclerView.setAdapter(adapter);

        adapter = new AlbumAdapter(getContext(), albumList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}