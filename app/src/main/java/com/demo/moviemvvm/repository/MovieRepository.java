package com.demo.moviemvvm.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.demo.moviemvvm.database.DatabaseClient;
import com.demo.moviemvvm.database.dao.MovieDao;
import com.demo.moviemvvm.model.Movie;

import java.util.List;

public class MovieRepository {

    private MovieDao movieDao;
    private LiveData<List<Movie>> allMovie;

    public MovieRepository(Application application) {
        DatabaseClient client = DatabaseClient.getInstance(application);

        movieDao = client.movieDao();
        allMovie = movieDao.getAllMovie();
    }

    public void insertMovie(Movie movie) {
        new InsertMovieAsyncTask(movieDao).execute(movie);
    }

    public void updateMovie(Movie movie) {
        new UpdateMovieAsyncTask(movieDao).execute(movie);
    }

    public void deleteMovie(Movie movie) {
        new DeleteMovieAsyncTask(movieDao).execute(movie);
    }

    public void deleteAllMovie() {
        new DeleteAllMovieAsyncTask(movieDao).execute();
    }

    public LiveData<List<Movie>> getAllMovie() {
        return allMovie;
    }

    private static class InsertMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDao movieDao;

        private InsertMovieAsyncTask(MovieDao MovieDao) {
            this.movieDao = MovieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.insertMovie(movies[0]);
            return null;
        }
    }

    private static class UpdateMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDao movieDao;

        private UpdateMovieAsyncTask(MovieDao MovieDao) {
            this.movieDao = MovieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.updateMovie(movies[0]);
            return null;
        }
    }

    private static class DeleteMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDao movieDao;

        private DeleteMovieAsyncTask(MovieDao MovieDao) {
            this.movieDao = MovieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.deleteMovie(movies[0]);
            return null;
        }
    }

    private static class DeleteAllMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDao movieDao;

        private DeleteAllMovieAsyncTask(MovieDao MovieDao) {
            this.movieDao = MovieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.deleteAllMovie();
            return null;
        }
    }
}
