package com.example.trabalhoavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class pedraPapel extends AppCompatActivity {

    ImageView escolhaCPU;
    ImageButton pedra;
    ImageButton tesoura;
    ImageButton papel;
    TextView resultado;
    Random random = new Random();
    String[] escolhas = new String[]{
            "pedra",
            "papel",
            "tesoura"
    };

    int[] imagens = {
            R.drawable.pedra,
            R.drawable.papel,
            R.drawable.tesoura,
    };

    boolean escolha_feita = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedra_papel);

        escolhaCPU = findViewById(R.id.escolhaCpu);
        pedra = findViewById(R.id.pedra);
        papel = findViewById(R.id.papel);
        tesoura = findViewById(R.id.tesoura);
        resultado = findViewById(R.id.txt02);

        int index_escolha = random.nextInt(3);

        pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pedraPapel.this.escolha_feita) {
                    escolhaCPU.setImageResource(imagens[index_escolha]);
                    resultado.setText(pedraPapel.this.resultado("pedra", escolhas[index_escolha]));
                    pedraPapel.this.escolha_feita = true;
                }
            }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pedraPapel.this.escolha_feita) {
                    escolhaCPU.setImageResource(imagens[index_escolha]);
                    resultado.setText(pedraPapel.this.resultado("papel", escolhas[index_escolha]));
                    pedraPapel.this.escolha_feita = true;
                }
            }
        });

        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pedraPapel.this.escolha_feita) {
                    escolhaCPU.setImageResource(imagens[index_escolha]);
                    resultado.setText(pedraPapel.this.resultado("tesoura", escolhas[index_escolha]));
                    pedraPapel.this.escolha_feita = true;
                }
            }
        });
    }

    public String resultado(String jogador, String cpu) {
        String resultado = "";

        if (Objects.equals(jogador, cpu)) {
            return "Empatou :|";
        }

        switch (jogador) {
            case "pedra": {
                if (Objects.equals(cpu, "papel")) {
                    resultado = "Você perdeu :(";
                } else if (Objects.equals(cpu, "tesoura")) {
                    resultado = "Você ganhou :)";
                }
            }
            break;
            case "papel": {
                if (Objects.equals(cpu, "tesoura")) {
                    resultado = "Você perdeu :(";
                } else if (Objects.equals(cpu, "pedra")) {
                    resultado = "Você ganhou :)";
                }
            }
            case "tesoura": {
                if (Objects.equals(cpu, "pedra")) {
                    resultado = "Você perdeu :(";
                } else if (Objects.equals(cpu, "papel")) {
                    resultado = "Você ganhou :)";
                }
            }
            break;
        }

        return resultado;
    }
}