package com.tf.GarOOpa.casosDeUso.politicas;

import com.tf.GarOOpa.entidades.Roteiro;

public class CalculaCustoSimples implements CalculaCustoViagem {

    @Override
    public double custoViagem(int numBairros, Roteiro roteiro) {
    
        double custoFinal;
        double custoBas = roteiro.getBairroDestino().getCustoBasico()+roteiro.getBairroOrigem().getCustoBasico();
        custoFinal = custoBas;
        return custoFinal;


    }

}