package com.tf.GarOOpa.casosDeUso.politicas;

import java.util.List;

import com.tf.GarOOpa.casosDeUso.repositorios.RepositorioCidades;
import com.tf.GarOOpa.casosDeUso.repositorios.RepositorioMotoristas;
import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.*;

public class SelecaoMotorista {

    RepositorioMotoristas repoMoto;

    public SelecaoMotorista(RepositorioMotoristas repoMoto){

        this.repoMoto = repoMoto;

    }

    public Motorista selecionaMotoristaParaViagem(List<Bairro> bairros,String catVeiculo){

        List<Motorista> lstMoto = repoMoto.getMotoristas();
        Motorista moto;

        for (int i = 0; i < lstMoto.size(); i++) {
            
            if(lstMoto.get(i).getVeiculo().getClass().toString().equals(catVeiculo)) {

                moto = lstMoto.get(i);
                return moto;

            }

        }
        
        return null;


    }

}