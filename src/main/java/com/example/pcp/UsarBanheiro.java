package com.example.pcp;

import java.util.ArrayList;

public class UsarBanheiro {

    public void banheiro(ArrayList<Pessoa> filaGeneroA, ArrayList<Pessoa> filaGeneroB, ArrayList<Pessoa> filaGeneroC, Pessoa[] banheiro){

        for (int i = 0; i < filaGeneroA.size(); i++ ) {
            System.out.println("Pessoa : " + filaGeneroA.get(i).getGenero() + ", ID: " + filaGeneroA.get(i).getID());
        }

        for (int i = 0; i < filaGeneroB.size(); i++ ) {
            System.out.println("Pessoa : " + filaGeneroB.get(i).getGenero() + ", ID: " + filaGeneroB.get(i).getID());
        }

        for (int i = 0; i < filaGeneroC.size(); i++ ) {
            System.out.println("Pessoa : " + filaGeneroC.get(i).getGenero() + ", ID: " + filaGeneroC.get(i).getID());
        }




        System.out.println("Arrays manipulados");
    }
}
