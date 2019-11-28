package com.example.fisiquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Crear_contrarreloj extends AppCompatActivity {
    EditText etx_nombreExamen,etx_pregunta,etx_opcion1,etx_opcion2,etx_opcion3,etx_respuestaCorrecta,etx_cantidadTiempo;
    Button btn_agregar,btn_finalizar;
    private int total;
    private List<Pregunta> ListaPreguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_contrarreloj);
        etx_pregunta = (EditText) findViewById(R.id.etx_pregunta_contrarreloj);
        etx_opcion1 = (EditText) findViewById(R.id.etx_opcion_1);
        etx_opcion2 = (EditText) findViewById(R.id.etx_opcion_2);
        etx_opcion3 = (EditText) findViewById(R.id.etx_opcion_3);
        etx_respuestaCorrecta = (EditText) findViewById(R.id.etx_respuesta_correcta);
        etx_cantidadTiempo = (EditText) findViewById(R.id.etx_cantidad_tiempo);
        btn_agregar = (Button) findViewById(R.id.btn_agregar_pregunta);

        final ContrarrelojDbHelper contrarrelojDbHelper = new ContrarrelojDbHelper(getApplicationContext());
        ListaPreguntas = contrarrelojDbHelper.getAllPreguntas();
        total = ListaPreguntas.size();
        btn_finalizar = (Button) findViewById(R.id.btn_finalizar_contrarreloj);


        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total++;
                contrarrelojDbHelper.addPregunta(total,etx_pregunta.getText().toString(),etx_opcion1.getText().toString(),etx_opcion2.getText().toString(),etx_opcion3.getText().toString(),etx_cantidadTiempo.getText().toString(),etx_respuestaCorrecta.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            }
        });
    }

}