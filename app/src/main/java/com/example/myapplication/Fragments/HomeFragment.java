package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapters.CoverAdapter;
import com.example.myapplication.Adapters.ImagePagerAdapter;
import com.example.myapplication.Adapters.TopAlbumsAdapter;
import com.example.myapplication.Model.Album;
import com.example.myapplication.Model.Cover;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView topAlbumsRecyclerView;  // Declare RecyclerView
    private List<Album> albumList;  // Declare List for Albums
    private TopAlbumsAdapter topAlbumsAdapter;  // Declare Adapter
    private ViewPager viewPager;
    private int[] imageIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private ImagePagerAdapter adapter;
    private int currentPage = 0;
    private Handler handler = new Handler();

    private RecyclerView diverseSoundsRecyclerView;
    private CoverAdapter coverAdapter;
    private List<Cover> coverList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewPager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(getContext(), imageIds);
        viewPager.setAdapter(adapter);

        autoSlideImages();

        topAlbumsRecyclerView = view.findViewById(R.id.topAlbumsRecyclerView);
        topAlbumsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;  // Disable scrolling within the RecyclerView
            }
        });


        albumList = new ArrayList<>();
        albumList.add(new Album("Expectation", "D.O.", "K-Pop", 4.5, R.drawable.album1, 150000, "Lorem ipsum dolor sit amet, consectetur adipiscing."));
        albumList.add(new Album("Loveshot", "EXO", "K-Pop", 4.5, R.drawable.album2, 250000, "Lorem ipsum dolor sit amet, consectetur adipiscing."));
        albumList.add(new Album("Obsession", "EXO", "K-Pop", 4.5, R.drawable.album3, 300000, "Lorem ipsum dolor sit amet, consectetur adipiscing."));

        topAlbumsAdapter = new TopAlbumsAdapter(getContext(), albumList);
        topAlbumsRecyclerView.setAdapter(topAlbumsAdapter);

        FrameLayout newAlbums = view.findViewById(R.id.new_albums);
        newAlbums.setVisibility(View.VISIBLE);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.new_albums, new AlbumListFragment());
            transaction.commit();
        }

        diverseSoundsRecyclerView = view.findViewById(R.id.diverseSoundsRecyclerView);
        diverseSoundsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // Initialize the list and adapter
        coverList = new ArrayList<>();
        coverList.add(new Cover(R.drawable.sample_cover, "Label 1"));
        coverList.add(new Cover(R.drawable.cover2, "Label 2"));
        coverList.add(new Cover(R.drawable.cover3, "Label 3"));
        coverList.add(new Cover(R.drawable.cover1, "Label 4"));
        coverList.add(new Cover(R.drawable.cover5, "Label 5"));
        // Add more items as needed...

        coverAdapter = new CoverAdapter(getContext(), coverList);
        diverseSoundsRecyclerView.setAdapter(coverAdapter);
    }


    private void autoSlideImages() {
        final Runnable update = new Runnable() {
            public void run() {
                // Check if the current page is the last one, if so, reset to the first page
                if (currentPage == imageIds.length) {
                    currentPage = 0;
                }
                // Set the current item in the ViewPager and animate the transition
                viewPager.setCurrentItem(currentPage++, true);

                // Post the Runnable again after 3 seconds
                handler.postDelayed(this, 3000); // Slide every 3 seconds
            }
        };

        // Start the first slide immediately and continue every 3 seconds
        handler.postDelayed(update, 3000);
    }
}
