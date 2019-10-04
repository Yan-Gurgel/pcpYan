package com.example.pcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class PcpYanApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(PcpYanApplication.class, args);

        //Variaveis de pessoas e quantidade de box de banheiro
        int numPessoas;
        int numeroBox;


        //Filas de cada genero
        ArrayList<Pessoa> filaGeneroA = new ArrayList();
        ArrayList<Pessoa> filaGeneroB = new ArrayList();
        ArrayList<Pessoa> filaGeneroC = new ArrayList();


        //Leitura e atribuição do numero de pessoas e box
        Scanner ler = new Scanner(System.in);
        System.out.print("Insira o número de generos: ");
        numPessoas = ler.nextInt();


        System.out.print("Insira o número de box: ");
        numeroBox = ler.nextInt();
        Pessoa[] banheiro;
        banheiro = new Pessoa[numeroBox];


        //Geração da fila de espera geral na ordem aleatória de generos
        ArrayList<String> filaEsperaGeral = new ArrayList();
        GeradorGeneros gerar = new GeradorGeneros();
        filaEsperaGeral = gerar.generos(numPessoas);


        //Geração das 3 filas de generos
        GeradorThreads iniciar = new GeradorThreads();
        for (int i = 0; i < filaEsperaGeral.size(); i++) {
            Pessoa pessoa;
            pessoa = (Pessoa) iniciar.geracaoThread(filaEsperaGeral.get(i), i);
            if (pessoa.getGenero().equals("GeneroA")) {
                filaGeneroA.add(pessoa);
            } else if (pessoa.getGenero().equals("GeneroB")) {
                filaGeneroB.add(pessoa);
            } else if (pessoa.getGenero().equals("GeneroC")) {
                filaGeneroC.add(pessoa);
            }
        }

        UsarBanheiro usar = new UsarBanheiro();
        usar.banheiro(filaGeneroA, filaGeneroB, filaGeneroC, banheiro, numPessoas, numeroBox);



//        //Conferindo as filas
//        for (int i = 0; i < filaGeneroA.size(); i++ ) {
//            System.out.println("Pessoa : " + filaGeneroA.get(i).getGenero() + ", ID: " + filaGeneroA.get(i).getID());
//        }
//
//        for (int i = 0; i < filaGeneroB.size(); i++ ) {
//            System.out.println("Pessoa : " + filaGeneroB.get(i).getGenero() + ", ID: " + filaGeneroB.get(i).getID());
//        }
//
//        for (int i = 0; i < filaGeneroC.size(); i++ ) {
//            System.out.println("Pessoa : " + filaGeneroC.get(i).getGenero() + ", ID: " + filaGeneroC.get(i).getID());
//        }

    }// FIM MAIN
}
