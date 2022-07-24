package com.univali.matilhaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ourdogs extends AppCompatActivity {

    private String myText;
    private ArrayList dogNames;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ourdogs);

        Button addDog = (Button) findViewById(R.id.btn_add);

        // List View dos cães
        ListView dogList = (ListView) findViewById(R.id.lv_dogs);

        ArrayList<String> dogNames = new ArrayList<String>(); //hihi

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dogNames);
        dogList.setAdapter(arrayAdapter);

        // Image View para voltar uma página
        ImageView backPage = (ImageView) findViewById(R.id.img_backpage);

        // Função para voltar uma página, chamada na Image View do Arrow Back
        backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(ourdogs.this, MainActivity.class);
                startActivity(intentMain);
            }
        });

        addDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentNewdog = new Intent(ourdogs.this, newdog.class);
                //startActivity(intentNewdog);

                AlertDialog.Builder mydialog = new AlertDialog.Builder(ourdogs.this);
                mydialog.setTitle("Insira o nome do novo cão:");

                final EditText dogInput = new EditText(ourdogs.this);
                dogInput.setInputType(InputType.TYPE_CLASS_TEXT);
                mydialog.setView(dogInput);

                mydialog.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myText = dogInput.getText().toString();
                        Toast.makeText(ourdogs.this, "Nome: " + myText, Toast.LENGTH_LONG).show();
                        dogNames.add(myText);
                        preencherDados();
                    }
                });

                mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ourdogs.this, "Cancelado", Toast.LENGTH_LONG).show();
                    }
                });

                mydialog.show();
            }
        });

        dogList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dogNames.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private ArrayList<String> preencherDados() {
        return dogNames;
    }
}