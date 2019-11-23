package com.example.fisiquiz;

import android.provider.BaseColumns;

public final class QuizContract {
    private QuizContract(){
    }
    public static class PreguntasQuiz implements BaseColumns{
        public static final String  NOMBRE_TABLA ="quiz_preguntas_2";
        public static final String  COLUMNA_ID = "_Id";
        public static final String  COLUMNA_PREGUNTA ="pregunta";
        public static final String  COLUMNA_RESPUESTA ="respuesta";
    }
}
