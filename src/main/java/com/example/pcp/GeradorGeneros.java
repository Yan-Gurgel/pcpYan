package com.example.pcp;

import java.util.ArrayList;
import java.util.Collections;


public class GeradorGeneros {


    public ArrayList generos(int numPessoas) {

        //genero deve ser gerado aleatório mas no final a quantidade para os 3 deve ser a mesma
        int qdtGeneroA = numPessoas / 3;
        int qdtGeneroB = numPessoas / 3;
        int qdtGeneroC = numPessoas / 3;

        //Criando filaGeneros de generos com quantidades iguais
        ArrayList<String> filaGeneros = new ArrayList();
        for (int i = 0; i < qdtGeneroA; i++) {
            filaGeneros.add("GeneroA");
        }
        for (int j = 0; j < qdtGeneroB; j++) {
            filaGeneros.add("GeneroB");
        }
        for (int k = 0; k < qdtGeneroC; k++) {
            filaGeneros.add("GeneroC");
        }

        //Embaralhando a filaGeneros
        Collections.shuffle(filaGeneros);

        return filaGeneros;

    }
}