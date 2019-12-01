package com.tf.GarOOpa.entidades;

public class VeiculoSimples implements Veiculo {
    private String placa;
    private String marca;
    private String cor;
    
    /*
    public VeiculoSimples(String placa, String marca, String cor) {

        this.placa = placa;
        this.marca = marca;
        this.cor = cor;

    }*/

    @Override
    public String getPlaca(){return placa;}

    @Override
    public String getMarca(){return marca;}

    @Override
    public String getCor(){return cor;}

    @Override
    public Boolean atendeCorridaInferior(){return false;}

    @Override
    public Boolean bagageiroGrande(){return false;}

}
