package com.tf.politicas;

import com.tf.entidades.Roteiro;

public class CalculaCustoNormal implements CalculaCustoViagem {

    @Override
    public double custoViagem(int numBairros, Roteiro roteiro) {
       
        double taxaAdd = 1.1;
        double custoFinal;
        double custoBas = roteiro.getBairroDestino().getCustoBasico();
        custoFinal = custoBas + custoBas*taxaAdd;
        return custoFinal;


    }
    
}


