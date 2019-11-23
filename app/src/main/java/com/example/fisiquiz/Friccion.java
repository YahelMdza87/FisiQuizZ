package com.example.fisiquiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Friccion extends AppCompatActivity {
    CheckBox chF,chA,chM,chMU,chFr,chFX,chFY,chW;
    EditText edtF,edtA,edtM,edtMU,edtFr,edtFX,edtFY,edtW,edtAng;
    RadioButton rbFKgf, rbWKgf,rbFYKgf,rbFXKgf,rbFrKgf,rbFAKgf;
    Button btnCalcularF,btn_friccion_regresar;
    TextView textView;
    String F="",FX="",FY="",Fr="",MU="",M="",W="",Ang="",A="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friccion);

        //variables llamadas
        btn_friccion_regresar = (Button) findViewById(R.id.btn_friccion_regresar);
        rbFAKgf=(RadioButton)findViewById(R.id.rbFAKgf);
        rbFKgf=(RadioButton)findViewById(R.id.rbFKgf);
        rbFrKgf=(RadioButton)findViewById(R.id.rbFrKgf);
        rbFXKgf=(RadioButton)findViewById(R.id.rbFXKgf);
        rbFYKgf=(RadioButton)findViewById(R.id.rbFYKgf);
        rbWKgf=(RadioButton)findViewById(R.id.rbWKgf);
        chF=(CheckBox)findViewById(R.id.cbF);
        chA=(CheckBox)findViewById(R.id.cbA);
        chM=(CheckBox)findViewById(R.id.cbM);
        chMU=(CheckBox)findViewById(R.id.cbMU);
        chFr=(CheckBox)findViewById(R.id.cbFr);
        chFX=(CheckBox)findViewById(R.id.cbWX);
        chFY=(CheckBox)findViewById(R.id.cbWY);
        chW=(CheckBox)findViewById(R.id.cbW);
        edtA=(EditText)findViewById(R.id.edtAcele);
        edtF=(EditText)findViewById(R.id.edtFuerza);
        edtFr=(EditText)findViewById(R.id.edtFriccion);
        edtFX=(EditText)findViewById(R.id.edtWX);
        edtFY=(EditText)findViewById(R.id.edtWY);
        edtM=(EditText)findViewById(R.id.edtMasa);
        edtMU=(EditText)findViewById(R.id.edtMU);
        edtW=(EditText)findViewById(R.id.edtW);
        edtAng=(EditText)findViewById(R.id.edtAng);
        textView=(TextView)findViewById(R.id.textView);
        btnCalcularF=(Button)findViewById(R.id.btnCalcularFuerza);


        //Extraccion de datos String
        F = edtF.getText().toString();
        FX = edtFX.getText().toString();
        FY = edtFY.getText().toString();
        Fr = edtFr.getText().toString();
        M = edtM.getText().toString();
        MU =edtMU.getText().toString();
        A = edtA.getText().toString();
        W = edtW.getText().toString();
        Ang = edtAng.getText().toString();

        //Boton calcular
        btn_friccion_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuCalculadoraFragment.class);
                startActivity(i);
            }
        });
        btnCalcularF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //igualaciones vacias
                if(TextUtils.isEmpty(F)){
                    F="0";
                }if(TextUtils.isEmpty(FX)){
                    FX="0";
                }if(TextUtils.isEmpty(FY)){
                    FY="0";
                }if(TextUtils.isEmpty(Fr)){
                    Fr="0";
                }if(TextUtils.isEmpty(M)){
                    M="0";
                }if(TextUtils.isEmpty(MU)){
                    MU="0";
                }if(TextUtils.isEmpty(A)){
                    A="0";
                }if(TextUtils.isEmpty(W)){
                    W="0";
                }if(TextUtils.isEmpty(Ang)){
                    Ang="0";
                }

                //Extraccion de datos double
                double OF = Double .parseDouble(F);
                double OFr = Double .parseDouble(Fr);
                double OM = Double .parseDouble(M);
                double OMU = Double .parseDouble(MU);
                double OA = Double .parseDouble(A);
                double OW = Double .parseDouble(W);
                double OAng = Double .parseDouble(Ang);
                double OFX= Double .parseDouble(FX);
                double OFY= Double .parseDouble(FY);

                if (rbWKgf.isChecked()==true){
                    OW=OW*9.81;
                }
                if (rbFYKgf.isChecked()==true && chFY.isChecked()==true){
                    OFY=OFY*9.81;
                }
                if (rbFXKgf.isChecked()==true && chFX.isChecked()==true){
                    OFX=OFX*9.81;
                }
                if (rbFKgf.isChecked()==true){
                    OF=OF*9.81;
                }
                if (rbFrKgf.isChecked()==true){
                    OFr=OFr*9.81;
                }
                //Resultantes
                double Fresul=0.0,FXresul=0.0,FYresul=0.0,Frresul=0.0,Mresul=0.0,MUresul=0.0,Aresul=0.0,Wresul=0.0,Angresul=0.0;
                //Checkbox Errores
                if (chF.isChecked()==true){
                    Fresul=OM*OA;
                }

                if (chM.isChecked()==true){
                    if(OW==0.0){
                        Mresul=OF/OA;
                    }
                    else  if (OA==0.0 || OF==0.0) {
                        Mresul=OW/(9.81);
                    }
                }
                if (chFX.isChecked()==true){
                    FXresul=(OF)*(Math.cos(OAng));
                    if (FXresul<=0.0){
                        FXresul=FXresul*(-1);
                    }
                }
                if (chA.isChecked()==true && OA==0 && OM>0){
                    Aresul=OF/OM;
                }
                if (chW.isChecked()==true){
                    Wresul=OM*(9.81);
                }
                if (chFY.isChecked()==true){
                    FYresul=(OF)*(Math.sin(OAng));
                }
                if (chMU.isChecked()==true){
                    MUresul=OFr/OW;
                }
                if (chFr.isChecked()==true){
                    Frresul=OW*OMU;
                }
                //Resultados en 0
                if (Fresul==0 && chF.isChecked()==true){
                    Fresul=Mresul*Aresul;
                }
                if (FXresul==0 && chFX.isChecked()==true){
                    FXresul=(Fresul)*(Math.cos(OAng));
                    if (FXresul<=0.0){
                        FXresul=FXresul*(-1);
                    }
                }
                if (Aresul==0  && chA.isChecked()==true && OA==0){
                    Aresul=OF/Mresul;
                }
                if (FYresul==0 && chFY.isChecked()==true){
                    FYresul=(Fresul)*(Math.sin(OAng));
                }
                if (MUresul==0 && chMU.isChecked()==true){
                    MUresul=Frresul/Wresul;
                }
                if (Frresul==0 && OW==0 && chFr.isChecked()==true){
                    Frresul=Wresul*OMU;
                    if (OMU==0){
                        Fresul=Wresul*MUresul;
                    }
                }
                //Mandar Edt
                if (chF.isChecked()==true){
                    edtF.setText(""+Fresul);
                }

                if (chM.isChecked()==true && Mresul>0){
                    edtM.setText(""+Mresul);
                }
                if (chFX.isChecked()==true){
                    edtFX.setText(""+FXresul);
                }
                if (chA.isChecked()==true && Aresul>0){
                    edtA.setText(""+Aresul);
                }
                if (chW.isChecked()==true){
                    edtW.setText(""+Wresul);
                }
                if (chFY.isChecked()==true){
                    edtFY.setText(""+FYresul);
                }
                if (chMU.isChecked()==true){
                    edtMU.setText(""+MUresul);
                }
                if (chFr.isChecked()==true){
                    edtFr.setText(""+Frresul);
                }
            }
        });
    }
}