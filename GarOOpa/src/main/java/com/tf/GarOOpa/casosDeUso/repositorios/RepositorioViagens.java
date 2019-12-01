package com.tf.GarOOpa.casosDeUso.repositorios;

import java.util.LinkedList;
import java.util.List;

import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.Viagem;

public class RepositorioViagens {

    private List<Viagem> viagens;
    public void cadastrarViagem(Viagem umaViagem) {

        //writer

    }
    public void lerViagem(Viagem umaViagem) {

        //leitor

    }
    public List<Viagem> getViagem(Motorista motorista) {

        List<Viagem> lst = new LinkedList<>();

        for(int i = 0; i<viagens.size();i++) {

            Viagem viagem = viagens.get(i);
            if (viagem.getMotorista() == motorista) {

                lst.add(viagem);

            }

        }

        return lst;

    }

}