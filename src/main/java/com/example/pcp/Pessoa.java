package com.example.pcp;

public class Pessoa extends Thread {
    private int ID;
    private float tempoEntradaFila;
    private float tempoSaidaFila;
    private String genero;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getTempoEntradaFila() {
        return tempoEntradaFila;
    }

    public void setTempoEntradaFila(float tempoEntradaFila) {
        this.tempoEntradaFila = tempoEntradaFila;
    }

    public float getTempoSaidaFila() {
        return tempoSaidaFila;
    }

    public void setTempoSaidaFila(float tempoSaidaFila) {
        this.tempoSaidaFila = tempoSaidaFila;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
