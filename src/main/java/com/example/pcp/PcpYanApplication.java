package com.example.pcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class PcpYanApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(PcpYanApplication.class, args);

        int numPessoas;
        int numeroBox;
        Scanner ler = new Scanner(System.in);
        System.out.print("Insira o número de generos: ");
        numPessoas = ler.nextInt();
        System.out.print("Insira o número de box: ");
        numeroBox = ler.nextInt();

        ArrayList<String> filaEspera = new ArrayList();
        GeradorGeneros gerar = new GeradorGeneros();
        filaEspera = gerar.generos(numPessoas);

//        for (int i =0 ; i<filaEspera.size(); i++){
//            System.out.println("Fila Geral: "+filaEspera.get(i));
//        }

        ArrayList<String> filaGeneroA = new ArrayList();
        ArrayList<String> filaGeneroB = new ArrayList();
        ArrayList<String> filaGeneroC = new ArrayList();

        GeradorThreads iniciar = new GeradorThreads();

        Pessoa pessoa = new Pessoa();

        for (int i = 0; i < filaEspera.size(); i++) {
            pessoa = (Pessoa) iniciar.geracaoThread(filaEspera.get(i), i);
            System.out.println("Pessoa : " + pessoa.getGenero() + ", ID: " + pessoa.getID() + ", Entrada: " + pessoa.getTempoEntradaFila());
        }

        ler.nextInt();

    }// FIM MAIN

    
}
