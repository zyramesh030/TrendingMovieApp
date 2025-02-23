package com.example.trendingmovieapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayingNowResponse {
    @SerializedName("dates")
    @Expose
    private List<Dates> date;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<Movie> playingNowResults;
    @SerializedName("total_pages")
    @Expose
    private Integer total_pages;

    @SerializedName("total_results")
    @Expose
    private Integer total_results;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }



    public List<Dates> getDate() {
        return date;
    }

    public void setDate(List<Dates> date) {
        this.date = date;
    }


    public PlayingNowResponse() {
    }

    public List<Movie> getPlayingNowResults() {
        return playingNowResults;
    }

    public void setPlayingNowResults(List<Movie> playingNowResults) {
        this.playingNowResults = playingNowResults;
    }
}
