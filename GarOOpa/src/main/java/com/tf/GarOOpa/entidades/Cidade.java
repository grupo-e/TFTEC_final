package com.tf.GarOOpa.entidades;
import java.util.*;

public class Cidade {

    private String nome;
    private List<Bairro> bairros = new LinkedList<>();

    public Cidade(String nome, List<Bairro> bairros) {

        this.nome = nome;
        this.bairros = bairros;

    }

    public String getCidade() {

        return nome;

    }

    public List getBairros() {

        return bairros;

    }

}