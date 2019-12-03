package com.tf.GarOOpa.entidades;

public interface Veiculo {

    public String getPlaca();

    public String getMarca();

    public String getCor();

    public Boolean atendeCorridaInferior();

    public Boolean bagageiroGrande();

    public void setplaca(String placa);

    public void setcor(String cor);

    public void setmarca(String marca);

	public void setAtt(boolean b);

	public void setBagg(boolean b);

    
    
}
