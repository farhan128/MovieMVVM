package com.demo.moviemvvm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.demo.moviemvvm.R;
import com.demo.moviemvvm.databinding.ActivityTambahDataBinding;
import com.demo.moviemvvm.utils.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class TambahDataActivity extends AppCompatActivity {

    private ActivityTambahDataBinding binding;

    private MaterialButton materialButton;
    private TextInputEditText txtTitle, txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTambahDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
    }

    private void initViews() {
        txtDesc = binding.txtEditDeskripsi;
        txtTitle = binding.txtEditJudul;
        materialButton = binding.btnSimpan;


        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = txtTitle.getText().toString();
                String desc = txtDesc.getText().toString();

                if (judul.trim().isEmpty() || desc.trim().isEmpty()) {
                    Toast.makeText(TambahDataActivity.this, "Judul atau Deskripsi tidak boleh Kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent();
                i.putExtra(Constants.TITLE, judul);
                i.putExtra(Constants.DESC, desc);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
    }
}