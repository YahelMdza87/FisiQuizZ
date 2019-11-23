package com.example.fisiquiz;

public class PreguntaQuiz {
    private String preguntaquiz;
    private String respuesta;
    public PreguntaQuiz(){

    }

    public PreguntaQuiz(String preguntaquiz, String respuesta) {
        this.preguntaquiz = preguntaquiz;
        this.respuesta = respuesta;
    }

    public String getPreguntaquiz() {
        return preguntaquiz;
    }

    public void setPreguntaquiz(String preguntaquiz) {
        this.preguntaquiz = preguntaquiz;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
