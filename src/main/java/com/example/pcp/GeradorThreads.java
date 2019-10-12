package com.example.pcp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeradorThreads extends Thread {

    public synchronized Thread geracaoThread(String Genero, int ID) throws InterruptedException {

        //tempo de 1-7 segundos para pessoa chegar a fila
        int tempo = (int) (1000 + Math.random() * 7000);

        DateFormat horaEntradaFila = new SimpleDateFormat("HH:mm:ss");
        Date hora = new Date();

        //Aplicação do Genero e ID
        Pessoa pessoa = new Pessoa();
        pessoa.setGenero(Genero);
        pessoa.setID(ID);
        //Aplicação do tempo de 1-7
        sleep(tempo);
        //Armazenar hora de entrada na fila
        pessoa.setHoraEntradaFila(horaEntradaFila.format(hora));

        System.out.println("\nPessoa: " + pessoa.getGenero() + " chegou na fila, hora: " + pessoa.getHoraEntradaFila());
        System.out.println("Próximo chega em: " + tempo/1000 + " segundos");

        pessoa.start();
        return pessoa;
    }
}
