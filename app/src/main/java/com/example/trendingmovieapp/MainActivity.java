package com.example.trendingmovieapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.trendingmovieapp.databinding.ActivityMainBinding;
import com.example.trendingmovieapp.model.Movie;
import com.example.trendingmovieapp.view.MovieAdapter;
import com.example.trendingmovieapp.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button playingButton;
    private Button popularButton;

    private ArrayList<Movie> popularMovies;
    private ArrayList<Movie> playingMovies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding binding;
    private MovieViewModel movieViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        movieViewModel = new ViewModelProvider(this)
                .get(MovieViewModel.class);

        getPlayingMovies();

        swipeRefreshLayout = binding.swipeRefresh;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPlayingMovies();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        playingButton = binding.playingButton;
        popularButton = binding.popularButton;

        playingButton.setOnClickListener(v -> {
            getPopularMovies();
        });

        popularButton.setOnClickListener(v -> {
            getPopularMovies();
        });
    }

    private void getPopularMovies() {

        movieViewModel.getAllPopularMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                popularMovies=  (ArrayList<Movie>) moviesFromLiveData;
                displayPopularMovies();
            }
        });
    }

    private void getPlayingMovies() {

        movieViewModel.getAllPlayingMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                playingMovies=  (ArrayList<Movie>) moviesFromLiveData;
                displayPlayingMovies();
            }
        });
    }
    private void displayPopularMovies() {

        recyclerView = binding.recyclerview;

        movieAdapter = new MovieAdapter(this, popularMovies);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        movieAdapter.notifyDataSetChanged();
    }

    private void displayPlayingMovies() {

        recyclerView = binding.recyclerview;

        movieAdapter = new MovieAdapter(this, playingMovies);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        movieAdapter.notifyDataSetChanged();
    }
}