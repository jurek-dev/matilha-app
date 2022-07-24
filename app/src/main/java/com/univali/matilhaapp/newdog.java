package com.univali.matilhaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class newdog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdog);

        Button btnCancel = (Button) findViewById(R.id.btn_cancel);
        Button btnConfirm = (Button) findViewById(R.id.btn_confirm);
        TextInputEditText dogname = (TextInputEditText) findViewById(R.id.inptext_dogname);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOurDogs = new Intent(newdog.this, ourdogs.class);
                startActivity(intentOurDogs);
                finish();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = dogname.getText().toString();

                //Intent intentEnviadora = new Intent(getApplicationContext().toString());
                Intent intentOurDogs = new Intent(newdog.this, ourdogs.class);

                Bundle parametros = new Bundle();
                parametros.putString("chave_nome", nome);

                intentOurDogs.putExtras(parametros);
                //startActivity(intentEnviadora);

                // FALTOU ARRUMAR A NAVEGAÇÃO DE DADOS ENTRE AS ACTIVITIES, ERRO NO DEBUG

                //Toast.makeText(newdog.this, "Você adicionou um novo membro!", Toast.LENGTH_SHORT).show();
                //Intent intentOurDogs = new Intent(newdog.this, ourdogs.class);
                startActivity(intentOurDogs);
                finish();
            }
        });
    }
}