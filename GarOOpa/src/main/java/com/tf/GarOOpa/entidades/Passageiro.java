package com.tf.GarOOpa.entidades;
public class Passageiro{
    private String cpf;
    private String nome;
    public int somAval;
    public int qtdAval;

    public Passageiro(String cpf, String nome, int somAval, int qtdAval){
        this.cpf=cpf;
        this.nome=nome;
        this.somAval=somAval;
        this.qtdAval=qtdAval;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public String getNome(){
        return nome;
    }    


    public int getSomAval(){
        return somAval;
    }    

    public int getQtdAval(){
        return qtdAval;
    }       
}
