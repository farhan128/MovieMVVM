package com.demo.moviemvvm.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.demo.moviemvvm.model.Movie;
import com.demo.moviemvvm.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;
    private LiveData<List<Movie>> allMovie;

    public MovieViewModel(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);
        allMovie = movieRepository.getAllMovie();
    }

    public void insertMovie(Movie movie) {
        movieRepository.insertMovie(movie);
    }

    public void updateMovie(Movie movie) {
        movieRepository.updateMovie(movie);
    }

    public void deleteMovie(Movie movie) {
        movieRepository.deleteMovie(movie);
    }

    public void deleteALlMovie() {
        movieRepository.deleteAllMovie();
    }

    public LiveData<List<Movie>> getAllMovie() {
        return allMovie;
    }
}
