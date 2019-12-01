package com.tf.GarOOpa.entidades;

public class Roteiro{
    private Cidade cidade;
    private Bairro borigem;
    private Bairro bdestino;

    public Roteiro(Cidade cidade, Bairro borigem, Bairro bdestino){
        this.cidade=cidade;
        this.borigem=borigem;
        this.bdestino=bdestino;
    }

    public Cidade getCidade(){
        return cidade;
    } 

    public Bairro getBairroOrigem(){
        return borigem;
    }

    public Bairro getBairroDestino(){
        return bdestino;
    }        
}