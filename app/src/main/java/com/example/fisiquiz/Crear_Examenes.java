package com.example.fisiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Crear_Examenes extends AppCompatActivity {
    Button btn_crear_quiz,btn_crear_contrarreloj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__examenes);
        btn_crear_quiz = (Button) findViewById(R.id.btn_crear_quiz);
        btn_crear_contrarreloj = (Button) findViewById(R.id.btn_crear_contrarreloj);
        btn_crear_contrarreloj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Crear_contrarreloj.class);
                startActivity(i);
                finish();
            }
        });

    }
}
