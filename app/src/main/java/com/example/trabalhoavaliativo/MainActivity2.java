package com.example.trabalhoavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btn01,btn02,btn03,btn04;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);
        btn04 = findViewById(R.id.btn04);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,inversorPalavras.class);
                startActivity(intent);


            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,pedraPapel.class);
                startActivity(intent);


            }
        });
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,codigoSecreto.class);
                startActivity(intent);


            }
        });
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,randomizador.class);
                startActivity(intent);


            }
        });





    }
}