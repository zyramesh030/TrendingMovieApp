package com.example.trendingmovieapp.model;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.trendingmovieapp.BR;
import com.google.gson.annotations.SerializedName;

public class Movie extends BaseObservable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("overview")
    private String overview;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String movieImg;
    @BindingAdapter({"movieImg"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        // Base Url : https://image.tmdb.org/t/p/w500/
        String imagePath = "https://image.tmdb.org/t/p/w500/" + imageUrl;

        Glide.with(imageView.getContext())
                .load(imagePath)
                .into(imageView);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Bindable
    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
        notifyPropertyChanged(BR.overview);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }
}
