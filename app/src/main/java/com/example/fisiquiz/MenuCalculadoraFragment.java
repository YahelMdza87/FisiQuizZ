package com.example.fisiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuCalculadoraFragment extends Fragment {
    View vista;
    Button btnPlanoInclinado,btnMCU,btnSegLeyFR,btnSegLeySFR,btnLeyesgravedad;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_menu_calculadora, container, false);
        btnPlanoInclinado = (Button) vista.findViewById(R.id.btn_menu_PlanoInclinado);
        btnMCU = (Button) vista.findViewById(R.id.btn_menu_MCU);
        btnSegLeyFR = (Button) vista.findViewById(R.id.btn_menu_SegleyFR);
        btnSegLeySFR = (Button) vista.findViewById(R.id.btn_menu_SegleyNoFR);
        btnLeyesgravedad = (Button) vista.findViewById(R.id.btn_menu_LeyesGravedad);

        btnMCU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MCU.class);
                getActivity().startActivity(i);
            }
        });

        btnSegLeyFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Friccion.class);
                getActivity().startActivity(i);
            }
        });
        btnSegLeySFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Friccion.class);
                getActivity().startActivity(i);
            }
        });
        btnLeyesgravedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), leygravedad.class);
                getActivity().startActivity(i);
            }
        });
        btnPlanoInclinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PlanoInclinadoActivity.class);
                getActivity().startActivity(i);
            }
        });
        return vista;
    }

}
