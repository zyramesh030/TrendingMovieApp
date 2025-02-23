package com.example.trendingmovieapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.trendingmovieapp.R;
import com.example.trendingmovieapp.retrofit.PopularMoviesApiService;
import com.example.trendingmovieapp.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMovieRepository {

    private ArrayList<Movie> movies = new ArrayList<>();

    private MutableLiveData<List<Movie>> mutableLiveData =
            new MutableLiveData<>();

    private Application application;

    public PopularMovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        PopularMoviesApiService moviesApiService = RetrofitInstance.getPopularService();

        Call<PopularMoviesResponse> call = moviesApiService
                .getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        // perform network request in the background thread and
        // handle the response in the main (UI) thread
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<PopularMoviesResponse> call,
                                   Response<PopularMoviesResponse> response) {
                // Success
                PopularMoviesResponse popularMoviesResponse = response.body();

                if (popularMoviesResponse != null &&
                        popularMoviesResponse.getPopularMoviesResults() != null) {
                    movies = (ArrayList<Movie>) popularMoviesResponse.getPopularMoviesResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<PopularMoviesResponse> call, Throwable throwable) {

            }
        });

        return mutableLiveData;
    }
}
