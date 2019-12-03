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
   

    /*
    public void writerViagem(Viagem viagem){

    FileWriter writer = new FileWriter("viagens.csv");
    for(int i=0;i<viagens.size();i++){
    writer.append(Integer.toString(viagem.getIdentificador()));
    writer.append(',');
    writer.append(viagem.getData().toString());
    writer.append(',');
    writer.append(Integer.toString(viagem.getSomA()));
    writer.append(',');
    writer.append(viagem.getQtdAval());
    writer.append("\n");

    writer.flush();
    writer.close();

    }
}*/

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
