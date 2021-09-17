package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView registros;
    private Button registrar;
    private String datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registros = findViewById(R.id.contenidostxt);
        registrar = findViewById(R.id.regisbtn);
        SharedPreferences preferences = getSharedPreferences ("preferencias",MODE_PRIVATE);
        //String datos = preferences.getString("registro", "no hay registros");
        registros.setText(datos);

        registrar.setOnClickListener(
                (v)->{

                    Intent i = new Intent(this, NuevoRegistroActivity.class);
                    startActivity(i);

    });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences ("preferencias",MODE_PRIVATE);
        String datos = preferences.getString("registro", "no hay registros");
        registros.setText(datos);

    }
}