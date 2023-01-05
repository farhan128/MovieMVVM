package com.demo.moviemvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.moviemvvm.R;
import com.demo.moviemvvm.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private List<Movie> movieList;

    public MovieAdapter() {

    }

    @NonNull
    @Override
    public MovieAdapter.MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieHolder holder, int position) {
        final Movie movie = movieList.get(position);

        holder.txtTitle.setText(movie.getName());
        holder.txtDesc.setText(movie.getDescription());
    }

    @Override
    public int getItemCount() {
        return movieList != null ? movieList.size() : 0;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle, txtDesc;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.title_txt);
            txtDesc = itemView.findViewById(R.id.desc_txt);
        }
    }
}
