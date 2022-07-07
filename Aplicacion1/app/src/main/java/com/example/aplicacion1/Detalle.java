package com.example.aplicacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aplicacion1.databinding.ActivityDetalle2Binding;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetalle2Binding binding=ActivityDetalle2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras=getIntent().getExtras();
        binding.txtUsu.setText(extras.getString("usuario"));

    }
}