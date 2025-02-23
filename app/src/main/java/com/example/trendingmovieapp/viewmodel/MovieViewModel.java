package com.example.trendingmovieapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.trendingmovieapp.model.Movie;
import com.example.trendingmovieapp.model.PlayingNowRepository;
import com.example.trendingmovieapp.model.PopularMovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    // ViewModel: suitable for non-Android-specific logic
    // AndroidViewModel: used when viewModel class needs to
    //                   access Android-specific components

    private PopularMovieRepository popularMovieRepository;
    private PlayingNowRepository playingNowRepository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        this.popularMovieRepository = new PopularMovieRepository(application);
        this.playingNowRepository = new PlayingNowRepository(application);
    }

    public LiveData<List<Movie>> getAllPopularMovies() {
        return popularMovieRepository.getMutableLiveData();
    }

    public LiveData<List<Movie>> getAllPlayingMovies() {
        return playingNowRepository.getMutableLiveData();
    }
}
