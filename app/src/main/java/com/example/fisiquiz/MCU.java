package com.example.fisiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MCU extends AppCompatActivity {

    EditText et_w, et_desAng, et_tiempo,et_tiempo2,et_novueltas, et_periodo, et_tiempo3, et_frecu, et_novueltas2,et_dis,et_rad,et_teta, et_acel,et_pes,etc_rad2  ;
    Button btnCalcularMCU,btnCalcularTNt,btnCalcularFR, btnCalcularDOR,btnMcuRegresar,btnMcuSig, btnCalcularAcel;
    TextView txvWOT,txvTNt,txvFr, txvDOR,txvAAR;
    RadioButton rd_mins, rd_seg, rd_mins2, rd_seg2,rd_mins3, rd_seg3,rd_m,rd_m1,rd_cm,rd_cm1,rd_m4,rd_cm5,rd_cm4,rd_m5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcu);

        btnCalcularMCU = (Button)findViewById(R.id.btnCalcularWOT);
        btnCalcularTNt = (Button)findViewById(R.id.btnCalcularTNt);
        btnCalcularFR = (Button)findViewById(R.id.btnCalcularFr);
        btnCalcularDOR = (Button)findViewById(R.id.btnCalcularDOR);
        btnCalcularAcel = (Button)findViewById(R.id.btnCalcAcel);
        btnMcuRegresar = (Button)findViewById(R.id.btn_Regresar_Menu_MCU);
        btnMcuSig = (Button)findViewById(R.id.btnMcuSig);
        et_desAng = (EditText) findViewById(R.id.et_desAng);
        et_w = (EditText) findViewById(R.id.et_w);
        et_tiempo = (EditText) findViewById(R.id.et_tiempo);
        et_novueltas = (EditText) findViewById(R.id.et_novueltas);
        et_periodo= (EditText) findViewById(R.id.et_periodo);
        et_tiempo2 = (EditText) findViewById(R.id.et_tiempo2);
        et_tiempo3 = (EditText) findViewById(R.id.et_tiem3);
        et_frecu = (EditText) findViewById(R.id.et_frecuencia);
        et_novueltas2 = (EditText) findViewById(R.id.et_noVuelF);
        et_teta = (EditText) findViewById(R.id.et_teta);
        et_dis = (EditText) findViewById(R.id.et_dis);
        et_rad = (EditText) findViewById(R.id.et_rad);
        et_acel = (EditText) findViewById(R.id.et_acel);
        et_pes = (EditText) findViewById(R.id.et_pescado);
        etc_rad2 = (EditText) findViewById(R.id.et_rad2);
        txvWOT = (TextView)findViewById(R.id.txvWOT);
        txvTNt = (TextView)findViewById(R.id.txvTNt);
        txvFr = (TextView)findViewById(R.id.txvFr);
        txvDOR = (TextView)findViewById(R.id.txvDOR);
        txvAAR = (TextView)findViewById(R.id.txvAAR);
        rd_mins = (RadioButton)findViewById(R.id.rb_mins);
        rd_seg = (RadioButton)findViewById(R.id.rb_seg);
        rd_mins2 = (RadioButton)findViewById(R.id.rb_mins2);
        rd_seg2 = (RadioButton)findViewById(R.id.rb_seg2);
        rd_mins3 = (RadioButton)findViewById(R.id.rb_mins3);
        rd_seg3 = (RadioButton)findViewById(R.id.rb_seg3);
        rd_m = (RadioButton)findViewById(R.id.rb_m);
        rd_cm = (RadioButton)findViewById(R.id.rb_cm);
        rd_m1 = (RadioButton)findViewById(R.id.rb_m1);
        rd_cm1 = (RadioButton)findViewById(R.id.rb_cm1);

        rd_m5 = (RadioButton)findViewById(R.id.rb_m5);
        rd_cm5 = (RadioButton)findViewById(R.id.rb_cm5);


        btnCalcularMCU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sW = et_w.getText().toString();
                String sdesAng = et_desAng.getText().toString();
                String sTiem = et_tiempo.getText().toString();

                String res;

                if(TextUtils.isEmpty(sW)){
                    et_w.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sdesAng)){
                    et_desAng.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sTiem)){
                    et_tiempo.setError("Complete el campo");
                    return;
                }

                double dW = Double.parseDouble(sW);
                double ddesAng = Double.parseDouble(sdesAng);
                double dTiem = Double.parseDouble(sTiem);

                double resul=0.0;
                if (rd_mins.isChecked()==true){
                    dTiem = dTiem*60;
                }


                if (dW==0.0 && ddesAng==0.0 && dTiem==0.0){
                    txvWOT.setText("Tienes que tener minimo dos campos con valores");
                }else if (dW == 0.0 || dW == 0){
                    resul = ddesAng/dTiem;
                    res = "La velocidad angular(W) es igual a: "+ resul + " rad/s";
                    txvWOT.setText(res);
                }else if (ddesAng == 0.0 || ddesAng == 0) {
                    resul = dW * dTiem;
                    res = "El desplazamiento angular(Θ) es igual a: " + resul +" rad" ;
                    txvWOT.setText(res);
                }else if (dTiem == 0.0 || dTiem == 0) {
                    resul = ddesAng / dW;
                    res = "El tiempo(t) es igual: " + resul + " s";
                    txvWOT.setText(res);
                }

            }
        });

        btnCalcularTNt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sP = et_periodo.getText().toString();
                String sT2 = et_tiempo2.getText().toString();
                String sNV = et_novueltas.getText().toString();

                String res;

                if(TextUtils.isEmpty(sP)){
                    et_periodo.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sT2)){
                    et_tiempo2.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sNV)){
                    et_novueltas.setError("Complete el campo");
                    return;
                }

                double dP = Double.parseDouble(sP);
                double dT2 = Double.parseDouble(sT2);
                double dNV = Double.parseDouble(sNV);

                double resul = 0.0;

                if (rd_mins2.isChecked()==true){
                    dT2 = dT2*60;
                }

                if (dP==0.0 && dNV==0.0 && dT2==0.0) {
                    txvTNt.setText("Tienes que tener minimo dos campos con valores");
                }else if (dP==0 || dP==0.0){
                    resul = dT2/dNV;
                    res = "El periodo(T) es igual a: "+ resul + " s";
                    txvTNt.setText(res);
                }else if(dT2==0.0 || dT2==0.0){
                    resul = dP*dNV;
                    res = "El tiempo(t) es igual a: "+resul+" s";
                    txvTNt.setText(res);
                }else if (dNV==0.0 || dNV==0){
                    resul= dT2/dP;
                    res = "El numero de vueltas que dio es: "+resul+" v";
                    txvTNt.setText(res);
                }
            }
        });

        btnCalcularFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sF = et_frecu.getText().toString();
                String sNoV = et_novueltas2.getText().toString();
                String sT3 = et_tiempo3.getText().toString();

                String res;

                if(TextUtils.isEmpty(sF)){
                    et_frecu.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sNoV)){
                    et_tiempo3.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sT3)){
                    et_novueltas2.setError("Complete el campo");
                    return;
                }

                double dF = Double.parseDouble(sF);
                double dNV2 = Double.parseDouble(sNoV);
                double dT3 = Double.parseDouble(sT3);

                double resul = 0.0;

                if (rd_mins3.isChecked()==true){
                    dT3 = dT3*60;
                }


                if (dF==0.0 && dNV2==0.0 && dT3==0.0) {
                    txvFr.setText("Tienes que tener minimo dos campos con valores");
                }else if (dF==0 || dF==0.0){
                    resul = dNV2/dT3;
                    res = "El frecuencia(F) es igual a: "+ resul + " s";
                    txvFr.setText(res);
                }else if(dT3==0.0 || dT3==0.0){
                    resul = dNV2*dF;
                    res = "El tiempo(t) es igual a: "+resul+" s";
                    txvFr.setText(res);
                }else if (dNV2==0.0 || dNV2==0){
                    resul= dF*dT3;
                    res = "El numero de vueltas que dio es: "+resul+" v";
                    txvFr.setText(res);
                }
            }
        });

        btnCalcularDOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sDis = et_dis.getText().toString();
                String sRad = et_rad.getText().toString();
                String sTeta = et_teta.getText().toString();

                String res;

                if (TextUtils.isEmpty(sDis)) {
                    et_dis.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sRad)) {
                    et_rad.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sTeta)) {
                    et_teta.setError("Complete el campo");
                    return;
                }

                double dDis = Double.parseDouble(sDis);
                double dRad = Double.parseDouble(sRad);
                double dTeta = Double.parseDouble(sTeta);

                double resul = 0.0;

                if (rd_cm1.isChecked() == true) {
                    dRad = dRad / 100;
                }
                if (rd_cm.isChecked() == true) {
                    dDis = dDis / 100;
                }


                if (dDis == 0.0 && dRad == 0.0 && dTeta == 0.0) {
                    txvDOR.setText("Tienes que tener minimo dos campos con valores mayor a cero");
                } else if (dDis == 0 || dDis == 0.0) {
                    resul = dTeta * dRad;
                    res = "La distancia(d) es igual a: " + resul + " m";
                    txvDOR.setText(res);
                } else if (dRad == 0.0 || dRad == 0.0) {
                    resul = dDis / dTeta;
                    res = "El radio(r) es igual a: " + resul + " m";
                    txvDOR.setText(res);
                } else if (dTeta == 0.0 || dTeta == 0) {
                    resul = dDis / dRad;
                    res = "El numero de vueltas que dio es: " + resul + " v";
                    txvDOR.setText(res);
                }
            }
        });


        btnCalcularAcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sDis = et_acel.getText().toString();
                String sRad = et_pes.getText().toString();
                String sTeta = etc_rad2.getText().toString();

                String res;

                if (TextUtils.isEmpty(sDis)) {
                    et_acel.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sRad)) {
                    et_pes.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sTeta)) {
                    etc_rad2.setError("Complete el campo");
                    return;
                }

                double dAcel = Double.parseDouble(sDis);
                double dPes = Double.parseDouble(sRad);
                double dRad2 = Double.parseDouble(sTeta);

                double resul = 0.0;

                if (rd_cm5.isChecked() == true) {
                    dPes = dPes / 100;
                }


                if (dAcel == 0 || dAcel == 0.0) {
                    resul = dRad2 * dPes;
                    res = "La distancia(d) es igual a: " + resul + " m";
                    txvAAR.setText(res);
                } else if (dPes == 0.0 || dPes == 0.0) {
                    resul = dAcel / dRad2;
                    res = "El radio(r) es igual a: " + resul + " m";
                    txvAAR.setText(res);
                } else if (dRad2 == 0.0 || dRad2 == 0) {
                    resul = dAcel / dPes;
                    res = "El numero de vueltas que dio es: " + resul + " v";
                    txvAAR.setText(res);
                }
            }
        });
        btnMcuRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuCalculadoraFragment.class);
                startActivity(i);
                finish();
            }
        });
        btnMcuSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MCU2.class);
                startActivity(i);
                finish();
            }
        });

    }

}
