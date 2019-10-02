package com.example.pcp;

public class Pessoa extends Thread {
    private int ID;
    private String horaEntradaFila;
    private String horaSaidaFila;
    private String genero;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHoraEntradaFila() {
        return horaEntradaFila;
    }

    public void setHoraEntradaFila(String horaEntradaFila) {
        this.horaEntradaFila = horaEntradaFila;
    }

    public String getHoraSaidaFila() {
        return horaSaidaFila;
    }

    public void setHoraSaidaFila(String horaSaidaFila) {
        this.horaSaidaFila = horaSaidaFila;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
