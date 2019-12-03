package com.tf.GarOOpa.casosDeUso.repositorios;

import java.util.LinkedList;
import java.util.List;
import java.io.*;
import com.tf.GarOOpa.entidades.*;

import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.Viagem;

public class RepositorioViagens {

    private List<Viagem> viagens = new LinkedList<>();
    public void cadastrarViagem(Viagem umaViagem) {

        viagens.add(umaViagem);

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
