package com.example.trendingmovieapp.retrofit;

import com.example.trendingmovieapp.model.PlayingNowResponse;
import com.example.trendingmovieapp.model.PopularMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PopularMoviesApiService {

    @GET("movie/popular")
    Call<PopularMoviesResponse> getPopularMovies(@Query("api_key") String apiKey);
}
