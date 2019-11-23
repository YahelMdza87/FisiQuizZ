package com.example.fisiquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class fragquiz extends Fragment {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFES = "sharedPrefes";
    public static final String KEY_RECORD = "keyRecord";
    private int record;
    private TextView txtv_record_quiz;
    View vista;
    Button btn_ini_quiz;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_fragquiz, container, false);
        btn_ini_quiz = (Button) vista.findViewById(R.id.btn_ini_quiz);
        txtv_record_quiz = (TextView) vista.findViewById(R.id.txtv_record_quiz);
        cargarRecordQuiz();
        btn_ini_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), QuizActivity.class);
                getActivity().startActivityForResult(i, REQUEST_CODE_QUIZ);
            }
        });
        return vista;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == Activity.RESULT_OK) {
                int correctas = data.getIntExtra(QuizActivity.NEW_RECORD, 0);
                if (correctas > record) {
                    nuevoRecord(correctas);
                }
            }
        }
    }
    public void cargarRecordQuiz(){

        SharedPreferences prefes = this.getActivity().getSharedPreferences(SHARED_PREFES, Context.MODE_PRIVATE);
        record = prefes.getInt(KEY_RECORD, 0);
        txtv_record_quiz.setText("Puntaje mas alto: " + record);
    }
    private void nuevoRecord(int acertadas) {
        record = acertadas;
        txtv_record_quiz.setText("Puntuaje mas alto: " + record);

        SharedPreferences prefes = this.getActivity().getSharedPreferences(SHARED_PREFES, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefes.edit();
        edit.putInt(KEY_RECORD, record);
        edit.apply();
    }


}