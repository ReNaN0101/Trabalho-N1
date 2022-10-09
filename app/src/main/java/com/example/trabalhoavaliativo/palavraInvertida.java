package com.example.trabalhoavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class palavraInvertida extends AppCompatActivity {

    TextView palavra_invertida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palavra_invertida);

        palavra_invertida = findViewById(R.id.palavra_invertida);

        Intent dadosRecebidos = getIntent();
        String palavra = dadosRecebidos.getStringExtra("palavra");
        palavra_invertida.setText(new StringBuilder(palavra).reverse().toString());
    }
}