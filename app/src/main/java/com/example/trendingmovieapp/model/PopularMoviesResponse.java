package com.example.trendingmovieapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMoviesResponse {

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("total_pages")
    @Expose
    private Integer total_pages;

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

    public List<Movie> getPopularMoviesResults() {
        return popularMoviesResults;
    }

    public void setPopularMoviesResults(List<Movie> popularMoviesResults) {
        this.popularMoviesResults = popularMoviesResults;
    }

    @SerializedName("total_results")
    @Expose
    private Integer total_results;
    @SerializedName("results")
    @Expose
    private List<Movie> popularMoviesResults;

    public PopularMoviesResponse() {
    }
}
