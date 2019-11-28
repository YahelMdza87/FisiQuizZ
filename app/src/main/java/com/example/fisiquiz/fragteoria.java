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


public class fragteoria extends Fragment {
    Button btn_tmcu,btn_tmcua,btn_tsegundaley,btn_tleyesgravedad;
    View vista;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_fragteoria, container, false);
        btn_tmcu = (Button) vista.findViewById(R.id.btn_tmcu);
        btn_tmcua = (Button) vista.findViewById(R.id.btn_tmcua);
        btn_tsegundaley = (Button) vista.findViewById(R.id.btn_tsegundaL);
        btn_tleyesgravedad = (Button) vista.findViewById(R.id.btn_tleyesgravedad);
        btn_tmcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Tmcu.class);
                getActivity().startActivity(i);
            }
        });
        btn_tmcua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Tmcua.class);
                getActivity().startActivity(i);
            }
        });
        btn_tsegundaley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Tsegundaley.class);
                getActivity().startActivity(i);
            }
        });
        btn_tleyesgravedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Tleyesgravedad.class);
                getActivity().startActivity(i);
            }
        });
        return vista;
    }

    }

