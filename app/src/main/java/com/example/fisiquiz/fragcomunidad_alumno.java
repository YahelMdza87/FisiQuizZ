package com.example.fisiquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class fragcomunidad_alumno extends Fragment {
    View vista;
    Button btnComunidad_alumno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_fragcomunidad_alumno, container, false);
        btnComunidad_alumno = (Button) vista.findViewById(R.id.btn_ini_comunidad_alumno);

        btnComunidad_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),
                        curso.class);
                getActivity().startActivity(i);
            }
        });

        return vista;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}