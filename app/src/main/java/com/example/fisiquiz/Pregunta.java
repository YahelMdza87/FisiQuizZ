package com.example.fisiquiz;

public class Pregunta {
    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private int cantidad_Tiempo;
    private int Num_aciertos;

    public Pregunta (){

    }

    public Pregunta(String pregunta, String opcion1, String opcion2, String opcion3, int cantidad_Tiempo, int num_aciertos) {
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.cantidad_Tiempo = cantidad_Tiempo;
        Num_aciertos = num_aciertos;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public int getCantidad_Tiempo() {
        return cantidad_Tiempo;
    }

    public void setCantidad_Tiempo(int cantidad_Tiempo) {
        this.cantidad_Tiempo = cantidad_Tiempo;
    }
    //

    public int getNum_aciertos() {
        return Num_aciertos;
    }

    public void setNum_aciertos(int num_aciertos) {
        Num_aciertos = num_aciertos;
    }
}
