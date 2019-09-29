package com.example.pcp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GeradorPessoas {


    public ArrayList pessoas(int numPessoas) {

        //genero deve ser gerado aleatório mas no final a quantidade para os 3 deve ser a mesma
        int qdtGeneroA = numPessoas / 3;
        int qdtGeneroB = numPessoas / 3;
        int qdtGeneroC = numPessoas / 3;

        //Criando fila de generos com quantidades iguais
        ArrayList<String> fila = new ArrayList();
        for (int i = 0; i < qdtGeneroA; i++) {
            fila.add("GeneroA");
        }
        for (int j = 0; j < qdtGeneroB; j++) {
            fila.add("GeneroB");
        }
        for (int k = 0; k < qdtGeneroC; k++) {
            fila.add("GeneroC");
        }

        //Embaralhando a fila
        Collections.shuffle(fila);

        return fila;

    }
}