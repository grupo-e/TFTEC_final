package com.tf.GarOOpa.casosDeUso.repositorios;

import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.VeiculoFactory;
import com.tf.GarOOpa.entidades.Motorista.Pagamento;

import org.apache.tomcat.util.http.fileupload.DeferredFileOutputStream;

import com.tf.GarOOpa.entidades.*;

import java.io.*;
import java.util.*;

public class RepositorioMotoristas {

    String pessoa[]=new String[6];
    List<Motorista> motoristas = new LinkedList<>();

    public boolean cadastraMotorista (Motorista moto) {

        return  motoristas.add(moto);

    }

    public void readerMotorista(){

        String csvFile = "C:/Users/18106147/Desktop/TFTec-1/por favor funciona/src/sample/passageiros.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";
        Motorista motorista=null;
        motoristas.clear();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator

                pessoa = line.split(csvSplitBy);
                String nome = pessoa[1];
                String cpf = pessoa[0];
                int somaAval = Integer.parseInt(pessoa[2]);
                int qtdAval = Integer.parseInt(pessoa[3]);
                

                VeiculoFactory vf = new VeiculoFactory();
                Veiculo v1 = vf.getVeiculo(pessoa[4]);

                if (pessoa[4] == "veiculo luxo") {

                    v1.setcor(pessoa[5]);
                    v1.setmarca(pessoa[6]);
                    v1.setplaca(pessoa[7]);
                    v1.setAtt(pessoa[8] == "1");
                    v1.setBagg(pessoa[9] == "1");

                }
                else if (pessoa[4] == "veiculo normal") {

                    v1.setcor(pessoa[5]);
                    v1.setmarca(pessoa[6]);
                    v1.setplaca(pessoa[7]);
                    v1.setAtt(pessoa[8] == "1");
                    
                }else {

                    v1.setcor(pessoa[5]);
                    v1.setmarca(pessoa[6]);
                    v1.setplaca(pessoa[7]);
                    
                }
                //motorista=new Motorista(pessoa[0],pessoa[1], Integer.valueOf(pessoa[2]),Integer.valueOf(pessoa[3]));
                String pagamento = pessoa[10];
                Pagamento paga;
                switch(pagamento) {

                    case "debito":{

                        paga = Pagamento.DEBITO;

                    }
                    case "credito":{

                        paga = Pagamento.CREDITO;

                    }
                    case "dinheiro":{

                        paga = Pagamento.DINHEIRO;

                    }
                    default: paga = null;

                }  

                motoristas.add(new Motorista(cpf, nome, somaAval, qtdAval, v1, paga));

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

    public Motorista recuperaPorCpf(String cpf){
        
        Motorista chosenOne = null;
        readerMotorista();

        for (int i = 0; i < motoristas.size(); i++) {
            
            if(motoristas.get(i).getCpf().equals(cpf)) {

                chosenOne = motoristas.get(i);

            }

        }

        return chosenOne;


    }

    public void atualizaMotorista(Motorista moto) {

        Motorista placeHolder = null;
        for (int i = 0; i < motoristas.size(); i++) {

            placeHolder = motoristas.get(i);
            if (placeHolder.getCpf().equals(moto.getCpf()) && placeHolder.getNome().equals(moto.getNome())) {

                motoristas.remove(placeHolder);
                motoristas.add(moto);

            }
        }
    }

    public List<Motorista> getMotoristas() {

        return motoristas;

    }
}