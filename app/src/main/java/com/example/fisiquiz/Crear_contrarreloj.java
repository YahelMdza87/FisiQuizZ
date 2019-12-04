package com.example.fisiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Crear_contrarreloj extends AppCompatActivity {
    EditText etx_pregunta,etx_opcion1,etx_opcion2,etx_opcion3,etx_respuestaCorrecta,etx_cantidadTiempo;
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
        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), curso.class);
                startActivity(i);
                finish();
            }
        });
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total++;
                checarDatos();

            }
        });
    }
    public void checarDatos(){
        final String pregunta=etx_pregunta.getText().toString();
        final String opcion1=etx_opcion1.getText().toString();
        final String opcion2=etx_opcion2.getText().toString();
        final String opcion3=etx_opcion3.getText().toString();
        final String cantidadTiempo=etx_cantidadTiempo.getText().toString();
        final String respuestaCorrecta=etx_respuestaCorrecta.getText().toString();
        if (TextUtils.isEmpty(pregunta)){
            etx_pregunta.setError("Error, no se puede dejar vacio");
        }
        else if (TextUtils.isEmpty(opcion1)){
            etx_opcion1.setError("Error, no se puede dejar vacio");
        }
        else if (TextUtils.isEmpty(opcion2)){
            etx_opcion2.setError("Error, no se puede dejar vacio");
        }
        else if (TextUtils.isEmpty(opcion3)){
            etx_opcion3.setError("Error, no se puede dejar vacio");
        }
        else if (TextUtils.isEmpty(cantidadTiempo)){
            etx_cantidadTiempo.setError("Error, no se puede dejar vacio");
        }
        else if (TextUtils.isEmpty(respuestaCorrecta)){
            etx_respuestaCorrecta.setError("Error, no se puede dejar vacio");
        }
        else {
            agregarDatos();
        }

    }
    public void agregarDatos(){
        final String pregunta=etx_pregunta.getText().toString();
        final String opcion1=etx_opcion1.getText().toString();
        final String opcion2=etx_opcion2.getText().toString();
        final String opcion3=etx_opcion3.getText().toString();
        final String cantidadTiempo=etx_cantidadTiempo.getText().toString();
        final String respuestaCorrecta=etx_respuestaCorrecta.getText().toString();
//        String id = Crear_contrarreloj.push().getKey();
//        Crear_contrarreloj Examen = new Crear_contrarreloj(id,pregunta,opcion1,opcion2,opcion3,cantidadTiempo,respuestaCorrecta);
//        Crear_contrarreloj.child("Examen").child(id).setValue(Examen);
        //Esto es para cuando se agregue correctamente
        Toast.makeText(Crear_contrarreloj.this, "Se ha agregado correctamente", Toast.LENGTH_SHORT).show();
        limpiar();

    }
    public void limpiar(){
        etx_pregunta.setText("");
        etx_opcion1.setText("");
        etx_opcion2.setText("");
        etx_opcion3.setText("");
        etx_cantidadTiempo.setText("");
        etx_respuestaCorrecta.setText("");
    }

}