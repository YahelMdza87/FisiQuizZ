package com.example.fisiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tsegundaley extends AppCompatActivity {
    Button btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsegundaley);
        btnregresar = (Button) findViewById(R.id.btn_regresar_tSegundaley);
        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), fragteoria.class);
                startActivity(i);
            }
        });
    }
}
