package com.example.fisiquiz;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;


public class PlanoInclinadoActivity extends AppCompatActivity {
    TextView txv;
    CheckBox chF,chA,chM,chMU,chFr,chWX,chWY,chW;
    EditText edtF,edtA,edtM,edtMU,edtFr,edtWX,edtWY,edtW,edtAng;
    Button btnCalcularF,btn_plano_regresar;
    Spinner sp;
    double Fresul=0.0,WXresul=0.0,WYresul=0.0,Frresul=0.0,Mresul=0.0,MUresul=0.0,Aresul=0.0,Wresul=0.0,Angresul=0.0;
    String tipo="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plano_inclinado);
        Scanner r= new Scanner(System.in);
        //variables llamadas
        chF=(CheckBox)findViewById(R.id.cbF);
        chA=(CheckBox)findViewById(R.id.cbA);
        chM=(CheckBox)findViewById(R.id.cbM);
        chMU=(CheckBox)findViewById(R.id.cbMU);
        chFr=(CheckBox)findViewById(R.id.cbFr);
        chWX=(CheckBox)findViewById(R.id.cbWX);
        chWY=(CheckBox)findViewById(R.id.cbWY);
        chW=(CheckBox)findViewById(R.id.cbW);
        edtA=(EditText)findViewById(R.id.edtAcele);
        edtF=(EditText)findViewById(R.id.edtFuerza);
        edtFr=(EditText)findViewById(R.id.edtFriccion);
        edtWX=(EditText)findViewById(R.id.edtWX);
        edtWY=(EditText)findViewById(R.id.edtWY);
        edtM=(EditText)findViewById(R.id.edtMasaPI);
        edtMU=(EditText)findViewById(R.id.edtMU);
        edtW=(EditText)findViewById(R.id.edtW);
        edtAng=(EditText)findViewById(R.id.edtAng);
        sp=(Spinner)findViewById(R.id.spinner);
        btn_plano_regresar=(Button)findViewById(R.id.btn_plano_regresar);
        btnCalcularF=(Button)findViewById(R.id.btnCalcularFuerza);
        txv=(TextView)findViewById(R.id.textView);


        sp.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                this.getResources().getStringArray(R.array.strPlanos)));
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strPlanos="";
                strPlanos = sp.getSelectedItem().toString();
                switch (strPlanos){
                    case "Plano inclinado de bajada":
                        txv.setText("Plano inclinado de bajada");
                        tipo="b";
                        edtA.setText("");
                        edtF.setText("");
                        edtFr.setText("");
                        edtWX.setText("");
                        edtWY.setText("");
                        edtM.setText("");
                        edtMU.setText("");
                        edtW.setText("");
                        edtAng.setText("");
                        break;

                    case "Plano inclinado de subida":
                        txv.setText("Plano inclinado de subida");
                        tipo="s";
                        edtA.setText("");
                        edtF.setText("");
                        edtFr.setText("");
                        edtWX.setText("");
                        edtWY.setText("");
                        edtM.setText("");
                        edtMU.setText("");
                        edtW.setText("");
                        edtAng.setText("");
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_plano_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuCalculadoraFragment.class);
                startActivity(i);
                finish();
            }
        });

        //Boton calcular
        btnCalcularF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String F = (edtF.getText().toString());
                String WX = (edtWX.getText().toString());
                String WY = (edtWY.getText().toString());
                String Fr = (edtFr.getText().toString());
                String M = (edtM.getText().toString());
                String MU =(edtMU.getText().toString());
                String A = (edtA.getText().toString());
                String W = (edtW.getText().toString());
                String Ang = (edtAng.getText().toString());
                //igualaciones vacias
                if(TextUtils.isEmpty(F)){
                    F="0";
                }if(TextUtils.isEmpty(WX)){
                    WX="0";
                }if(TextUtils.isEmpty(WY)){
                    WY="0";
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
                final double OF = Double .parseDouble(F);
                final double OFr = Double .parseDouble(Fr);
                final double OM = Double .parseDouble(M);
                final double OMU = Double .parseDouble(MU);
                final double OA = Double .parseDouble(A);
                final double OW = Double .parseDouble(W);
                final double OAng = Double .parseDouble(Ang);
                double OWX= Double .parseDouble(WX);
                double OWY= Double .parseDouble(WY);
                System.out.println(tipo);
                //Extraccion de datos String
                if (tipo == "b") {
                    System.out.println("ENtro pero no hago nada");
                    double resultan=Math.tan(OAng);
                    if (OAng==0){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Agregue el angulo", Toast.LENGTH_SHORT);

                        toast1.show();
                    }
                    else if (resultan>OMU){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Su objeto no se resbala, ni está a apunto de moverse", Toast.LENGTH_SHORT);

                        toast1.show();
                    }
                    else if (resultan==OMU){
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Su objeto está en equilibrio", Toast.LENGTH_SHORT);

                        toast1.show();
                    }
                    else{

                        if (chM.isChecked()==true || OM==0){
                            Mresul=OW/(9.81);
                        }
                        if (chWX.isChecked()==true){
                            WXresul=(OW)*(Math.sin(OAng));
                            if (WXresul<=0.0){
                                WXresul=WXresul*(-1);
                            }
                        }
                        if (chA.isChecked()==true){
                            if (OF>0){
                                Aresul=(OWX+OF-OFr)/OM;
                            }
                            else {
                                Aresul=(OWX-OFr)/OM;
                            }
                        }
                        if (chW.isChecked()==true){
                            Wresul=OM*(9.81);
                        }
                        if (chWY.isChecked()==true){
                            WYresul=(OW)*(Math.cos(OAng));
                            if (WYresul<=0.0){
                                WYresul=WYresul*(-1);
                            }
                        }
                        if (chMU.isChecked()==true){
                            MUresul=OFr/OW;
                        }
                        if (chFr.isChecked()==true){
                            Frresul=OWY*OMU;
                        }
                        //Resultados en 0
                        if (chF.isChecked()==true){
                            if (OWX==0 && OFr==0 && OM>0){
                                Fresul=(WXresul-Frresul)+(OA*OM);
                            }
                            else if (OFr==0 && OM>0){
                                Fresul=(OWX-Frresul)+(OA*OM);
                            }
                            else if (OWX==0 && OM>0){
                                Fresul=(WXresul-OFr)+(OA*OM);
                            }
                            else if (OWX==0 && OFr==0){
                                Fresul=(WXresul-Frresul)+(OA*Mresul);
                            }
                            else if (OFr==0){
                                Fresul=(OWX-Frresul)+(OA*Mresul);
                            }
                            else if (OWX==0){
                                Fresul=(WXresul-OFr)+(OA*Mresul);
                            }
                        }
                        if (WXresul==0 && chWX.isChecked()==true){
                            WXresul=(Wresul)*(Math.sin(OAng));
                            if (WXresul<=0.0){
                                WXresul=WXresul*(-1);
                            }
                        }
                        if (Aresul==0  && chA.isChecked()==true && OM==0){
                            Aresul=(WXresul-Frresul)/Mresul;
                        }
                        else{
                            Aresul=(WXresul-Frresul)/OM;
                        }
                        if (WYresul==0 && chWY.isChecked()==true){
                            WYresul=(Wresul)*(Math.cos(OAng));
                            if (WYresul<=0.0){
                                WYresul=WYresul*(-1);
                            }
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
                    }
                }
                if (tipo=="s") {
                    if (chF.isChecked()==true){
                        Fresul=(-OWX-OFr)+(OA*OM);
                    }
                    if (chM.isChecked()==true || OM==0){
                        Mresul=OW/(9.81);
                    }
                    if (chWX.isChecked()==true){
                        WXresul=(OW)*(Math.sin(OAng));
                        if (WXresul<=0.0){
                            WXresul=WXresul*(-1);
                        }
                    }
                    if (chA.isChecked()==true){
                        if (OF>0){
                            Aresul=(OF-OWX+OF-OFr)/OM;
                        }
                        else{
                            Aresul=(OF-OWX-OFr)/OM;
                        }
                    }
                    if (chW.isChecked()==true){
                        Wresul=OM*(9.81);
                    }
                    if (chWY.isChecked()==true){
                        WYresul=(OW)*(Math.cos(OAng));
                        if (WYresul<=0.0){
                            WYresul=WYresul*(-1);
                        }
                    }
                    if (chMU.isChecked()==true){
                        MUresul=OFr/OW;
                    }
                    if (chFr.isChecked()==true){
                        Frresul=OWY*OMU;
                    }
                    //Resultados en 0
                    if (chF.isChecked()==true){
                        if (OWX==0 && OFr==0 && OM>0){
                            Fresul=(-WXresul-Frresul)+(OA*OM);
                        }
                        else if (OFr==0 && OM>0){
                            Fresul=(-OWX-Frresul)+(OA*OM);
                        }
                        else if (OWX==0 && OM>0){
                            Fresul=(-WXresul-OFr)+(OA*OM);
                        }
                        else if (OWX==0 && OFr==0){
                            Fresul=(-WXresul-Frresul)+(OA*Mresul);
                        }
                        else if (OFr==0){
                            Fresul=(-OWX-Frresul)+(OA*Mresul);
                        }
                        else if (OWX==0){
                            Fresul=(WXresul-OFr)+(OA*Mresul);
                        }
                    }
                    if (WXresul==0 && chWX.isChecked()==true){
                        WXresul=(Wresul)*(Math.sin(OAng));
                        if (WXresul<=0.0){
                            WXresul=WXresul*(-1);
                        }
                    }
                    if (Aresul==0  && chA.isChecked()==true){
                        if (OF>0&& OWX==0 && OFr==0 && OM==0){
                            Aresul=(OF-WXresul-Frresul)/Mresul;
                        }
                        else if (OF>0 && OFr==0 && OM==0){
                            Aresul=(OF-OWX-Frresul)/Mresul;
                        }
                        else if (OF>0 && OM==0){
                            Aresul=(OF-OWX-OFr)/Mresul;
                        }
                        else if (OWX==0 &&OFr==0){
                            Aresul=(OF-WXresul-Frresul)/OM;
                        }
                        else if (OFr==0){
                            Aresul=(OF-OWX-Frresul)/OM;
                        }
                    }
                    if (WYresul==0 && chWY.isChecked()==true){
                        WYresul=(Wresul)*(Math.cos(OAng));
                        if (WYresul<=0.0){
                            WYresul=WYresul*(-1);
                        }
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
                }


                //Resultantes
                //Checkbox Errores

                //Mandar Edt
                if (chF.isChecked() == true) {
                    edtF.setText("" + Fresul);
                }

                if (chM.isChecked()==true && Mresul>0){
                    edtM.setText(""+Mresul);
                }
                if (chWX.isChecked()==true){
                    edtWX.setText(""+WXresul);
                }
                if (chA.isChecked()==true && Aresul>0){
                    edtA.setText(""+Aresul);
                }
                if (chW.isChecked()==true){
                    edtW.setText(""+Wresul);
                }
                if (chWY.isChecked()==true){
                    edtWY.setText(""+WYresul);
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
