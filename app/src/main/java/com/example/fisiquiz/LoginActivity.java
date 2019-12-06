package com.example.fisiquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.login.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
//Variables del XML
    private FirebaseAuth mAuth;
private EditText edtCorreo,edtPassword;
private Button btnLogin,btnRegistrar;
//Variables de Java
    private String email="",password="",user="";
    private DatabaseReference mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //BUttons
        btnLogin=(Button)findViewById(R.id.btn_Login);
        btnRegistrar=(Button)findViewById(R.id.btn_Registrar);
        //EditText
        edtCorreo=(EditText)findViewById(R.id.edt_Correo);
        edtPassword=(EditText)findViewById(R.id.edt_Contraseña);
        mAuth=FirebaseAuth.getInstance();

        mUser= FirebaseDatabase.getInstance().getReference();

        //Inicializamos el boton de Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
               /* if (email.equals("alumno")){
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else if (email.equals("profe")){
                    Intent i = new Intent(getApplicationContext(), MainActivity_profe.class);
                    startActivity(i);
                    finish();
                }*/



    }
});
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrarActivity.class));
                finish();
            }
        });

           }

   private void loginUser(){
        email=edtCorreo.getText().toString();
        password=edtPassword.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        tipoDeUsuario();
                    }

                    else {
                        Toast.makeText(LoginActivity.this, "No se pudo iniciar sesion, compruebe su datos", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
        else {
            Toast.makeText(LoginActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
        }
        //Extraer datos

    }
    private void tipoDeUsuario(){
        String[] emailWhitout=email.split("@");
        mUser.child("Usuarios").child(emailWhitout[0]).child("tipo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String tipo=dataSnapshot.getValue().toString();

                if ( dataSnapshot.exists()){
                    if (tipo.equals("Alumno")){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    else if (tipo.equals("Profesor")){
                        startActivity(new Intent(LoginActivity.this, MainActivity_profe.class));
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this, "Tu usuario no existe", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                startActivity(new Intent(LoginActivity.this, RegistrarActivity.class));

            }
        });
    }
        }
