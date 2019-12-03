package com.tf.GarOOpa.entidades;

public class VeiculoNormal implements Veiculo {
    private String placa;
    private String marca;
    private String cor;
    private Boolean attCorrInf;
    private Boolean bagG = false;

    @Override
    public String getPlaca(){return placa;}

    @Override
    public String getMarca(){return marca;}

    @Override
    public String getCor(){return cor;}

    @Override
    public Boolean atendeCorridaInferior(){return attCorrInf;}

    @Override
    public Boolean bagageiroGrande(){return false;}
    
    @Override
    public void setplaca(String placa) {

        this.placa = placa;

    }
    @Override
    public void setcor(String cor) {

        this.cor = cor;

    }
    @Override
    public void setmarca(String marca) {

        this.marca = marca;

    }
  
    @Override
    public void setAtt(boolean b) {
        // TODO Auto-generated method stub
        this.attCorrInf = b;

    }

    @Override
    public void setBagg(boolean b) {
        // TODO Auto-generated method stub

    }
}

