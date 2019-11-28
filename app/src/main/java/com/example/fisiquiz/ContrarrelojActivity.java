package com.example.fisiquiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fisiquiz.Pregunta.*;

import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class ContrarrelojActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "extraScore";
    private static long CRONOMETRO_IN_MILLIS;
    private TextView txtv_pregunta;
    private TextView txtv_acertadas;
    private TextView txtv_cant_preguntas;
    private TextView txtv_cronometro;
    private RadioGroup radio_group;
    private RadioButton rad_btn1;
    private RadioButton rad_btn2;
    private RadioButton rad_btn3;
    private Button btn_siguiente,btn_menu;
    private ColorStateList Colortextorb;
    private ColorStateList Colortextcrono;


    private CountDownTimer Cronometro;
    private long tiempoRestanteInMillis;

    private List<Pregunta> ListaPreguntas;
    private int Preguntaconta;
    private int Preguntacontatot;
    private Pregunta Preguntanum;

    private int acertadas;
    private boolean respuesta;
    private long btnatras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrarreloj);
        btn_menu = (Button) findViewById(R.id.btn_menu);
        txtv_pregunta = findViewById(R.id.txtv_pregunta);
        txtv_acertadas = findViewById(R.id.txtv_acertadas);
        txtv_cant_preguntas = findViewById(R.id.txtv_cant_preguntas);
        txtv_cronometro = findViewById(R.id.txtv_cronometro);
        radio_group = findViewById(R.id.radio_group);
        rad_btn1 = findViewById(R.id.rad_btn1);
        rad_btn2 = findViewById(R.id.rad_btn2);
        rad_btn3 = findViewById(R.id.rad_btn3);
        btn_siguiente = findViewById(R.id.btn_siguiente);
        Colortextorb = rad_btn1.getTextColors();
        Colortextcrono = txtv_cronometro.getTextColors();
        ContrarrelojDbHelper dbHelper = new ContrarrelojDbHelper(this);
        ListaPreguntas = dbHelper.getAllPreguntas();
        Preguntacontatot = ListaPreguntas.size();
        Collections.shuffle(ListaPreguntas);
        mostrarSigPregunta();
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), fragquiz.class);
                startActivity(i);
            }
        });


        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!respuesta){
                    if (rad_btn1.isChecked() || rad_btn2.isChecked() || rad_btn3.isChecked() ){
                        checarRespuesta();
                    }
                    else {
                        Toast.makeText(ContrarrelojActivity.this, "Porfavor, seleccione una respuesta", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    mostrarSigPregunta();
                }

            }
        });
    }
    private void mostrarSigPregunta(){
        rad_btn1.setTextColor(Colortextorb);
        rad_btn2.setTextColor(Colortextorb);
        rad_btn3.setTextColor(Colortextorb);
        radio_group.clearCheck();
        if (Preguntaconta < Preguntacontatot){
            Preguntanum = ListaPreguntas.get(Preguntaconta);
            txtv_pregunta.setText(Preguntanum.getPregunta());
            rad_btn1.setText(Preguntanum.getOpcion1());
            rad_btn2.setText(Preguntanum.getOpcion2());
            rad_btn3.setText(Preguntanum.getOpcion3());
            CRONOMETRO_IN_MILLIS=Preguntanum.getCantidad_Tiempo();
            Preguntaconta++;
            txtv_cant_preguntas.setText("Pregunta: " + Preguntaconta + "/" + Preguntacontatot);
            respuesta = false;
            btn_siguiente.setText("Confirmar");
            tiempoRestanteInMillis = CRONOMETRO_IN_MILLIS;
            inicarCronometro();
        } else {
            finalizarContrarreloj();
        }
    }
    private void inicarCronometro(){
        Cronometro = new CountDownTimer(tiempoRestanteInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempoRestanteInMillis = millisUntilFinished;
                actualizarTxtCronometro();
            }

            @Override
            public void onFinish() {
                tiempoRestanteInMillis = 0;
                actualizarTxtCronometro();
                checarRespuesta();

            }
        }.start();
    }
    private void actualizarTxtCronometro(){
        int minutos = (int) (tiempoRestanteInMillis / 1000)/60;
        int segundos = (int) (tiempoRestanteInMillis / 1000) % 60;
        String formatoTiempo = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);
        txtv_cronometro.setText(formatoTiempo);
        if (tiempoRestanteInMillis <10000){
            txtv_cronometro.setTextColor(Color.RED);
        }
        else {
            txtv_cronometro.setTextColor(Colortextcrono);
        }
    }
    private void checarRespuesta() {
        respuesta = true;
        Cronometro.cancel();
        RadioButton rbseleccionado = findViewById(radio_group.getCheckedRadioButtonId());
        int respuestaNum = radio_group.indexOfChild(rbseleccionado) + 1;

        if (respuestaNum == Preguntanum.getNum_aciertos()) {
            acertadas++;
            txtv_acertadas.setText("Acertadas: " + acertadas);
        }

        mostrarLaRespuesta();
    }

    private void mostrarLaRespuesta() {
        rad_btn1.setTextColor(Color.RED);
        rad_btn2.setTextColor(Color.RED);
        rad_btn3.setTextColor(Color.RED);

        switch (Preguntanum.getNum_aciertos()) {
            case 1:
                rad_btn1.setTextColor(Color.GREEN);
                txtv_pregunta.setText("El inciso 1 esta correcto");
                break;
            case 2:
                rad_btn2.setTextColor(Color.GREEN);
                txtv_pregunta.setText("El inciso 2 esta correcto");
                break;
            case 3:
                rad_btn3.setTextColor(Color.GREEN);
                txtv_pregunta.setText("El inciso 3 esta correcto");
                break;
        }

        if (Preguntaconta < Preguntacontatot) {
            btn_siguiente.setText("Siguiente");
        } else {
            btn_siguiente.setText("Finalizar");
        }
    }

    private void finalizarContrarreloj() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, acertadas);
        setResult(RESULT_OK, resultIntent);
        finish();

    }
    public void onBackPressed() {
        if (btnatras + 2000 > System.currentTimeMillis()) {
            finalizarContrarreloj();
        } else {
            Toast.makeText(this, "Presiona otra vez para finalizar", Toast.LENGTH_SHORT).show();
        }

        btnatras = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Cronometro !=null){
            Cronometro.cancel();
        }
    }
}