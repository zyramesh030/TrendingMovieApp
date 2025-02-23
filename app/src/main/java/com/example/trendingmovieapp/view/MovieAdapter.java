package com.example.trendingmovieapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendingmovieapp.R;
import com.example.trendingmovieapp.databinding.MoviesListItemBinding;
import com.example.trendingmovieapp.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private final ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MoviesListItemBinding binding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(context),
                        R.layout.movies_list_item,
                        parent,
                        false
                );

        return new MovieViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.moviesListItemBinding.setMovie(movieArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private MoviesListItemBinding moviesListItemBinding;



        public MovieViewHolder(MoviesListItemBinding moviesListItemBinding) {
            super(moviesListItemBinding.getRoot());
            this.moviesListItemBinding = moviesListItemBinding;

            moviesListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
