package com.example.trabalhoavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class randomizador extends AppCompatActivity {

    EditText text;
    Button inserir;
    ListView lista;
    Button sortear;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomizador);

        text = findViewById(R.id.ed01);
        inserir = findViewById(R.id.btn01);
        sortear = findViewById(R.id.btn02);
        lista = findViewById(R.id.lista);

        ArrayList<String> items = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);

        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text.getText().toString().isEmpty()) {
                    Toast.makeText(randomizador.this, "O campo de texto está vazio.", Toast.LENGTH_SHORT).show();
                } else {
                    items.add(text.getText().toString());
                    lista.setAdapter(adapter);
                    text.setText("");
                }
            }
        });

        sortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(randomizador.this, adapter.getItem(random.nextInt(adapter.getCount())).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}