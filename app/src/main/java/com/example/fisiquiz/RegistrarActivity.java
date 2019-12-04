package com.example.fisiquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistrarActivity extends AppCompatActivity {
    private EditText edtCorreo,edtPassword,edtNombre,edtApellido,edtConfPass;
    private Button btnRegistrar;
    private RadioButton rbProf,rbAlum;
    private RadioGroup grupo;
    private DatabaseReference mUser;
    private FirebaseAuth mAuth;

    //Variables de Java
    private String Usuario="", tipo="Registro";
    private String nombre="",apellido="",email="",password="",confPass="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        //BUttons
        btnRegistrar=(Button)findViewById(R.id.botonRegistrar);
        //EditText
        edtCorreo=(EditText)findViewById(R.id.edt_Email);
        edtPassword=(EditText)findViewById(R.id.edt_Password);
        edtNombre=(EditText)findViewById(R.id.edt_Nombre);
        edtApellido=(EditText)findViewById(R.id.edt_Apellido);
        edtConfPass=(EditText)findViewById(R.id.edt_Confirmar_Password);
        rbProf=(RadioButton)findViewById(R.id.rb_Profesor);
        rbAlum=(RadioButton)findViewById(R.id.rb_Alumno);
        grupo = (RadioGroup) findViewById(R.id.radioGroupReg);

        mAuth=FirebaseAuth.getInstance();
        mUser= FirebaseDatabase.getInstance().getReference();


        //Asignar que tipo de usuario es




        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbProf.isChecked()==true){
                    Usuario="Profesor";
                }
                if (rbAlum.isChecked()==true){
                    Usuario="Alumno";
                }
                System.out.println("////////"+Usuario);
                email=edtCorreo.getText().toString();
                password=edtPassword.getText().toString();
                nombre=edtNombre.getText().toString();
                apellido=edtApellido.getText().toString();
                confPass=edtConfPass.getText().toString();

                System.out.println("/////////////"+email+" "+password+" "+nombre+" "+apellido+" "+confPass+" "+Usuario);

                if (password.equals(confPass)){


                if (!email.isEmpty() && !password.isEmpty() && !apellido.isEmpty() && !nombre.isEmpty() && !Usuario.isEmpty()){
                   registerUser();
                }



                }
            }
        });

    }
    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Map<String, Object> map=new HashMap<>();
                            map.put("nombre",nombre);
                            map.put("apellido",apellido);
                            map.put ("tipo",Usuario);
                            mUser.child("Usuarios").child(email).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task2) {
                                    if (task2.isSuccessful() && Usuario.equals("Alumno")){
                                        startActivity(new Intent(RegistrarActivity.this, MainActivity.class));
                                    }
                                    else if (task2.isSuccessful() && Usuario.equals("Profesor")){
                                        startActivity(new Intent(RegistrarActivity.this, MainActivity_profe.class));
                                    }
                                }
                            });
                        }else{
                            if (task.getException() instanceof FirebaseAuthUserCollisionException){ //Si ya está registrado el meco
                                Toast.makeText(RegistrarActivity.this,"Este usuario ya existe",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(RegistrarActivity.this,"No se pudo registrar el usuario. Verifica tus datos ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }
}
