package com.example.fisiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class Crear_Quiz extends AppCompatActivity {
    EditText etx_pregunta_quiz,etx_respuesta_quiz;
    Button btn_agregar_pregunta_quiz, btn_finalizar_quiz;
    private DatabaseReference mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__quiz);
        etx_pregunta_quiz = (EditText) findViewById(R.id.etx_pregunta_quiz);
        etx_respuesta_quiz = (EditText) findViewById(R.id.etx_respuesta_crear_quiz);
        btn_agregar_pregunta_quiz =(Button) findViewById(R.id.btn_agregar_pregunta_quiz);
        btn_finalizar_quiz = (Button) findViewById(R.id.btn_finalizar_quiz);
        btn_agregar_pregunta_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checarDatos();
            }
        });
    }
    public void checarDatos(){
        final String Pregunta = etx_pregunta_quiz.getText().toString();
        final String Respuesta = etx_respuesta_quiz.getText().toString();
        if (TextUtils.isEmpty(Pregunta)){
            etx_pregunta_quiz.setError("Error, no se puede dejar vacio");
        }
        else if (TextUtils.isEmpty(Respuesta)){
            etx_respuesta_quiz.setError("Error, no se puede dejar vacio");
        }
        else {
            agregarQuiz();
        }
    }
    public void agregarQuiz(){
        final String Pregunta = etx_pregunta_quiz.getText().toString();
        final String Respuesta = etx_respuesta_quiz.getText().toString();
        Map<String, Object> map=new HashMap<>();
        map.put("pregunta",Pregunta);
        map.put("respuesta",Respuesta);

        mUser.child("Quiz").setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task2) {
                if (task2.isSuccessful()){
                    //Esto es para cuando se agregue correctamente
                    Toast.makeText(Crear_Quiz.this, "Se ha agregado correctamente", Toast.LENGTH_SHORT).show();
                    limpiar();
                }
                else{
                    Toast.makeText(Crear_Quiz.this, "Llene los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public void limpiar(){
        etx_pregunta_quiz.setText("");
        etx_respuesta_quiz.setText("");
    }
}