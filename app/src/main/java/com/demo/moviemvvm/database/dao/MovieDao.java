package com.demo.moviemvvm.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.demo.moviemvvm.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void insertMovie(Movie movie);

    @Update
    void updateMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);

    @Query("DELETE FROM tbl_movie")
    void deleteAllMovie();

    @Query("SELECT * FROM tbl_movie ORDER BY id DESC")
    LiveData<List<Movie>> getAllMovie();
}
