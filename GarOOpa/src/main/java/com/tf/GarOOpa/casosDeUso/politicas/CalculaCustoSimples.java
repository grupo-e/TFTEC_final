package com.tf.GarOOpa.casosDeUso.politicas;

import com.tf.GarOOpa.entidades.Bairro;
import java.util.*;

public class CalculaCustoSimples implements CalculaCustoViagem {

    @Override
    public double custoViagem(List<Bairro> bairros) {
    
        double custoFinal;
        double custoBas = 0;

        for (int i = 0; i < bairros.size(); i++) {

            custoBas += bairros.get(i).getCustoBasico();
            
        }

        custoFinal = custoBas;
        return custoFinal;


    }

    @Override
    public double CalccustoViagem(String catVeiculo, List<Bairro> bairros) {
        double aux = 0;
        if(catVeiculo.toLowerCase() == "simples") {
         
            aux = custoViagem(bairros);

        }else {

            return -1;

        }


        return aux;
    }

}