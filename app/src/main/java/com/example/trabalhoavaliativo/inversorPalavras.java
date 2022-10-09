package com.example.trabalhoavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inversorPalavras extends AppCompatActivity {

    EditText palavra;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversor_palavras);

        palavra = findViewById(R.id.ed01);
        botao = findViewById(R.id.btn01);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!palavra.getText().toString().isEmpty()) {
                    Intent intent = new Intent(inversorPalavras.this, palavraInvertida.class);
                    intent.putExtra("palavra", palavra.getText().toString());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(inversorPalavras.this, "Nenhum texto digitado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}