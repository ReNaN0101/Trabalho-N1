package com.example.trabalhoavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class acertouCodigoSecreto extends AppCompatActivity {

    TextView tentativas_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acertou_codigo_secreto);

        tentativas_text = findViewById(R.id.tentativas_num);

        Intent dadosRecebidos = getIntent();
        String tentativas = dadosRecebidos.getStringExtra("tentativas");
        String string = "Tentativas: " + tentativas;
        tentativas_text.setText(string);

    }
}