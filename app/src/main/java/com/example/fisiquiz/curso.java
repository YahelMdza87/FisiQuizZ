package com.example.fisiquiz;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class curso extends AppCompatActivity {
    Button btnAceptaComunidad, btnRegresarComunidad,btnList;
    EditText edtCodigoComunidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);


        btnRegresarComunidad = (Button) findViewById(R.id.btnRegresarComunidad);
        btnList = (Button) findViewById(R.id.btn_List);
        btnAceptaComunidad= (Button) findViewById(R.id.btnAceptarComunidad);


        btnRegresarComunidad.setOnClickListener(new View.OnClickListener() {
            FragmentManager fragmentManager = getSupportFragmentManager();
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), curso.class);
                startActivity(intent);
                finish();
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(curso.this,ListaActivity.class));
                finish();
            }
        });
    }
}