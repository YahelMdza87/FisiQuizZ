package com.example.fisiquiz;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import android.database.Cursor;
import java.util.List;
import com.example.fisiquiz.ContrarrelojContract.*;
import com.example.fisiquiz.QuizContract.*;


public class ContrarrelojDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Fisiquiz.db";
    private static final int DATABASE_VERSION = 1;
    final String SQL_CREATE_TABLA_QUIZ = "CREATE TABLE " +
            PreguntasQuiz.NOMBRE_TABLA + " ( " +
            PreguntasQuiz.COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PreguntasQuiz.COLUMNA_PREGUNTA + " TEXT, " +
            PreguntasQuiz.COLUMNA_RESPUESTA + " TEXT " +
            ")";

    final String SQL_CREATE_TABLA_PREGUNTAS = "CREATE TABLE " +
            TablaPreguntas.NOMBRE_TABLA + " ( " +
            TablaPreguntas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TablaPreguntas.COLUMNA_PREGUNTA + " TEXT, " +
            TablaPreguntas.COLUMNA_OPCION1 + " TEXT, " +
            TablaPreguntas.COLUMNA_OPCION2 + " TEXT, " +
            TablaPreguntas.COLUMNA_OPCION3 + " TEXT, " +
            TablaPreguntas.COLUMNA_CANTIDAD_TIEMPO + " TEXT, " +
            TablaPreguntas.COLUMNA_NUM_ACIERTOS + " TEXT " +
            ")";

    private SQLiteDatabase db;

    public ContrarrelojDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        db.execSQL(SQL_CREATE_TABLA_QUIZ);
        db.execSQL(SQL_CREATE_TABLA_PREGUNTAS);
        fillPreguntasContrarreloj();
        fillPreguntasQuiz();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TablaPreguntas.NOMBRE_TABLA);
        db.execSQL(TablaPreguntas.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + PreguntasQuiz.NOMBRE_TABLA);
        db.execSQL(PreguntasQuiz.NOMBRE_TABLA);
    }


    public void addPregunta(Integer num, String pregunta, String opcion1, String opcion2, String opcion3, String cantidad_tiempo, String respuestaCorrecta){
        db = getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO "+ TablaPreguntas.NOMBRE_TABLA + " VALUES('"+num+"','"+pregunta+"','"+opcion1+"','"+opcion2+"','"+opcion3+"','"+cantidad_tiempo+"','"+respuestaCorrecta+"')");
            db.close();
        }
    }
    private void fillPreguntasContrarreloj() {
        Pregunta p1 = new Pregunta("Según la Segunda Ley de Newton, ¿a qué es proporcional la fuerza?", "A) A la aceleración", "B) Al peso", "C) A la velocidad", 20000, 1);
        crearPreguntas(p1);
        Pregunta p2 = new Pregunta("¿Qué clase de movimiento describe un cuerpo sometido a ninguna fuerza?", "A)Describe un movimiento uniforme", "B) Describe un movimiento acelerado", "C)Describe un movimiento fisico", 20000, 1);
        crearPreguntas(p2);
        Pregunta p3 = new Pregunta("¿A qué es igual la masa por la aceleración?", "A)Tiempo", "B)Peso", "C)Fuerza", 15000, 3);
        crearPreguntas(p3);
        Pregunta p4 = new Pregunta("¿Cuál es la unidad de la masa en el sistema internacional?", "A)Kg", "B)g", "C)mg", 20000, 1);
        crearPreguntas(p4);
        Pregunta p5 = new Pregunta("El peso no depende de la masa del cuerpo. ¿Verdadero o falso o ninguno de los 2?", "A)Verdadero", "B)Falso", "C)Ninguno de los 2", 20000, 2);
        crearPreguntas(p5);
        Pregunta p6 = new Pregunta("¿Cuál es la unidad en el sistema internacional para medir el trabajo y la energía?", "A)El Newton", "B)El Joule", "C)El Hz", 20000, 2);
        crearPreguntas(p6);
        Pregunta p7 = new Pregunta("¿A qué tipo de movimiento se atribuye la velocidad angular?", "A)Plano inclinado", "B)Plano circular", "C)Movimiento Circular", 20000, 3);
        crearPreguntas(p7);
        Pregunta p8 = new Pregunta("¿Qué magnitud física se mide con la unidad Hercios(Hz) en el sistema internacional?", "A)El Tiempo", "B)El Joule", "C)La frecuencia", 20000, 3);
        crearPreguntas(p8);
        Pregunta p9 = new Pregunta("¿Cuál es la unidad en el sistema internacional para medir la longitud?", "A)Metro(m)", "B)Centimetros(cm)", "C)Pie(ft)", 20000, 1);
        crearPreguntas(p9);
        Pregunta p10 = new Pregunta("¿¿Dónde nació Isaac Newton??", "A)Noruega", "B)Inglaterra", "C)Escocia", 20000, 2);
        crearPreguntas(p10);
    }
    public void fillPreguntasQuiz () {
        PreguntaQuiz p1 = new PreguntaQuiz("Calcular la fuerza necesaria que se necesita aplicar a un mueble cuyo peso es de 450 N para poder deslizarlo a una velocidad constante horizontalmente, donde el coeficiente de fricción dinámico es de 0.43 .", "193.5N");
        crearPreguntasQuiz(p1);
        PreguntaQuiz p2 = new PreguntaQuiz("Sobre una caja de 1200 g de masa situado sobre en una mesa horizontal se aplica una fuerza de 15 N en la dirección del plano. Calcula la fuerza de rozamiento (fuerza de fricción) si: La caja adquiere una aceleración igual a 2,5 m/s2.", "12N");
        crearPreguntasQuiz(p2);
        PreguntaQuiz p3 = new PreguntaQuiz("Sobre una caja de 1200 g de masa situado sobre en una mesa horizontal se aplica una fuerza de 15 N en la dirección del plano. Calcula la fuerza de rozamiento (fuerza de fricción) si: La caja se mueve con velocidad constante. ", "15N");
        crearPreguntasQuiz(p3);
        PreguntaQuiz p4 = new PreguntaQuiz("Una fuerza le proporciona a la masa de 2,5 Kg. una aceleración de 1,2 m/s2. Calcular la magnitud de dicha fuerza en Newton", "3N");
        crearPreguntasQuiz(p4);
        PreguntaQuiz p5 = new PreguntaQuiz("¿Cuál es la fuerza necesaria para que un móvil de 1500 Kg., partiendo de reposo adquiera una rapidez de 2 m/s2 en 12 s?", "240N");
        crearPreguntasQuiz(p5);
        PreguntaQuiz p6 = new PreguntaQuiz("Calcular la masa de un cuerpo, que estando de reposo se le aplica una fuerza de 150 N durante 30 s, permitiéndole recorrer 10 m. ¿Qué rapidez tendrá al cabo de ese tiempo?", "7500Kg");
        crearPreguntasQuiz(p6);
        PreguntaQuiz p7 = new PreguntaQuiz("Calcular la masa de un cuerpo si al recibir una fuerza cuya magnitud de 350 N le produce una aceleración cuya magnitud es de 520 cm/s^2. Exprese el resultado en Kg (Unidad de masa del sistema internacional). ", "67.31Kg");
        crearPreguntasQuiz(p7);
        PreguntaQuiz p8 = new PreguntaQuiz("Determinar la magnitud de la fuerza que recibe un cuerpo de 45 kg, la cual le produce una aceleración cuya magnitud es de 5 m/s^2.", "225N");
        crearPreguntasQuiz(p8);
        PreguntaQuiz p9 = new PreguntaQuiz("Determinar la magnitud del peso de una persona cuya masa es de 90 kg.", "882N");
        crearPreguntasQuiz(p9);
        PreguntaQuiz p10 = new PreguntaQuiz("Calcular la masa de un sillón cuyo peso tiene una magnitud de 410 N", "41.836Kg");
        crearPreguntasQuiz(p10);
    }


    private void crearPreguntas(Pregunta pregunta) {
        ContentValues cv = new ContentValues();
        cv.put(TablaPreguntas.COLUMNA_PREGUNTA, pregunta.getPregunta());
        cv.put(TablaPreguntas.COLUMNA_OPCION1, pregunta.getOpcion1());
        cv.put(TablaPreguntas.COLUMNA_OPCION2, pregunta.getOpcion2());
        cv.put(TablaPreguntas.COLUMNA_OPCION3, pregunta.getOpcion3());
        cv.put(TablaPreguntas.COLUMNA_CANTIDAD_TIEMPO, pregunta.getCantidad_Tiempo());
        cv.put(TablaPreguntas.COLUMNA_NUM_ACIERTOS, pregunta.getNum_aciertos());

        db.insert(TablaPreguntas.NOMBRE_TABLA, null, cv);
    }

    private void crearPreguntasQuiz(PreguntaQuiz preguntaQuiz){
        ContentValues cvquiz = new ContentValues();
        cvquiz.put(PreguntasQuiz.COLUMNA_PREGUNTA, preguntaQuiz.getPreguntaquiz());
        cvquiz.put(PreguntasQuiz.COLUMNA_RESPUESTA, preguntaQuiz.getRespuesta());
        db.insert(PreguntasQuiz.NOMBRE_TABLA, null, cvquiz);
    }


    public List<PreguntaQuiz> getAllPreguntasQuiz(){
        List<PreguntaQuiz> ListaPreguntasQuiz = new ArrayList<>();
        db=getReadableDatabase();
        Cursor c2 = db.rawQuery("SELECT * FROM " + PreguntasQuiz.NOMBRE_TABLA, null);
        if (c2.moveToFirst()){
            do {
                PreguntaQuiz preguntaQuiz = new PreguntaQuiz();
                preguntaQuiz.setPreguntaquiz(c2.getString(c2.getColumnIndex(PreguntasQuiz.COLUMNA_PREGUNTA)));
                preguntaQuiz.setRespuesta(c2.getString(c2.getColumnIndex(PreguntasQuiz.COLUMNA_RESPUESTA)));
                ListaPreguntasQuiz.add(preguntaQuiz);
            } while (c2.moveToNext());
        }
        c2.close();
        return ListaPreguntasQuiz;
    }
    public List<Pregunta> getAllPreguntas() {
        List<Pregunta> ListaPreguntas = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TablaPreguntas.NOMBRE_TABLA, null);

        if (c.moveToFirst()) {
            do {
                Pregunta pregunta = new Pregunta();
                pregunta.setPregunta(c.getString(c.getColumnIndex(TablaPreguntas.COLUMNA_PREGUNTA)));
                pregunta.setOpcion1(c.getString(c.getColumnIndex(TablaPreguntas.COLUMNA_OPCION1)));
                pregunta.setOpcion2(c.getString(c.getColumnIndex(TablaPreguntas.COLUMNA_OPCION2)));
                pregunta.setOpcion3(c.getString(c.getColumnIndex(TablaPreguntas.COLUMNA_OPCION3)));
                pregunta.setCantidad_Tiempo(c.getInt(c.getColumnIndex(TablaPreguntas.COLUMNA_CANTIDAD_TIEMPO)));
                pregunta.setNum_aciertos(c.getInt(c.getColumnIndex(TablaPreguntas.COLUMNA_NUM_ACIERTOS)));
                ListaPreguntas.add(pregunta);
            } while (c.moveToNext());
        }

        c.close();
        return ListaPreguntas;
    }
}