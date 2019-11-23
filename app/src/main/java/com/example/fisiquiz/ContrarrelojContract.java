package com.example.fisiquiz;

import android.provider.BaseColumns;

public final class ContrarrelojContract {

    private ContrarrelojContract() {
    }

    public static class TablaPreguntas implements BaseColumns {
        public static final String NOMBRE_TABLA = "quiz_preguntas";
        public static final String COLUMNA_PREGUNTA = "pregunta";
        public static final String COLUMNA_OPCION1 = "option1";
        public static final String COLUMNA_OPCION2 = "option2";
        public static final String COLUMNA_OPCION3 = "option3";
        public static final String COLUMNA_CANTIDAD_TIEMPO = "cantidad_tiempo";
        public static final String COLUMNA_NUM_ACIERTOS = "num_aciertos";

    }
}