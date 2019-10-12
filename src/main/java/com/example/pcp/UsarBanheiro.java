package com.example.pcp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UsarBanheiro extends Thread {

    public synchronized void banheiro(ArrayList<Pessoa> filaGeneroA, ArrayList<Pessoa> filaGeneroB, ArrayList<Pessoa> filaGeneroC,
                         Pessoa[] banheiro, int totalPessoas, int numBox) throws InterruptedException {
        int usoBanheiro = 0;
        int qtdBoxesLivre = numBox;
        String generoUsandoBanheiro = "Livre";
        String ultimoGeneroUsou = "Livre";

        DateFormat horaSaidaFila = new SimpleDateFormat("HH:mm:ss");
        Date hora = new Date();

        while (usoBanheiro < totalPessoas) {
            if (qtdBoxesLivre == numBox){
                generoUsandoBanheiro = "Livre";
            }

            // PRIMEIRA condição: banheiro possui POSSUI TODOS os boxs livres
            if (qtdBoxesLivre == numBox) {
                System.out.println("---BANHEIRO COMPLETAMENTE VAZIO---");
                //verifica nas 3 filas a pessoa com maior prioridade
                Pessoa pessoaGeneroA = filaGeneroA.get(0);
                Pessoa pessoaGeneroB = filaGeneroB.get(0);
                Pessoa pessoaGeneroC = filaGeneroC.get(0);
                Pessoa prioridade;
                prioridade = verificarPrioridade(pessoaGeneroA, pessoaGeneroB, pessoaGeneroC);


                //retorna a fila com maior prioridade
                ArrayList<Pessoa> filaPrioritaria = new ArrayList<>();
                filaPrioritaria = retornarFilaPrioritaria(filaGeneroA, filaGeneroB, filaGeneroC, prioridade);

                for (int i = 0; i < qtdBoxesLivre; i++) {
                    if (filaPrioritaria.get(i).getGenero().equals("GeneroA")) {
                        qtdBoxesLivre--;
                        filaGeneroA.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroA";
                        sleep(5000);
                        System.out.println("Pessoa de " + filaGeneroA.get(i).getGenero() + " usou o banheiro");
                        filaGeneroA.remove(i);
                        usoBanheiro++;
                        qtdBoxesLivre++;
                    } else if (filaPrioritaria.get(i).getGenero().equals("GeneroB")) {
                        qtdBoxesLivre--;
                        filaGeneroB.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroB";
                        sleep(5000);
                        System.out.println("Pessoa de " + filaGeneroB.get(i).getGenero() + " usou o banheiro");
                        filaGeneroB.remove(i);
                        usoBanheiro++;
                        qtdBoxesLivre++;

                    } else if (filaPrioritaria.get(i).getGenero().equals("GeneroC")) {
                        qtdBoxesLivre--;
                        filaGeneroC.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroC";
                        sleep(5000);
                        System.out.println("Pessoa de " + filaGeneroC.get(i).getGenero() + " usou o banheiro");
                        filaGeneroC.remove(i);
                        usoBanheiro++;
                        qtdBoxesLivre++;

                    }
                }
            }
            // SEGUNDA condição: banheiro possui pelo menos um box em uso
            else if (qtdBoxesLivre > 0 & qtdBoxesLivre != numBox) {
                if (generoUsandoBanheiro.equals("GeneroA")) {
                    for (int i = 0; i < qtdBoxesLivre; i++) {
                        qtdBoxesLivre--;
                        filaGeneroA.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroA";
                        sleep(5000);
                        System.out.println("Pessoa de " + filaGeneroA.get(i).getGenero() + " usou o banheiro");
                        filaGeneroA.remove(i);
                        usoBanheiro++;
                        qtdBoxesLivre++;
                    }
                } else if (generoUsandoBanheiro.equals("GeneroB")) {
                    for (int i = 0; i < qtdBoxesLivre; i++) {
                        qtdBoxesLivre--;
                        filaGeneroB.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroB";
                        sleep(5000);
                        System.out.println("Pessoa de " + filaGeneroB.get(i).getGenero() + " usou o banheiro");
                        filaGeneroB.remove(i);
                        usoBanheiro++;
                        qtdBoxesLivre++;
                    }
                } else if (generoUsandoBanheiro.equals("GeneroC")) {
                    for (int i = 0; i < qtdBoxesLivre; i++) {
                        qtdBoxesLivre--;
                        filaGeneroC.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroC";
                        sleep(5000);
                        System.out.println("Pessoa de " + filaGeneroC.get(i).getGenero() + " usou o banheiro");
                        filaGeneroC.remove(i);
                        usoBanheiro++;
                        qtdBoxesLivre++;
                    }
                }
            }
        }



    }

    public ArrayList<Pessoa> retornarFilaPrioritaria(ArrayList<Pessoa> filaGeneroA, ArrayList<Pessoa> filaGeneroB, ArrayList<Pessoa> filaGeneroC, Pessoa prioridade) {
        ArrayList<Pessoa> filaPrioritaria = new ArrayList<>();
        if (prioridade.getGenero().equals("GeneroA")) {
            filaPrioritaria = filaGeneroA;
        } else if (prioridade.getGenero().equals("GeneroB")) {
            filaPrioritaria = filaGeneroB;
        } else if (prioridade.getGenero().equals("GeneroC")) {
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
