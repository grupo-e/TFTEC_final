package com.tf.GarOOpa.casosDeUso.politicas;

import com.sun.tools.javac.util.List;
import com.tf.GarOOpa.entidades.*;
import java.util.*;


public class CalculaCustoLuxo implements CalculaCustoViagem {

    @Override
    public double custoViagem(java.util.List<Bairro> bairros) {
        double custoFinal;
        double taxaAdd = 1.1;
        double taxaBairro = 0.02;
        double custoBas = 0;
        int numBairros = bairros.size();

        for (int i = 0; i < bairros.size(); i++) {

            custoBas += bairros.get(i).getCustoBasico();
            
        }

        custoFinal = (taxaBairro*numBairros) + custoBas + custoBas*taxaAdd;
        return custoFinal;
    }

    @Override
    public double CalccustoViagem(String catVeiculo, java.util.List<Bairro> bairros) {
        
        double aux = 0;
        if(catVeiculo.toLowerCase() == "luxo") {
         
            aux = custoViagem(bairros);

        }else {

            return -1;

        }


        return aux;
    }
    
}