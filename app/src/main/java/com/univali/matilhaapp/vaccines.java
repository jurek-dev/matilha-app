package com.univali.matilhaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class vaccines extends AppCompatActivity {

    private String myText;
    private ArrayList vacNames;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccines);

        Button addVac = (Button) findViewById(R.id.btn_addvac);

        ListView vacList = (ListView) findViewById(R.id.lv_vaccines);

        ArrayList<String> vacNames = new ArrayList<String>();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vacNames);

        vacList.setAdapter(arrayAdapter);

        addVac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentNewdog = new Intent(ourdogs.this, newdog.class);
                //startActivity(intentNewdog);

                AlertDialog.Builder mydialog = new AlertDialog.Builder(vaccines.this);
                mydialog.setTitle("Insira o nome da nova vacina:");

                final EditText vacInput = new EditText(vaccines.this);
                vacInput.setInputType(InputType.TYPE_CLASS_TEXT);
                mydialog.setView(vacInput);

                mydialog.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myText = vacInput.getText().toString();
                        Toast.makeText(vaccines.this, "Nome: " + myText, Toast.LENGTH_LONG).show();
                        vacNames.add(myText);
                        preencherDados();
                    }
                });

                mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(vaccines.this, "Cancelado", Toast.LENGTH_LONG).show();
                    }
                });

                mydialog.show();
            }
        });

        vacList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vacNames.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private ArrayList<String> preencherDados() {
        return vacNames;
    }
}