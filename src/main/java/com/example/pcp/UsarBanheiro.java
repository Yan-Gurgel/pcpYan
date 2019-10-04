package com.example.pcp;

import java.util.ArrayList;

public class UsarBanheiro extends Thread {

    public void banheiro(ArrayList<Pessoa> filaGeneroA, ArrayList<Pessoa> filaGeneroB, ArrayList<Pessoa> filaGeneroC,
                         Pessoa[] banheiro, int totalPessoas, int numBox) throws InterruptedException {
        int usoBanheiro = 0;
        int qtdBoxesLivre = numBox;
        String generoUsandoBanheiro = "Livre";
        String ultimoGeneroUsou = "Livre";

        while (usoBanheiro < totalPessoas) {


            if (qtdBoxesLivre > 0) {

                Pessoa pessoaGeneroA = filaGeneroA.get(0);
                Pessoa pessoaGeneroB = filaGeneroB.get(0);
                Pessoa pessoaGeneroC = filaGeneroC.get(0);
                Pessoa prioridade;
                prioridade = verificarPrioridade(pessoaGeneroA, pessoaGeneroB, pessoaGeneroC);
                System.out.println("Prioridade " + prioridade.getGenero());
                ArrayList<Pessoa> filaPrioritaria = new ArrayList<>();
                filaPrioritaria = retornarFilaPrioritaria(filaGeneroA, filaGeneroB, filaGeneroC, prioridade);
                System.out.println("Fila Prioritaria " + filaPrioritaria.get(0).getGenero());
                for(int i=0; i<qtdBoxesLivre; i++){
                    filaPrioritaria.remove(i);
                }
            }
        }


        //System.out.println("Prioridade: " + prioridade + prioridade.getGenero());
        usoBanheiro++;
    }


//        for (int i = 0; i < filaGeneroA.size(); i++) {
//            System.out.println("Pessoa : " + filaGeneroA.get(i).getGenero() + ", ID: " + filaGeneroA.get(i).getID());
//        }
//
//        for (int i = 0; i < filaGeneroB.size(); i++) {
//            System.out.println("Pessoa : " + filaGeneroB.get(i).getGenero() + ", ID: " + filaGeneroB.get(i).getID());
//        }
//
//        for (int i = 0; i < filaGeneroC.size(); i++) {
//            System.out.println("Pessoa : " + filaGeneroC.get(i).getGenero() + ", ID: " + filaGeneroC.get(i).getID());
//        }
//        System.out.println("Arrays manipulados");



    private ArrayList<Pessoa> retornarFilaPrioritaria(ArrayList<Pessoa> filaGeneroA, ArrayList<Pessoa> filaGeneroB, ArrayList<Pessoa> filaGeneroC, Pessoa prioridade) {
        ArrayList<Pessoa> filaPrioritaria = new ArrayList<>();
        if (filaGeneroA.get(0).getGenero().equals(prioridade.getGenero())) {
            filaPrioritaria = filaGeneroA;
        } else if (filaGeneroB.get(0).equals(prioridade.getGenero())) {
            filaPrioritaria = filaGeneroB;
        } else if (filaGeneroC.get(0).equals(prioridade.getGenero())) {
            filaPrioritaria = filaGeneroC;

        }
        return filaPrioritaria;
    }

    public Pessoa verificarPrioridade(Pessoa pessoaGeneroA, Pessoa pessoaGeneroB, Pessoa pessoaGeneroC) {
        int idA;
        int idB;
        int idC;
        if (pessoaGeneroA != null) {
            idA = pessoaGeneroA.getID();
        } else {
            idA = 1000;
        }


        if (pessoaGeneroB != null) {
            idB = pessoaGeneroB.getID();
        } else {
            idB = 1000;
        }

        if (pessoaGeneroC != null) {
            idC = pessoaGeneroC.getID();
        } else {
            idC = 1000;
        }

        Pessoa maiorPrioridade = new Pessoa();
        if (idA < idB & idA < idC) {
            maiorPrioridade = pessoaGeneroA;
        } else if (idB < idA & idB < idC) {
            maiorPrioridade = pessoaGeneroB;
        } else if (idC < idA & idC < idB) {
            maiorPrioridade = pessoaGeneroC;
        }
        return maiorPrioridade;
    }
}
