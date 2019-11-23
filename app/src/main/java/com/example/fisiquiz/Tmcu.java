package com.example.fisiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tmcu extends AppCompatActivity {
    Button btnregresarmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmcu);
        btnregresarmenu = (Button) findViewById(R.id.btn_Regresar_Menu_tMCU);
        btnregresarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), fragteoria.class);
                startActivity(i);
            }
        });
    }
}
