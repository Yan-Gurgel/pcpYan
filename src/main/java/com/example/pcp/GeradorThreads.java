package com.example.pcp;

public class GeradorThreads {

    public void geracaoThread (String Genero){
        new Thread(Genero).start();
        System.out.println("Pessoa:" + Genero);

    }
}
