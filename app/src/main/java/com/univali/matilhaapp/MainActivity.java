package com.univali.matilhaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView univali = (ImageView) findViewById(R.id.img_univali);

        Button ourdogs = (Button) findViewById(R.id.btn_ourdogs);
        Button vaccines = (Button) findViewById(R.id.btn_vaccines);

        univali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://univali.br/")));
            }
        });

        ourdogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOurdogs = new Intent(MainActivity.this, ourdogs.class);
                startActivity(intentOurdogs);
                finish();
            }
        });

        vaccines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaccines = new Intent(MainActivity.this, vaccines.class);
                startActivity(intentVaccines);
                finish();
            }
        });
    }
}