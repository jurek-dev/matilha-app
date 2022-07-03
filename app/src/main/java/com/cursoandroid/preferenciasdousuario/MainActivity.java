package com.cursoandroid.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    /*
     * Declaração de variáveis e constantes
     */
    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textResultado;
    private TextView textForget;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Definição de ID's de componentes da interface
         */
        buttonSalvar = findViewById(R.id.buttonSalvar);
        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.textResultado);
        textForget = findViewById(R.id.textForget);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                /*
                 * Validação e armazenamento do nome do usuário.
                 */
                if( editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_LONG).show();
                }else {
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textResultado.setText("Olá, " + nome);
                }

            }

        });

        textForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                if( preferences.contains("nome") ){
                    editor.putString("nome", "");
                    editor.commit();
                    textResultado.setText("Olá, usuário não definido.");
                }
            }
        });

        // Recuperação de dado salvo em preferências
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        // Validação se há dado salvo em preferências
        if( preferences.contains("nome") ){
            String nome = preferences.getString("nome", "usuário não definido.");
            textResultado.setText("Olá, " + nome);
        }else{
            textResultado.setText("Olá, usuário não definido.");
        }
    }
}