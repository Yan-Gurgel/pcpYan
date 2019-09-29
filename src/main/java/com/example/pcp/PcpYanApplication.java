package com.example.pcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class PcpYanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcpYanApplication.class, args);

        int numPessoas;
        int numeroBox;
        Scanner ler = new Scanner(System.in);
        System.out.print("Insira o número de pessoas: ");
        numPessoas = ler.nextInt();
        System.out.print("Insira o número de box: ");
        numeroBox = ler.nextInt();

        ArrayList<String> filaEspera = new ArrayList();
        GeradorPessoas gerar = new GeradorPessoas();
        filaEspera = gerar.pessoas(numPessoas);


        GeradorThreads iniciar = new GeradorThreads();

		for (int i = 0; i < filaEspera.size(); i++) {
		    iniciar.geracaoThread(filaEspera.get(i));
		}

      
	}// FIM MAIN


//		Scanner ler = new Scanner(System.in);
//		int numPessoas;
//		int numeroBox;
//
//		System.out.print("Insira o número de pessoas: ");
//		numPessoas = ler.nextInt();
//		System.out.print("Insira o número de box: ");
//		numeroBox = ler.nextInt();

//		ArrayList<String> filaEspera = new ArrayList();
//		GeradorPessoas gerar = new GeradorPessoas();
//		filaEspera = gerar.pessoas(numPessoas);

//		System.out.println("fila de espera");
//		for (int i = 0; i < filaEspera.size(); i++) {
//			System.out.println(filaEspera.get(i));
//		}
//	}




    private static Runnable filaThread = new Runnable() {
        @Override
        public void run() {

        }
    };
}
