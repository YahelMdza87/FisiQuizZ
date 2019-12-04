package com.example.fisiquiz;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class comunidad_profeFragment extends Fragment {
    Button btnLista,btnProblems;
    View vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_comunidad_profe, container, false);
        btnProblems = (Button) vista.findViewById(R.id.btn_problems);
        btnLista = (Button) vista.findViewById(R.id.btn_List);

        btnProblems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),
                        Crear_Quiz.class);
                getActivity().startActivity(i);
            }
        });
      btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),
                        ListaActivity.class);
                getActivity();
                startActivity(i);
            }
        });

        return vista;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}