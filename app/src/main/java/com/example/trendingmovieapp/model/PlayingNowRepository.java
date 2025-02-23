package com.example.trendingmovieapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.trendingmovieapp.R;
import com.example.trendingmovieapp.retrofit.PlayingMoviesApiService;
import com.example.trendingmovieapp.retrofit.PopularMoviesApiService;
import com.example.trendingmovieapp.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayingNowRepository {
    private ArrayList<Movie> movies = new ArrayList<>();

    private MutableLiveData<List<Movie>> mutableLiveData =
            new MutableLiveData<>();

    private Application application;

    public PlayingNowRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        PlayingMoviesApiService moviesApiService = RetrofitInstance.getPlayingService();

        Call<PlayingNowResponse> call = moviesApiService
                .getPlayingNowMovies(application.getApplicationContext().getString(R.string.api_key));

        // perform network request in the background thread and
        // handle the response in the main (UI) thread
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<PlayingNowResponse> call,
                                   Response<PlayingNowResponse> response) {
                // Success
                PlayingNowResponse playingNowResponse = response.body();

                if (playingNowResponse != null &&
                        playingNowResponse.getPlayingNowResults() != null) {
                    movies = (ArrayList<Movie>) playingNowResponse.getPlayingNowResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<PlayingNowResponse> call, Throwable throwable) {

            }

        });

        return mutableLiveData;
    }
}
