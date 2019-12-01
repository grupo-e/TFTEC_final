package com.tf.GarOOpa.entidades;

public class VeiculoFactory {

    String tipo;

    /*
    public VeiculoFactory(String tipo) {// ver isso

        this.tipo = tipo;

    }*/

    public static Veiculo getVeiculo(String tipoVeiculo){

        switch (tipoVeiculo) {

            case "veiculo luxo": return new VeiculoLuxo();
            case "veiculo normal": return new VeiculoNormal();
            case "veiculo simples": return new VeiculoSimples();
            default: return null;

        }
    }

}


