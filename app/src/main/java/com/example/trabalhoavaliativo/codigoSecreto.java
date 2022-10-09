package com.example.trabalhoavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class codigoSecreto extends AppCompatActivity {

    EditText[] numbersArray;

    TextView[] positionsArray;

    Button button;

    ListView tentativas;

    int numTentativas = 1;

    Random random = new Random();
    int[] numeros = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_secreto);

        numbersArray = new EditText[]{
                (EditText) findViewById(R.id.num1),
                (EditText) findViewById(R.id.num2),
                (EditText) findViewById(R.id.num3),
                (EditText) findViewById(R.id.num4)
        };

        positionsArray = new TextView[]{
                (TextView) findViewById(R.id.txtnum1),
                (TextView) findViewById(R.id.txtnum2),
                (TextView) findViewById(R.id.txtnum3),
                (TextView) findViewById(R.id.txtnum4)
        };

        button = findViewById(R.id.sendButton);

        tentativas = findViewById(R.id.tentativas);

        ArrayList<String> lista = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);

        for (int i = 0; i < 4; i++) {
            codigoSecreto.this.numeros[i] = codigoSecreto.this.random.nextInt(10);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean notEmpty = true;

                for (EditText editText : numbersArray) {
                    if (editText.getText().toString().isEmpty()) {
                        notEmpty = false;
                    }
                }

                String string_tentativa = "Tentativa " + codigoSecreto.this.numTentativas + ": ";

                if (notEmpty) {
                    boolean ganhouJogo = true;

                    for (int i = 0; i < 4; i++) {
                        if (!Objects.equals(numeros[i], Integer.parseInt(numbersArray[i].getText().toString()))) {
                            ganhouJogo = false;
                        }
                    }

                    if (ganhouJogo) {
                        Intent intent = new Intent(codigoSecreto.this, acertouCodigoSecreto.class);
                        intent.putExtra("tentativas", String.valueOf(codigoSecreto.this.numTentativas));
                        startActivity(intent);
                        finish();
                    }

                    for (int i = 0; i < 4; i++) {
                        String position = "errado";

                        if (codigoSecreto.this.containInArray(numeros, numbersArray[i].getText().toString())) {
                            position = "posicao_errada";
                        }

                        if (Objects.equals(numeros[i], Integer.parseInt(numbersArray[i].getText().toString()))) {
                            position = "certo";
                        }


                        switch (position) {
                            case "errado": {
                                positionsArray[i].setText(R.string.errado);
                                break;
                            }
                            case "posicao_errada": {
                                positionsArray[i].setText(R.string.posicao_errada);
                                break;
                            }
                            case "certo": {
                                positionsArray[i].setText(R.string.certo);
                                break;
                            }
                        }

                        string_tentativa = string_tentativa.concat(numbersArray[i].getText().toString());
                        numbersArray[i].setText("");
                    }

                    lista.add(0, string_tentativa);
                    tentativas.setAdapter(adapter);
                    codigoSecreto.this.numTentativas++;

                } else {
                    Toast.makeText(codigoSecreto.this, "Você precisa digitar todos os números!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean containInArray(int[] array, String needle) {

        int number = Integer.parseInt(needle);

        for (int j : array) {
            if (j == number) {
                return true;
            }
        }

        return false;
    }
}