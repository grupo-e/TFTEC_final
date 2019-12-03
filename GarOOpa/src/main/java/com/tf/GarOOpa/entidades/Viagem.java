package com.tf.GarOOpa.entidades;
import java.time.LocalTime;

public class Viagem {
    private int identificador;
    private LocalTime data_hora;
    private Roteiro roteiro;
    private Motorista motorista;
    private Passageiro passageiro;
    private double custo;

    public Viagem(int identificador, LocalTime data_hora, Roteiro roteiro){
        this.identificador=identificador;
        this.data_hora=data_hora;
        this.roteiro=roteiro;
        this.motorista=motorista;
        this.custo=custo;
    }

    public int getIdentificador(){
        return identificador;
    } 

    public LocalTime getData(){
        return data_hora;
    }  

    public Roteiro getRoteiro(){
        return roteiro ;
    }   

    public Motorista getMotorista(){
        return motorista;
    }   

    public Passageiro getPassageiro(){
        return passageiro;
    }   

    public double getCusto(){//ver isso aqui
        return custo;
    }   
    
}