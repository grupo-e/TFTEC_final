package com.tf.GarOOpa.entidades;

public class VeiculoLuxo implements Veiculo{

    private String placa;
    private String marca;
    private String cor;
    private Boolean attCorrInf;
    private Boolean bagG;

    /*
    public VeiculoLuxo(String placa, String marca, String cor) {

        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        attCorrInf = true;
        bagG = true;

    }*/


    @Override
    public String getPlaca(){return placa;}

    @Override
    public String getMarca(){return marca;}

    @Override
    public String getCor(){return cor;}

    @Override
    public Boolean atendeCorridaInferior(){return attCorrInf;}

    @Override
    public Boolean bagageiroGrande(){return bagG;}
}
