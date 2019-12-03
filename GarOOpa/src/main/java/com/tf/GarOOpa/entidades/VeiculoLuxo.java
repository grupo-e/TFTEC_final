package com.tf.GarOOpa.entidades;

public class VeiculoLuxo implements Veiculo{

    private String placa;
    private String marca;
    private String cor;
    private Boolean attCorrInf;
    private Boolean bagG;


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

    public void setplaca(String placa) {

        this.placa = placa;

    }

    public void setcor(String cor) {

        this.cor = cor;

    }

    public void setmarca(String marca) {

        this.marca = marca;

    }

    @Override
    public void setAtt(boolean b) {
        // TODO Auto-generated method stub
        this.attCorrInf = attCorrInf;

    }

    @Override
    public void setBagg(boolean b) {
        // TODO Auto-generated method stub
        this.bagG = b;

    }

}
