package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NuevoRegistroActivity extends AppCompatActivity {
    private EditText nombre,codigo;
    private Button continuar;
    private  String[] codigos;
    private String codigosregis;
    private boolean codigovalido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);
        nombre = findViewById(R.id.nombretxt);
        codigo = findViewById(R.id.identificacióntxt);
        continuar = findViewById(R.id.continuarbtn);
        SharedPreferences preferences = getSharedPreferences("preferencias", MODE_PRIVATE);
        codigosregis = preferences.getString("codigos","no se encontro/");
        codigos = codigosregis.split("");
        codigovalido = true;


        continuar.setOnClickListener((v) -> {
            //separar los codigos
            codigosregis = preferences.getString("codigos","no se encontro/");
            codigos = codigosregis.split("");
            Intent i = new Intent(this, PreparacionActivity.class);
            if (nombre.getText().toString().equals("") ||
                    codigo.getText().toString().equals("")) {
                Toast.makeText(this, "Ponga su nombre y código para continuar", Toast.LENGTH_SHORT).show();
            }
            else {
                //validar los codigos
            for(int j = 0; j< codigos.length;j++){
                Log.e("codigo",codigos[j]+j);
                Log.e("texto",codigo.getText().toString());
                if(codigos[j].equals(codigo.getText().toString())){
                    codigovalido = false;
                }
                Log.e("boolean prueba", ""+codigovalido);
            }
             if(codigovalido==true){
                preferences.edit().putString("nombre", nombre.getText().toString()).apply();
               codigosregis = codigosregis + "\n" + codigo.getText().toString();
                preferences.edit().putString("codigos",codigosregis).apply();
                startActivity(i);
                finish();
            }
            else{Toast.makeText(this, "No puede repetir codigo", Toast.LENGTH_SHORT).show();}
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("preferencias", MODE_PRIVATE);
        codigosregis = preferences.getString("codigos","no se encontro");
        codigos = codigosregis.split(" ");
        codigovalido = true;

    }
}