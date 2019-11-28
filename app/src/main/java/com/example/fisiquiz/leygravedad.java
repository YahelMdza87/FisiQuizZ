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

public class leygravedad extends AppCompatActivity {


    EditText edtD,edtD2,edtm1,edtm2,edtf,edtf2;
    TextView txvvResulg,txvvResulf;
    RadioButton rbtnM, rbtnKm,rbtn6,rbtn62,rbtnnormal,rbtnnormal2,rbtnKm2,rbtnM2;
    Button btnCalcularg,btnCalcularf,btnRegresar,btnFormulas;

    Double valorMI,valorMI2,valorMs1,valorMs2,valorf,valorf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leygravedad);
        ///FORMULA g=(G)(MT)/(D2)
        edtD = (EditText)findViewById(R.id.edtD);
        edtD2 = (EditText)findViewById(R.id.edtD2);
        txvvResulg = (TextView) findViewById(R.id.txvResulg);
        rbtnM = (RadioButton) findViewById(R.id.rbtnM);
        rbtnKm = (RadioButton) findViewById(R.id.rbtnKm);
        btnCalcularg = (Button) findViewById(R.id.btnCalcularg);


        ///FORMULA F=(G)(M1)(M2)/(D2)
        edtm1 = (EditText)findViewById(R.id.edtm1);
        edtm2 = (EditText)findViewById(R.id.edtm2);
        edtf = (EditText) findViewById(R.id.edtf);
        edtf2 = (EditText) findViewById(R.id.edtf2);
        txvvResulf = (TextView) findViewById(R.id.txvResulf);
        rbtnM2 = (RadioButton) findViewById(R.id.rbtnM2);
        rbtnKm2 = (RadioButton) findViewById(R.id.rbtnKm2);
        rbtn6 = (RadioButton) findViewById(R.id.rbtn6);
        rbtn62 = (RadioButton) findViewById(R.id.rbtn62);
        rbtnnormal= (RadioButton) findViewById(R.id.rbtnnormal);
        rbtnnormal2= (RadioButton) findViewById(R.id.rbtnnormal2);


        btnCalcularf = (Button) findViewById(R.id.btnCalcularf);

        ///BOTON REGRESAR
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        ///BOTON MAS FORMULAS
        btnFormulas = (Button) findViewById(R.id.btnFormulas);




        btnCalcularg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorMS = edtD.getText().toString();
                String valorMS2 = edtD2.getText().toString();



                if(TextUtils.isEmpty(valorMS)){
                    edtD.setError("ERROR: no puedes dejar el campo 1 vacio");
                    return;
                }
                if(TextUtils.isEmpty(valorMS2)){
                    edtD2.setError("ERROR: no puedes dejar el campo 2 vacio");
                    return;
                }
                else if (rbtnM.isChecked()==true){
                    valorMI = Double.parseDouble(valorMS);
                    valorMI2 = Double.parseDouble(valorMS2);
                    double ValorM = valorMI;
                    double ValorM2 = valorMI2;
                    double resultado;
                    double GMT;
                    double d;



                    d = Math.pow((ValorM+ValorM2),2);

                    GMT = 4.002*Math.pow(10,14);

                    resultado = GMT/d;


                    String resultadoT = String.valueOf(resultado);

                    txvvResulg.setText("RESULTADO: g = "+resultadoT+"m/s²");

                }
                else if (rbtnKm.isChecked()==true){
                    valorMI = Double.parseDouble(valorMS);
                    valorMI2 = Double.parseDouble(valorMS2);
                    double ValorKm = (valorMI+valorMI2) * 1000;
                    double resultado;
                    double GMT;
                    double d;



                    d = Math.pow((ValorKm),2);


                    GMT = 4.002*Math.pow(10,14);

                    resultado = (GMT)/d;


                    String resultadoT = String.valueOf(resultado);

                    txvvResulg.setText("RESULTADO: g = "+resultadoT+"m/s²");

                }
            }
        });

        btnCalcularf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorM1 = edtm1.getText().toString();
                String valorM2 = edtm2.getText().toString();
                String valorD1 = edtf.getText().toString();
                String valorD2 = edtf2.getText().toString();





                ///RADIO BUTTON 6 TRUE


                if(rbtn6.isChecked()==true){
                    edtm1.setText("6000000000000000000000000");
                    if(rbtn62.isChecked()==true) {
                        edtm2.setText("6000000000000000000000000");
                        if(rbtnKm2.isChecked()==true) {
                            if(TextUtils.isEmpty(valorD1)){
                                edtf.setError("ERROR: no puedes dejar el campo 1 vacio");
                                return;
                            }
                            if(TextUtils.isEmpty(valorD2)){
                                edtf2.setError("ERROR: no puedes dejar el campo 2 vacio");
                                return;
                            }
                            valorMs1 = 6000000000000000000000000.0;
                            valorMs2 = 6000000000000000000000000.0;
                            valorf = Double.parseDouble(valorD1);
                            valorf2 = Double.parseDouble(valorD2);
                            double ValorKm = (valorf + valorf2) * 1000;

                            double resultadof;
                            double GMT;
                            double d;



                            d = Math.pow((ValorKm),2);


                            GMT = ((0.0000000000667)*(valorMs1*valorMs2));

                            resultadof = (GMT)/d;


                            String resultadoff = String.valueOf(resultadof);

                            txvvResulf.setText("RESULTADO: F = "+resultadoff+"N");

                        }


                    }
                    if(rbtn62.isChecked()==true) {
                        edtm2.setText("6000000000000000000000000");
                        if (rbtnM2.isChecked() == true) {
                            if (TextUtils.isEmpty(valorD1)) {
                                edtf.setError("ERROR: no puedes dejar el campo 1 vacio");
                                return;
                            }
                            if (TextUtils.isEmpty(valorD2)) {
                                edtf2.setError("ERROR: no puedes dejar el campo 2 vacio");
                                return;
                            }
                            valorMs1 = 6000000000000000000000000.0;
                            valorMs2 = 6000000000000000000000000.0;
                            valorf = Double.parseDouble(valorD1);
                            valorf2 = Double.parseDouble(valorD2);
                            double ValorKm = valorf;
                            double ValorKm2 = valorf2;

                            double resultadof4;
                            double GMT;
                            double d;


                            d = Math.pow((ValorKm + ValorKm2), 2);


                            GMT = ((4.002 * Math.pow(10, 14)) * valorMs2);
                            resultadof4 = (GMT) / d;

                            String resultadoff4 = String.valueOf(resultadof4);

                            txvvResulf.setText("RESULTADO: F = "+resultadoff4 + "N");

                        }
                    }
                    if(rbtnnormal2.isChecked()==true){
                        if(rbtnKm2.isChecked()==true) {
                            if(TextUtils.isEmpty(valorD1)){
                                edtf.setError("ERROR: no puedes dejar el campo 1 vacio");
                                return;
                            }
                            if(TextUtils.isEmpty(valorD2)){
                                edtf2.setError("ERROR: no puedes dejar el campo 2 vacio");
                                return;
                            }
                            valorMs1 = 6000000000000000000000000.0;
                            valorMs2 = Double.parseDouble(valorM2);
                            valorf = Double.parseDouble(valorD1);
                            valorf2 = Double.parseDouble(valorD2);
                            double ValorKm = valorf  * 1000;
                            double ValorKm2 = valorf2  * 1000;

                            double resultadof2;
                            double GMT;
                            double d;



                            d = Math.pow((ValorKm+ValorKm2),2);


                            GMT = ((4.002*Math.pow(10,14))*valorMs2);
                            resultadof2 = (GMT)/d;

                            String resultadoff2 = String.valueOf(resultadof2);

                            txvvResulf.setText("RESULTADO: F = "+resultadoff2+"N");

                        }

                    }
                    if(rbtnnormal2.isChecked()==true){
                        if(rbtnM2.isChecked()==true) {
                            if(TextUtils.isEmpty(valorD1)){
                                edtf.setError("ERROR: no puedes dejar el campo 1 vacio");
                                return;
                            }
                            if(TextUtils.isEmpty(valorD2)){
                                edtf2.setError("ERROR: no puedes dejar el campo 2 vacio");
                                return;
                            }
                            valorMs1 = 6000000000000000000000000.0;
                            valorMs2 = Double.parseDouble(valorM2);
                            valorf = Double.parseDouble(valorD1);
                            valorf2 = Double.parseDouble(valorD2);
                            double ValorKm = valorf;
                            double ValorKm2 = valorf2;

                            double resultadof3;
                            double GMT;
                            double d;



                            d = Math.pow((ValorKm+ValorKm2),2);


                            GMT = ((4.002*Math.pow(10,14))*valorMs2);
                            resultadof3 = (GMT)/d;

                            String resultadoff3 = String.valueOf(resultadof3);

                            txvvResulf.setText("RESULTADO: F = "+resultadoff3+"N");

                        }

                    }
                }





                ///RADIO BUTTON NORMAL TRUE


                if(rbtnnormal.isChecked()==true){
                    if(rbtn62.isChecked()==true) {
                        edtm2.setText("6000000000000000000000000");
                        if(rbtnKm2.isChecked()==true) {
                            if(TextUtils.isEmpty(valorD1)){
                                edtf.setError("ERROR: no puedes dejar el campo 1 vacio");
                                return;
                            }
                            if(TextUtils.isEmpty(valorD2)){
                                edtf2.setError("ERROR: no puedes dejar el campo 2 vacio");
                                return;
                            }
                            valorMs1 = Double.parseDouble(valorM1);
                            valorMs2 = 6000000000000000000000000.0;
                            valorf = Double.parseDouble(valorD1);
                            valorf2 = Double.parseDouble(valorD2);
                            double ValorKm = (valorf + valorf2) * 1000;

                            double resultadof5;
                            double GMT;
                            double d;



                            d = Math.pow((ValorKm),2);


                            GMT = ((0.0000000000667)*(valorMs1*valorMs2));

                            resultadof5 = (GMT)/d;


                            String resultadoff5 = String.valueOf(resultadof5);

                            txvvResulf.setText("RESULTADO: F = "+resultadoff5+"N");

                        }


                    }
                    if(rbtn62.isChecked()==true) {
                        edtm2.setText("6000000000000000000000000");
                        if (rbtnM2.isChecked() == true) {
                            if (TextUtils.isEmpty(valorD1)) {
                                edtf.setError("ERROR: no puedes dejar el campo 1 vacio");
                                return;
                            }
                            if (TextUtils.isEmpty(valorD2)) {
                                edtf2.setError("ERROR: no puedes dejar el campo 2 vacio");
                                return;
                            }
                            valorMs1 = Double.parseDouble(valorM1);
                            valorMs2 = 6000000000000000000000000.0;
                            valorf = Double.parseDouble(valorD1);
                            valorf2 = Double.parseDouble(valorD2);
                            double ValorKm = valorf;
                            double ValorKm2 = valorf2;

                            double resultadof6;
                            double GMT;
                            double d;


                            d = Math.pow((ValorKm + ValorKm2), 2);


                            GMT = 0.0000000000667 *(valorMs1 * valorMs2);
                            resultadof6 = (GMT) / d;

                            String resultadoff6 = String.valueOf(resultadof6);

                            txvvResulf.setText("RESULTADO: F = "+resultadoff6 + "N");

                        }
                    }
                    if(rbtnnormal2.isChecked()==true){
                        if(rbtnKm2.isChecked()==true) {
                            if(TextUtils.isEmpty(valorD1)){
                                edtf.setError("ERROR: no puedes dejar el campo 1 vacio");
                                return;
                            }
                            if(TextUtils.isEmpty(valorD2)){
                                edtf2.setError("ERROR: no puedes dejar el campo 2 vacio");
                                return;
                            }
                            valorMs1 = Double.parseDouble(valorM1);
                            valorMs2 = Double.parseDouble(valorM2);
                            valorf = Double.parseDouble(valorD1);
                            valorf2 = Double.parseDouble(valorD2);
                            double ValorKm = valorf  * 1000;
                            double ValorKm2 = valorf2  * 1000;

                            double resultadof7;
                            double GMT;
                            double d;



                            d = Math.pow((ValorKm+ValorKm2),2);


                            GMT = 0.0000000000667 *(valorMs1 * valorMs2);
                            resultadof7 = (GMT)/d;

                            String resultadoff7 = String.valueOf(resultadof7);

                            txvvResulf.setText("RESULTADO: F = "+resultadoff7+"N");

                        }

                    }
                    if(rbtnnormal2.isChecked()==true){
                        if(rbtnM2.isChecked()==true) {
                            if(TextUtils.isEmpty(valorD1)){
                                edtf.setError("ERROR: no puedes dejar el campo 1 vacio");
                                return;
                            }
                            if(TextUtils.isEmpty(valorD2)){
                                edtf2.setError("ERROR: no puedes dejar el campo 2 vacio");
                                return;
                            }
                            valorMs1 = Double.parseDouble(valorM1);
                            valorMs2 = Double.parseDouble(valorM2);
                            valorf = Double.parseDouble(valorD1);
                            valorf2 = Double.parseDouble(valorD2);
                            double ValorKm = valorf;
                            double ValorKm2 = valorf2;

                            double resultadof8;
                            double GMT;
                            double d;



                            d = Math.pow((ValorKm+ValorKm2),2);


                            GMT = 0.0000000000667 *(valorMs1 * valorMs2);
                            resultadof8 = (GMT)/d;

                            String resultadoff8 = String.valueOf(resultadof8);

                            txvvResulf.setText("RESULTADO: F = "+resultadoff8+"N");

                        }

                    }
                }
            }


        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuCalculadoraFragment.class);
                startActivity(i);
                finish();

            }
        });

        btnFormulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), leygravedad2.class);
                startActivity(intent);
                finish();


            }
        });

    }
}