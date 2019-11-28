package com.example.fisiquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class fragcontrarreloj extends Fragment {
    private static final int REQUEST_CODE_CONTRARRELOJ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private TextView txtvMaxAcertadas;

    private int Maxacertadas;
    Button btnini,btncrear;
    View vista;
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container,Bundle savedInstanceState) {
        vista=inflater.inflate(R.layout.fragment_fragcontrarreloj, container,
                false);

        txtvMaxAcertadas = (TextView) vista.findViewById(R.id.txtv_max_acertadas);
        cargarRecord();
        btnini = (Button) vista.findViewById(R.id.btn_ini);
        btncrear = (Button) vista.findViewById(R.id.btn_crear_examen);
        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),
                        Crear_Examenes.class);
                getActivity().startActivity(i);
            }
        });
        btnini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarContrarreloj();

            }
        });
        return vista;
    }
    private void iniciarContrarreloj(){
        Intent i = new Intent(getActivity(),
                ContrarrelojActivity.class);
        getActivity().startActivityForResult(i, REQUEST_CODE_CONTRARRELOJ);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CONTRARRELOJ) {
            if (resultCode == Activity.RESULT_OK) {
                int acertadas = data.getIntExtra(ContrarrelojActivity.EXTRA_SCORE, 0);
                System.out.println("----------------------------------------"+acertadas);
                if (acertadas > Maxacertadas) {
                    actualizarRecord(acertadas);
                }
            }

        }

    }

    private void cargarRecord() {
        SharedPreferences prefs = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        Maxacertadas = prefs.getInt(KEY_HIGHSCORE, 0);
        txtvMaxAcertadas.setText("Puntuaje mas alto: " + Maxacertadas);
        System.out.println("------------------"+Maxacertadas);
    }
    private void actualizarRecord(int acertadas) {
        Maxacertadas = acertadas;
        txtvMaxAcertadas.setText("Puntuaje mas alto: " + Maxacertadas);

        SharedPreferences prefs = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, Maxacertadas);
        editor.apply();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

