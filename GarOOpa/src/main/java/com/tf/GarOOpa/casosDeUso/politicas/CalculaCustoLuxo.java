package com.tf.politicas;

import java.util.List;

import com.tf.entidades.Bairro;
import com.tf.entidades.Roteiro;

public class CalculaCustoLuxo implements CalculaCustoViagem {

    @Override
    public double custoViagem(int numBairros, Roteiro roteiro) {
        
        double taxaAdd = 1.1;
        double taxaBairro = 0.02;
        double custoFinal;
        double custoBas = roteiro.getBairroDestino().getCustoBasico();
        custoFinal = (taxaBairro*numBairros) + custoBas + custoBas*taxaAdd;
        return custoFinal;

    }
    
}