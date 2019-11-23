package com.example.fisiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MCU2 extends AppCompatActivity {


    Button btnBackMenu,btnCalcularVWR,btnCalcularWWAT,btnCalcularWWA,btnCalcularOWTA;
    EditText et_velN, et_velW, et_radio,et_rad1, et_wo,et_t1, et_ace, et_wf, et_wo1, et_ace1, et_t3, et_wf1, et_wo2,et_ace2, et_d;
    RadioButton rb_mt, rb_cmm,rb_minOW,rb_segOW,rb_minWW,rb_segWW;
    TextView txvVWR, txvOWT, txvWFWOA, txvWW2AO;
    View bista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcu2);

        btnBackMenu = (Button)findViewById(R.id.btn_Regresar_Menu_MCUA);
        btnCalcularVWR = (Button)findViewById(R.id.btnCalcularVWR);
        btnCalcularWWA= (Button)findViewById(R.id.btnCalcularWWA);
        btnCalcularWWAT= (Button)findViewById(R.id.btnWWAT);
        btnCalcularOWTA= (Button)findViewById(R.id.btnCalcularOWTA);
        et_velN = (EditText)findViewById(R.id.et_VelN);
        et_velW = (EditText)findViewById(R.id.et_velW);
        et_radio = (EditText)findViewById(R.id.et_radio);
        et_rad1 = (EditText)findViewById(R.id.et_rad1);
        et_d = (EditText)findViewById(R.id.et_d);
        et_wo = (EditText)findViewById(R.id.et_wo);
        et_t1 = (EditText)findViewById(R.id.et_t1);
        et_ace = (EditText)findViewById(R.id.et_ace);
        et_wf = (EditText)findViewById(R.id.et_wf);
        et_wo1 = (EditText)findViewById(R.id.et_wo1);
        et_ace1 = (EditText)findViewById(R.id.et_ace1);
        et_t3 = (EditText)findViewById(R.id.et_t3);
        et_wf1 = (EditText)findViewById(R.id.et_wf2);
        et_wo2 = (EditText)findViewById(R.id.et_wo2);
        et_ace2 = (EditText)findViewById(R.id.et_ace2);
        rb_mt = (RadioButton)findViewById(R.id.rb_mt);
        rb_cmm = (RadioButton)findViewById(R.id.rb_cmm1);
        rb_minOW=(RadioButton)findViewById(R.id.rb_minOW);
        rb_segOW=(RadioButton)findViewById(R.id.rb_segOW);
        rb_minWW=(RadioButton)findViewById(R.id.rb_minWW);
        rb_segWW=(RadioButton)findViewById(R.id.rb_segWW);
        txvVWR = (TextView)findViewById(R.id.txvVWR);
        txvOWT = (TextView)findViewById(R.id.txvOWT);
        txvWFWOA = (TextView)findViewById(R.id.txvWFWOA);
        txvWW2AO = (TextView)findViewById(R.id.txvWW2AO);

        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(getApplicationContext(),MCU.class);
                startActivity(inte);
                finish();
            }
        });
        btnCalcularVWR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sVN = et_velN.getText().toString();
                String sRad = et_radio.getText().toString();
                String sWN = et_velW.getText().toString();

                String res;

                if (TextUtils.isEmpty(sVN)) {
                    et_velN.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sRad)) {
                    et_radio.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sWN)) {
                    et_velW.setError("Complete el campo");
                    return;
                }

                double dVN = Double.parseDouble(sVN);
                double dRad = Double.parseDouble(sRad);
                double dWN = Double.parseDouble(sWN);

                double resul = 0.0;

                if (rb_cmm.isChecked() == true) {
                    dRad = dRad / 100;
                }

                if (dVN == 0.0 && dRad == 0.0 && dWN == 0.0) {
                    txvVWR.setText("Tienes que tener minimo dos campos con valores mayor a cero");
                } else if (dVN == 0 || dVN == 0.0) {
                    resul = dWN * dRad;
                    res = "La Velocidad(v) es igual a: " + resul + " m/s";
                    txvVWR.setText(res);
                } else if (dRad == 0.0 || dRad == 0.0) {
                    resul = dVN / dWN;
                    res = "El radio(r) es igual a: " + resul + " m";
                    txvVWR.setText(res);
                } else if (dWN == 0.0 || dWN == 0) {
                    resul = dVN / dRad;
                    res = "La Velocidad Angular(W): " + resul + " rad";
                    txvVWR.setText(res);
                }
            }
        });
        btnCalcularOWTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWo = et_wo.getText().toString();
                String sRad1 = et_rad1.getText().toString();
                String sT = et_t1.getText().toString();
                String sAce = et_ace.getText().toString();

                String res;

                if (TextUtils.isEmpty(sWo)) {
                    et_wo.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sRad1)) {
                    et_rad1.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sT)) {
                    et_t1.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sAce)) {
                    et_ace.setError("Complete el campo");
                    return;
                }

                double dWo = Double.parseDouble(sWo);
                double dAce = Double.parseDouble(sAce);
                double dRad1 = Double.parseDouble(sRad1);
                double dT = Double.parseDouble(sT);

                double resul = 0.0, raiz=0.0;

                if (rb_minOW.isChecked() == true) {
                    dT = dT * 60;
                }

                if (dRad1 == 0 || dRad1 == 0.0) {
                    resul = (dWo * dT);
                    resul = resul+ (dAce*(Math.pow(dT,2)));
                    resul = resul/2;
                    res = "El Desplazamiento Angular(Θ) es igual a: " + resul + " v";
                    txvOWT.setText(res);
                } else if (dAce == 0.0 || dAce == 0.0) {
                    resul = 2*(dRad1-(dWo*dT));
                    resul = resul/Math.pow(dT,2);
                    res = "La Aceleracion(α): " + resul + " m/s² y en rad/s²: "+ resul*(2*(Math.PI));
                    txvOWT.setText(res);
                }else if (dT == 0.0 || dT == 0) {
                    resul = (Math.pow(dWo,2));
                    resul = resul+2*(dAce)*dRad1;
                    raiz = Math.sqrt(resul);
                    resul = (-dWo+raiz)/dAce;
                    res = "El tiempo(t) es igual a: " + resul + " s";
                    txvOWT.setText(res);
                } else if (dWo == 0.0 || dWo == 0) {
                    resul = dRad1-((dAce*(Math.pow(dT,2)))/2);
                    resul = resul/dT;
                    res = "La Velocidad Inicial Angular(W): " + resul + " rad";
                    txvOWT.setText(res);
                }
            }
        });

        btnCalcularWWAT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWf = et_wf.getText().toString();
                String sWo = et_wo1.getText().toString();
                String sAce = et_ace1.getText().toString();
                String sT3 = et_t3.getText().toString();

                String res;

                if (TextUtils.isEmpty(sWf)) {
                    et_wf.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sWo)) {
                    et_wo1.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sT3)) {
                    et_ace1.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sAce)) {
                    et_t3.setError("Complete el campo");
                    return;
                }

                double dWo = Double.parseDouble(sWo);
                double dAce = Double.parseDouble(sAce);
                double dWf = Double.parseDouble(sWf);
                double dT3 = Double.parseDouble(sT3);

                double resul = 0.0;

                if (rb_minWW.isChecked() == true) {
                    dT3 = dT3 * 60;
                }

                if (dWf == 0 || dWf == 0.0) {
                    resul = dWo + dAce*dT3;
                    res = "La velocidad Angular Final(wf) es igual a: " + resul + " v/seg";
                    txvWFWOA.setText(res);
                }  else if (dAce == 0.0 || dAce == 0) {
                    resul = (dWf-dWo)/dT3;
                    res = "La Aceleracion(α): " + resul + " m/s² y en rad/s²: "+ resul*(2*(Math.PI));
                    txvWFWOA.setText(res);
                }else if (dT3 == 0.0 || dT3 == 0) {
                    resul = (dWf-dWo)/dAce;
                    res = "El tiempo(t) es igual a: " + resul + " s";
                    txvWFWOA.setText(res);
                }else if (dWo == 0.0 || dWo == 0.0) {
                    resul = dWf-(dAce*dT3);
                    res = "La Velocidad Angular Inicial(Wo) es igual a: " + resul + " v/seg";
                    txvWFWOA.setText(res);
                }
            }
        });

        btnCalcularWWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWf = et_wf1.getText().toString();
                String sWo = et_wo2.getText().toString();
                String sAce = et_ace2.getText().toString();
                String sD = et_d.getText().toString();

                String res;

                if (TextUtils.isEmpty(sWf)) {
                    et_wf1.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sWo)) {
                    et_wo2.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sAce)) {
                    et_ace2.setError("Complete el campo");
                    return;
                }
                if (TextUtils.isEmpty(sD)) {
                    et_d.setError("Complete el campo");
                    return;
                }

                double dWo = Double.parseDouble(sWo);
                double dAce = Double.parseDouble(sAce);
                double dWf = Double.parseDouble(sWf);
                double dD = Double.parseDouble(sD);

                double resul = 0.0;


                if (dAce == 0.0 || dAce == 0) {
                    resul = ((Math.pow(dWf,2))-(Math.pow(dWo,2)));
                    resul = resul/(2*dD);
                    res = "La Aceleracion(α): " + resul + " v/seg² y en rad/s²: "+ resul*(2*(Math.PI));
                    txvWW2AO.setText(res);
                } else if (dWf == 0 || dWf == 0.0) {
                    resul = Math.pow(dWo,2)+(2*dAce*dD);
                    resul = Math.sqrt(resul);
                    res = "La velocidad Angular Final(wf) es igual a: " + resul + " v/seg";
                    txvWW2AO.setText(res);
                } else if (dD == 0.0 || dD == 0) {
                    resul = (Math.pow(dWf,2)-Math.pow(dWo,2))/(2*dAce);
                    res = "La Desplazamiento Angular () es igual a: " + resul + " v";
                    txvWW2AO.setText(res);
                }else if (dWo == 0.0 || dWo == 0.0) {
                    resul = Math.pow(dWf,2)-(2*(dAce*dD));
                    resul = Math.sqrt(resul);
                    res = "La Velocidad Angular Inicial(Wo) es igual a: " + resul + " v/seg";
                    txvWW2AO.setText(res);
                }
            }
        });
    }
}
