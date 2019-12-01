package com.tf.politicas;

import com.tf.entidades.Roteiro;

public class CalculaCustoSimples implements CalculaCustoViagem {

    @Override
    public double custoViagem(int numBairros, Roteiro roteiro) {
    
        double custoFinal;
        double custoBas = roteiro.getBairroDestino().getCustoBasico();
        custoFinal = custoBas;
        return custoFinal;


    }

}