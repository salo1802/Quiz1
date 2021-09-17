package com.example.quiz1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PreparacionActivity extends AppCompatActivity {
    private int num;
    private CheckBox op1,op2,op3;
    private Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        continuar = findViewById(R.id.continuarbtn2);
        num = 0;
        op1 = findViewById(R.id.opc1);
        op2 = findViewById(R.id.opc2);
        op3 = findViewById(R.id.opc3);
        SharedPreferences preferences = getSharedPreferences ("preferencias",MODE_PRIVATE);

        continuar.setOnClickListener((v)->{
            Intent i = new Intent(this, AutoEvaluaActivity.class);
            if(op1.isChecked()==false&&op2.isChecked()==false&&op3.isChecked()==false){
                Toast.makeText(this, "Seleccione al menos una opcón", Toast.LENGTH_SHORT).show();
            }
            else{
                if(op3.isChecked()==true){
                    if(op1.isChecked()==true||op2.isChecked()==true){
                        Toast.makeText(this, "Sí selecciona ninguna de las anteriores" +
                                " no seleccione ninguna otra opción", Toast.LENGTH_SHORT).show();
                    }else{
                        preferences.edit().putInt("num",num).apply();
                        startActivity(i);
                        finish();
                    }}
                    else{
                        if(op1.isChecked()==true){
                            num += 1;}
                        if(op2.isChecked()==true){
                            num += 3;}
                        preferences.edit().putInt("num",num).apply();
                        startActivity(i);
                    finish();}

            }
        });
    }
}
