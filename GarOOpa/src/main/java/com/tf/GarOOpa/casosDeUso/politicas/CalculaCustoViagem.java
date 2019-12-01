package com.tf.politicas;

import com.tf.entidades.Roteiro;

public interface CalculaCustoViagem {

    public double custoViagem(int numBairros, Roteiro roteiro);

}