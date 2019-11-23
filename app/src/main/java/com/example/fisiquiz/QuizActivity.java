package com.example.fisiquiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    public static final String NEW_RECORD = "nuevoRecord";
    private Button btn_siguiente_quiz,btnsalir;
    private TextView txtv_acertadas_quiz, txtv_cant_preguntas_quiz, txtv_pregunta_quiz;
    List<PreguntaQuiz> ListaPreguntasQuiz;
    private EditText etx_respuesta;
    private int numPregunta;
    private int numPreguntaTotal;
    private PreguntaQuiz preguntaQuiz;
    private ColorStateList colorRespuesta;
    private int correctas;
    private boolean bien;
    private boolean respuesta;
    private long btnatras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        btnsalir = (Button) findViewById(R.id.btnsalir);
        btn_siguiente_quiz = (Button) findViewById(R.id.btn_siguiente_quiz);
        txtv_acertadas_quiz = (TextView) findViewById(R.id.txtv_acertadas_quiz);
        txtv_cant_preguntas_quiz = (TextView) findViewById(R.id.txtv_cant_preguntas_quiz);
        txtv_pregunta_quiz = (TextView) findViewById(R.id.txtv_pregunta_quiz);
        etx_respuesta = (EditText) findViewById(R.id.etx_respuesta);
        ContrarrelojDbHelper DbQuiz = new ContrarrelojDbHelper(this);
        colorRespuesta = etx_respuesta.getTextColors();
        ListaPreguntasQuiz = DbQuiz.getAllPreguntasQuiz();
        numPreguntaTotal= ListaPreguntasQuiz.size();
        Collections.shuffle(ListaPreguntasQuiz);


        siguientePregunta();

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), fragquiz.class);
                startActivity(i);
            }
        });

        btn_siguiente_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String respuestaQuiz = etx_respuesta.getText().toString();
                if (!respuesta){
                    if (TextUtils.isEmpty(respuestaQuiz)){
                        etx_respuesta.setError("Error, no se puede dejar vacio");
                    }
                    else {
                        checarRespuestaQuiz();
                    }
                }
                else {
                    siguientePregunta();
                }
            }
        });
    }

    public void siguientePregunta(){
        etx_respuesta.setTextColor(colorRespuesta);
        etx_respuesta.setText("");
        if (numPregunta<numPreguntaTotal){
            preguntaQuiz = ListaPreguntasQuiz.get(numPregunta);
            txtv_pregunta_quiz.setText(preguntaQuiz.getPreguntaquiz());
            numPregunta++;
            txtv_cant_preguntas_quiz.setText(numPregunta+" / "+numPreguntaTotal);
            respuesta=false;
            btn_siguiente_quiz.setText("Confirmar");
        }
        else {
            mandarRecord();
        }
    }
    public void checarRespuestaQuiz(){
        respuesta=true;
        String respuestaQuiz = etx_respuesta.getText().toString();
        final String respuestaCorrecta= preguntaQuiz.getRespuesta();
        if (respuestaQuiz.equals(respuestaCorrecta)){
            bien=true;
            correctas++;
            txtv_acertadas_quiz.setText("Correctas: "+correctas);

        }
        else {
            bien= false;
        }
        mostrarRespuesta();
        System.out.println("-----------------------"+bien);
        System.out.println("---------------------"+respuestaCorrecta+"--------------"+respuestaQuiz);

    }
    public void mostrarRespuesta(){
        etx_respuesta.setTextColor(Color.RED);
        if (bien==true){
            etx_respuesta.setTextColor(Color.GREEN);
            Toast.makeText(this, "Correcta, bien hecho", Toast.LENGTH_SHORT).show();
        }
        else  if (bien==false){
            etx_respuesta.setText(preguntaQuiz.getRespuesta());
            Toast.makeText(this, "Incorrecta, esta es la respuesta", Toast.LENGTH_SHORT).show();
        }
        if (numPregunta<numPreguntaTotal){
            btn_siguiente_quiz.setText("Siguiente");
        }
        else {
            btn_siguiente_quiz.setText("Finalizar");
        }
    }
    public void mandarRecord(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(NEW_RECORD, correctas);
        setResult(RESULT_OK, resultIntent);
        finish();
    }


}
