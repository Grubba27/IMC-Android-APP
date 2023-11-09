package com.example.imcatp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.calcular_btn);

        final EditText peso = findViewById(R.id.peso);
        final EditText altura = findViewById(R.id.altura);

        final TextView imcTxtView = findViewById(R.id.imc_result);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String kg = peso.getText().toString();
                if (kg.equals("")) {
                    Toast
                            .makeText(MainActivity.this, "Preencha o campo de peso", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                String metros = altura.getText().toString();
                if (metros.equals("")) {
                    Toast
                            .makeText(MainActivity.this, "Preencha o campo de altura", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                Toast
                        .makeText(MainActivity.this, "Calculando...", Toast.LENGTH_SHORT)
                        .show();

                CalculaIMC imc = new CalculaIMC(Double.parseDouble(metros), Double.parseDouble(kg));
                Locale localeBR = new Locale("pt", "BR");
                String resultado = String.format(localeBR,
                        "Seu IMC é: %2.2f, você é classificado como: %s",
                        imc.getIMC(), imc.getClassificacao());
                imcTxtView.setText(resultado);
            }
        });
    }
}