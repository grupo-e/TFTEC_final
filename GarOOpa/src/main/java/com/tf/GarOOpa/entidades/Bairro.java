package com.tf.GarOOpa.entidades;

import com.tf.GarOOpa.entidades.geometria.Area;

public class Bairro {
    private String nome;
    private int CustoBasico;
    private Area Limites;

    public Bairro (String Nome, int CustoBasico, Area Limites){
        this.nome = Nome;
        this.CustoBasico = CustoBasico;
        this.Limites = Limites;
    }

    public String getNome(){
        return nome;
    }

    public int getCustoBasico(){
        return CustoBasico;
    }

    public Area getLimites(){
        return Limites;
    }

}