package com.example.pcp;

public class GeradorThreads extends Thread {


    public Thread geracaoThread(String Genero, int ID) throws InterruptedException {
        Pessoa pessoa = new Pessoa();
        pessoa.setGenero(Genero);
        pessoa.setID(ID);
        pessoa.setTempoEntradaFila(System.currentTimeMillis());
        //sleep(500);
        pessoa.start();
        return pessoa;
    }

}
