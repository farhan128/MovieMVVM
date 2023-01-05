package com.demo.moviemvvm.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.demo.moviemvvm.R;
import com.demo.moviemvvm.adapter.MovieAdapter;
import com.demo.moviemvvm.databinding.ActivityMainBinding;
import com.demo.moviemvvm.model.Movie;
import com.demo.moviemvvm.utils.Constants;
import com.demo.moviemvvm.viewModel.MovieViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    private static final int ADD_MOVIE_ID = 101;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FloatingActionButton actionButton;

    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(TAG, "onCreate()");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
    }

    private void initViews() {
        toolbar = binding.toolbar;
        recyclerView = binding.include.recyclerView;
        actionButton = binding.fab;

        initRecyclerView();

        setSupportActionBar(toolbar);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final MovieAdapter adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getAllMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.setMovieList(movies);
            }
        });
        
        handleListener();
    }

    private void handleListener() {
        actionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == actionButton) {
            Intent i = new Intent(MainActivity.this, TambahDataActivity.class);
            startActivityForResult(i, ADD_MOVIE_ID);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_MOVIE_ID && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String title = data.getStringExtra(Constants.TITLE);
                String desc = data.getStringExtra(Constants.DESC);

                movieViewModel.insertMovie(new Movie(title, desc, R.drawable.ic_banner, "19-10-1999"));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_delete_all_movies) {
            movieViewModel.deleteALlMovie();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        Log.v(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v(TAG,"onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v(TAG,"onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG,"onDestroy()");
        super.onDestroy();
    }
}