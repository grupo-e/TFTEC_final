package com.tf.GarOOpa.casosDeUso.repositorios;
import java.io.*;
import java.util.*;

import com.tf.GarOOpa.entidades.*;
import com.tf.GarOOpa.entidades.geometria.*;

public class RepositorioCidades {

    String pessoa [] = new String [2000];
    String bairros[] = new String [2000];
    String precos[] = new String [2000];
    String pse[] = new String [2000];
    String pid[] = new String [2000];
    String cidade[] = new String [2000];
    List<Bairro> bbairros = new LinkedList<>();
    List<Cidade> cccidade = new LinkedList<>();

    public void readerCidades(){
       
        String csvFile = "./cidades.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
                pessoa = line.split(csvSplitBy);

                cidade = pessoa[0].split(",");
                bairros = pessoa[1].split(",");
                precos = pessoa[2].split(",");
                pse = pessoa[3].split(".");
                pid = pessoa[4].split(".");

                for (int i = 0; i < bairros.length; i++) {

                    Ponto ppse = new Ponto(Integer.parseInt(pse[i].split(",")[0]),Integer.parseInt(pse[i].split(",")[1]));
                    Ponto ppid = new Ponto(Integer.parseInt(pid[i].split(",")[0]),Integer.parseInt(pid[i].split(",")[1]));
                    Area area = new Area(ppse,ppid);
                    bbairros.add(new Bairro(bairros[i],Integer.parseInt(precos[i]),area));
                    
                }
                
                Cidade ccidade = new Cidade(pessoa[0],bbairros);
                cccidade.add(ccidade);


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


    public Cidade getCidade(String cidade) {

        Cidade placeHolder = null;

        for (int i = 0; i < cccidade.size(); i++) {
            
            placeHolder = cccidade.get(i);
            if (placeHolder.getCidade().equals(cidade)) {

                return placeHolder;

            }

        }

        return placeHolder;

    }

    public Bairro getBairro(String cidadeS, String bairroS) {
     
        Bairro plcHolder = null;
        Cidade aux = getCidade(cidadeS);
        List<Bairro> auxx = aux.getBairros();
        for (int i = 0; i < auxx.size(); i++) {
            
            plcHolder = auxx.get(i);
            if (plcHolder.getNome().equals(bairroS)) {

                return plcHolder;

            }

        }
        return plcHolder;

    }

}