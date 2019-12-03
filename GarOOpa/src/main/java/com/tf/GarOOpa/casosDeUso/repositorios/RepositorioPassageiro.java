package com.tf.GarOOpa.casosDeUso.repositorios;

import com.tf.GarOOpa.entidades.Passageiro;

import java.io.*;
import java.util.*;

public class RepositorioPassageiro {

    String pessoa[]=new String[2000];
    List<Passageiro> passageiros = new LinkedList<>();

    public void readerPassageiro(){

        String csvFile = "./passageiro.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";
        Passageiro motorista=null;
        passageiros.clear();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                pessoa = line.split(csvSplitBy);
                String cpf = pessoa[0];
                String nome = pessoa[1];
                int somAval = Integer.parseInt(pessoa[2]);
                int qtdAval = Integer.parseInt(pessoa[3]);

                passageiros.add(new Passageiro(cpf, nome, somAval, qtdAval));

            }
        

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
                } finally {
                     if (br != null) {
                        try {
                              br.close();
                         } catch (IOException e) {
                             e.printStackTrace();
                            }
                        }
        }


    }


     public Passageiro recuperaPorCpf(String cpf){
        
        Passageiro placeHolder = null;
        readerPassageiro();
        for (int i = 0; i < passageiros.size(); i++) {
            
            placeHolder = passageiros.get(i);
            if(placeHolder.getCpf().equals(cpf)) {

                return placeHolder;

            }

        }
        return placeHolder;

    }

   public void atualizarPassageiro(Passageiro passageiro){
   
        Passageiro placeHolder = null;
        for (int i = 0; i < passageiros.size(); i++) {

            placeHolder = passageiros.get(i);
            if (placeHolder.getCpf().equals(passageiro.getCpf()) && placeHolder.getNome().equals(passageiro.getNome())) {

               passageiros.remove(placeHolder);
               passageiros.add(passageiro);
                

            }
     }
        
}


    }

