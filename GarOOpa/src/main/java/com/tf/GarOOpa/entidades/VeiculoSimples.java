package com.tf.GarOOpa.entidades;

public class VeiculoSimples implements Veiculo {
    private String placa;
    private String marca;
    private String cor;
    private Boolean bagG = false;
    private Boolean attCorrInf = false;
    
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

    public void setplaca(String placa) {

        this.placa = placa;

    }

    public void setcor(String cor) {

        this.cor = cor;

    }

    public void setmarca(String marca) {

        this.marca = marca;

    }

    public void setBagg(Boolean bag) {

        this.bagG = false;

    }
    
    public void setAtt(Boolean att) {

        this.attCorrInf = false;

    }

    @Override
    public void setAtt(boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBagg(boolean b) {
        // TODO Auto-generated method stub

    }

}
