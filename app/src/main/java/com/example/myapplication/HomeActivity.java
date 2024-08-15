package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Adapters.CoverAdapter;
import com.example.myapplication.Adapters.ImagePagerAdapter;
import com.example.myapplication.Adapters.TopAlbumsAdapter;
import com.example.myapplication.Fragments.AlbumListFragment;
import com.example.myapplication.Model.Album;
import com.example.myapplication.Model.Cover;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        viewPager = findViewById(R.id.viewPager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(this, imageIds);
        viewPager.setAdapter(adapter);

        autoSlideImages();

        topAlbumsRecyclerView = findViewById(R.id.topAlbumsRecyclerView);
        topAlbumsRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;  // Disable scrolling within the RecyclerView
            }
        });


        albumList = new ArrayList<>();
        albumList.add(new Album("Expectation", "D.O.", "K-Pop", 4.5, R.drawable.album1, 250000, "Lorem ipsum dolor sit amet, consectetur adipiscing."));
        albumList.add(new Album("Loveshot", "EXO", "K-Pop", 4.5, R.drawable.album2, 250000, "Lorem ipsum dolor sit amet, consectetur adipiscing."));
        albumList.add(new Album("Obsession", "EXO", "K-Pop", 4.5, R.drawable.album3, 250000, "Lorem ipsum dolor sit amet, consectetur adipiscing."));
        albumList.add(new Album("Room No.1", "Lee Mu Jin", "K-Pop", 4.5, R.drawable.album4, 250000, "Lorem ipsum dolor sit amet, consectetur adipiscing."));
        albumList.add(new Album("The War", "EXO", "K-Pop", 4.5, R.drawable.album5, 250000, "Lorem ipsum dolor sit amet, consectetur adipiscing."));

        topAlbumsAdapter = new TopAlbumsAdapter(this, albumList);
        topAlbumsRecyclerView.setAdapter(topAlbumsAdapter);

        FrameLayout fragmentContainer = findViewById(R.id.new_albums);
        fragmentContainer.setVisibility(View.VISIBLE);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.new_albums, new AlbumListFragment());
            transaction.commit();
        }

        diverseSoundsRecyclerView = findViewById(R.id.diverseSoundsRecyclerView);
        diverseSoundsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Initialize the list and adapter
        coverList = new ArrayList<>();
        coverList.add(new Cover(R.drawable.sample_cover, "Label 1"));
        coverList.add(new Cover(R.drawable.cover2, "Label 2"));
        coverList.add(new Cover(R.drawable.cover3, "Label 3"));
        coverList.add(new Cover(R.drawable.cover1, "Label 4"));
        coverList.add(new Cover(R.drawable.cover5, "Label 5"));
        // Add more items as needed...

        coverAdapter = new CoverAdapter(this, coverList);
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
            }
        };

        // Schedule the auto-slide to run every 3 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(update, 2000); // Slide every 3 seconds
                update.run(); // Start the first slide immediately
            }
        }, 1000);
    }
}
