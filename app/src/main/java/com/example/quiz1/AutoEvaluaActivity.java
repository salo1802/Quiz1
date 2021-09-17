package com.example.quiz1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AutoEvaluaActivity extends AppCompatActivity {
    private int num;
    private CheckBox op1,op2,op3;
    private Button continuar;
    private String nombre, registro;
    private String datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);
        SharedPreferences preferences = getSharedPreferences ("preferencias",MODE_PRIVATE);
        continuar = findViewById(R.id.continuarbtn3);
        op1 = findViewById(R.id.opcA1);
        op2 = findViewById(R.id.opcA2);
        op3 = findViewById(R.id.opcA3);
        num = preferences.getInt("num",0);
        nombre = preferences.getString("nombre","N/A");
       datos = preferences.getString("registro", "");
        continuar.setOnClickListener((v)->{
            num = preferences.getInt("num",0);
            nombre = preferences.getString("nombre","N/A");
            datos = preferences.getString("registro", "");
            Intent i = new Intent(this, MainActivity.class);
            if(op1.isChecked()==false&&op2.isChecked()==false&&op3.isChecked()==false){
                Toast.makeText(this, "Seleccione al menos una opcón", Toast.LENGTH_SHORT).show();
            }
            else{
                if(op3.isChecked()==true){
                    if(op1.isChecked()==true||op2.isChecked()==true){
                        Toast.makeText(this, "Sí selecciona no comprendi los temas" +
                                " no seleccione ninguna otra opción", Toast.LENGTH_SHORT).show();
                    }else{
                            registro = datos + "\n" + nombre + num;
                        Log.e("si esta bien el dato",registro);
                        preferences.edit().putString("registro",registro).apply();
                        startActivity(i);
                    finish();} }
                else{
                    if(op1.isChecked()==true){
                        num += 3;}
                    if(op2.isChecked()==true){
                        num += 3;}
                    registro = datos + "\n" + nombre + num;
                    Log.e("si esta bien el dato",registro);
                    preferences.edit().putString("registro",registro).apply();
                 startActivity(i);
                finish();}

            }
        });
    }

}
