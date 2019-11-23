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


public class leygravedad2 extends AppCompatActivity {

    TextView txvResultadog, txvResultadoW;
    Button btnCalculargP,btnRegresarg,btnCalcularW,btnBorrar;
    EditText edtMasa, edtPotencia, edtDistancia, edtMW, edtPeso, edtG;
    RadioButton rbtnMg,rbtnKmg;

    Double valorMasa1,valorPotencia1,valorDistancia1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leygravedad2);

        ///FORMULA DE GRAVEDAD DE PLANETAS

        txvResultadog = (TextView) findViewById(R.id.txvResultadog);
        btnCalculargP = (Button) findViewById(R.id.btnCalculargP);
        rbtnKmg = (RadioButton)findViewById(R.id.rbtnKmg);
        rbtnMg = (RadioButton) findViewById(R.id.rbtnMg);
        edtMasa = (EditText) findViewById(R.id.edtMasaLG);
        edtPotencia = (EditText) findViewById(R.id.edtPotencia);
        edtDistancia = (EditText) findViewById(R.id.edtDistancia);

        ///FORMULA PARA PESO
        btnCalcularW = (Button) findViewById(R.id.btnCalculargW);
        edtMW = (EditText)findViewById(R.id.edtMW);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtG = (EditText) findViewById(R.id.edtG);
        txvResultadoW = (TextView) findViewById(R.id.txvResultadoW);

        ///BOTON PARA REGRESAR

        btnRegresarg = (Button) findViewById(R.id.btnRegresarg);

        ///BOTON BORRAR

        btnBorrar = (Button) findViewById(R.id.btnBorrar);


        ///BOTON CALCULAR GRAVEDAD PLANETA
        btnCalculargP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorMasa = edtMasa.getText().toString();
                String valorPotencia = edtPotencia.getText().toString();
                String valorDistancia = edtDistancia.getText().toString();



                if(TextUtils.isEmpty(valorMasa)){
                    edtMasa.setError("ERROR: Debes poner una Masa");
                    return;
                }
                if(TextUtils.isEmpty(valorPotencia)){
                    edtPotencia.setError("ERROR: Debes poner elevada a una potencia");
                    return;
                }
                if(TextUtils.isEmpty(valorDistancia)){
                    edtDistancia.setError("ERROR: Debes poner una Distancia");
                    return;
                }
                else if (rbtnMg.isChecked()==true){
                    valorMasa1 = Double.parseDouble(valorMasa);
                    valorPotencia1 = Double.parseDouble(valorPotencia);
                    valorDistancia1 = Double.parseDouble(valorDistancia);
                    double ValorM = valorMasa1;
                    double ValorD = valorDistancia1;
                    double ValorP = valorPotencia1;
                    double resultado;
                    double GMT;
                    double d;



                    d = Math.pow((ValorD),2);

                    GMT = 0.0000000000667 * (ValorM * Math.pow(10,ValorP));

                    resultado = GMT/d;


                    String resultadoT = String.valueOf(resultado);

                    txvResultadog.setText("RESULTADO: g = "+resultadoT+"m/s²");

                }
                else if (rbtnKmg.isChecked()==true){
                    valorMasa1 = Double.parseDouble(valorMasa);
                    valorPotencia1 = Double.parseDouble(valorPotencia);
                    valorDistancia1 = Double.parseDouble(valorDistancia);
                    double ValorM = valorMasa1;
                    double ValorD = valorDistancia1 * 1000;
                    double ValorP = valorPotencia1;
                    double resultado;
                    double GMT;
                    double d;



                    d = Math.pow((ValorD),2);


                    GMT = 0.0000000000667 * (ValorM * Math.pow(10,ValorP));

                    resultado = (GMT)/d;


                    String resultadoT = String.valueOf(resultado);

                    txvResultadog.setText("RESULTADO: g = "+resultadoT+"m/s²");

                }
            }
        });


        ///BOTON CALCULARW

        btnCalcularW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edtMW.getText().toString().isEmpty()){

                    double Peso = Double.parseDouble(edtPeso.getText().toString());
                    double Gravedad = Double.parseDouble(edtG.getText().toString());
                    double resultadoMasa = Peso/Gravedad;
                    String resultadoM = String.valueOf(resultadoMasa);
                    txvResultadoW.setText("RESULTADO: La masa es "+resultadoM+"Kg");
                    edtMW.setText(resultadoM);
                }
                else if (edtPeso.getText().toString().isEmpty()){

                    double Masa = Double.parseDouble(edtMW.getText().toString());
                    double Gravedad = Double.parseDouble(edtG.getText().toString());
                    double resultadoPeso = Masa*Gravedad;
                    String resultadoP = String.valueOf(resultadoPeso);
                    txvResultadoW.setText("RESULTADO: El peso es "+resultadoP+"N");
                    edtPeso.setText(resultadoP);

                }
                else if (edtG.getText().toString().isEmpty()){

                    double Peso = Double.parseDouble(edtPeso.getText().toString());
                    double Masa = Double.parseDouble(edtMasa.getText().toString());
                    double resultadoG = Peso/Masa;
                    String resultadoW = String.valueOf(resultadoG);
                    txvResultadoW.setText("RESULTADO: La gravedad es "+resultadoW+"m/s²");

                    edtG.setText(resultadoW);

                }


            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvResultadoW.setText("");
                edtMW.setText("");
                edtG.setText("");
                edtPeso.setText("");
            }
        });

        ///BOTON REGRESAR
        btnRegresarg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), leygravedad.class);
                startActivity(intent);
                finish();
            }
        });
    }
}