package com.tf.GarOOpa.casosDeUso.repositorios;

import java.util.LinkedList;
import com.tf.GarOOpa.entidades.*;
import com.tf.GarOOpa.entidades.geometria.*;
import java.util.*;
import java.io.*;

public class RepositorioBairros {

    List<Bairro> bairro = new LinkedList<>();
    String pessoa [] = new String [2000];
    String bairros[] = new String [2000];
    String precos[] = new String [2000];
    String pse[] = new String [2000];
    String pid[] = new String [2000];

    public void readerBairros(){
       
        String csvFile = "C:/Users/18106147/Desktop/TFTec-1/por favor funciona/src/sample/passageiros.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
                pessoa = line.split(csvSplitBy);
                bairros = pessoa[1].split(",");
                precos = pessoa[2].split(",");
                pse = pessoa[3].split(".");
                pid = pessoa[4].split(".");

                for (int i = 0; i < bairros.length; i++) {

                    Ponto ppse = new Ponto(Integer.parseInt(pse[i].split(",")[0]),Integer.parseInt(pse[i].split(",")[1]));
                    Ponto ppid = new Ponto(Integer.parseInt(pid[i].split(",")[0]),Integer.parseInt(pid[i].split(",")[1]));
                    Area area = new Area(ppse,ppid);
                    bairro.add(new Bairro(bairros[i],Integer.parseInt(precos[i]),area));
                    
                }
                
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

}