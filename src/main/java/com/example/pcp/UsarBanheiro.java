package com.example.pcp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UsarBanheiro extends Thread{


    public synchronized void banheiro(ArrayList<Pessoa> filaGeneroA, ArrayList<Pessoa> filaGeneroB, ArrayList<Pessoa> filaGeneroC,
                                      ArrayList<Pessoa> banheiro, int totalPessoas, int numBox) throws InterruptedException {
        int usoBanheiro = 0;
        int qtdBoxesLivre = numBox;
        String generoUsandoBanheiro = "Livre";
        String ultimoGeneroUsou = "Livre";

        DateFormat horaSaidaFila = new SimpleDateFormat("HH:mm:ss");
        Date hora = new Date();

        while (usoBanheiro < totalPessoas) {

            // PRIMEIRA condição: banheiro possui POSSUI TODOS os boxes livres
            if (qtdBoxesLivre == numBox) {
                generoUsandoBanheiro = "Livre";
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
                    if(filaPrioritaria.get(i) != null){
                        if (filaPrioritaria.get(i).getGenero().equals("GeneroA")) {
                            qtdBoxesLivre--;
                            filaGeneroA.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                            generoUsandoBanheiro = "GeneroA";
                            //pessoa entra no banheiro
                            banheiro.add(filaGeneroA.get(i));
                            //pessoa removida da fila
                            filaGeneroA.remove(i);
                            System.out.println("Pessoa de " + filaGeneroA.get(i).getGenero() + " usou o banheiro");

                        } else if (filaPrioritaria.get(i).getGenero().equals("GeneroB")) {
                            qtdBoxesLivre--;
                            filaGeneroB.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                            generoUsandoBanheiro = "GeneroB";
                            //pessoa entra no banheiro
                            banheiro.add(filaGeneroB.get(i));
                            //pessoa removida da fila
                            filaGeneroB.remove(i);
                            System.out.println("Pessoa de " + filaGeneroB.get(i).getGenero() + " usou o banheiro");

                        } else if (filaPrioritaria.get(i).getGenero().equals("GeneroC")) {
                            qtdBoxesLivre--;
                            filaGeneroC.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                            generoUsandoBanheiro = "GeneroC";
                            //pessoa entra no banheiro
                            banheiro.add(filaGeneroC.get(i));
                            //pessoa removida da fila
                            filaGeneroC.remove(i);
                            System.out.println("Pessoa de " + filaGeneroC.get(i).getGenero() + " usou o banheiro");
                        }
                        usoBanheiro++;
                        qtdBoxesLivre++;
                    }
                    sleep(5000);
                    banheiro.clear();
                }
            }
            // SEGUNDA condição: banheiro possui pelo menos um box em uso
            else if (qtdBoxesLivre > 0) {
                // System.out.println("BANHEIRO AINDA POSSUI PELO MENOS 1 GENERO");
                if (generoUsandoBanheiro.equals("GeneroA")) {
                    for (int i = 0; i < qtdBoxesLivre; i++) {
                        qtdBoxesLivre--;
                        filaGeneroA.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroA";
                        //pessoa entra no banheiro
                        banheiro.add(filaGeneroA.get(i));
                        System.out.println("Pessoa de " + filaGeneroA.get(i).getGenero() + " usou o banheiro");
                        //pessoa removida da fila
                        filaGeneroA.remove(i);

                    }
                } else if (generoUsandoBanheiro.equals("GeneroB")) {
                    for (int i = 0; i < qtdBoxesLivre; i++) {
                        qtdBoxesLivre--;
                        filaGeneroB.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroB";
                        //pessoa entra no banheiro
                        banheiro.add(filaGeneroB.get(i));
                        System.out.println("Pessoa de " + filaGeneroB.get(i).getGenero() + " usou o banheiro");
                        //pessoa removida da fila
                        filaGeneroB.remove(i);
                    }
                } else if (generoUsandoBanheiro.equals("GeneroC")) {
                    for (int i = 0; i < qtdBoxesLivre; i++) {
                        qtdBoxesLivre--;
                        filaGeneroC.get(i).setHoraSaidaFila(horaSaidaFila.format(hora));
                        generoUsandoBanheiro = "GeneroC";
                        //pessoa entra no banheiro
                        banheiro.add(filaGeneroC.get(i));
                        System.out.println("Pessoa de " + filaGeneroC.get(i).getGenero() + " usou o banheiro");
                        //pessoa removida da fila
                        filaGeneroC.remove(i);

                    }
                    usoBanheiro++;
                    qtdBoxesLivre++;
                }
                sleep(5000);
                banheiro.clear();
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
