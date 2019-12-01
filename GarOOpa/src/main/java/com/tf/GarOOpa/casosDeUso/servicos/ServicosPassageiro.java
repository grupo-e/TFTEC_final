package com.tf.GarOOpa.casosDeUso.servicos;

import java.time.LocalTime;
import java.util.Random;

import com.tf.GarOOpa.entidades.Bairro;
import com.tf.GarOOpa.entidades.Cidade;
import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.Roteiro;
import com.tf.GarOOpa.entidades.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicosPassageiro {
    private RepositorioCidades cidades;
    private RepositorioBairros bairros;
    private RepositorioMotorista motoristas;
    
    @Autowired
    public ServicosPassageiro(RepositorioCidades cidades,
                              RepositorioBairros bairros,
                              RepositorioMotorista motoristas){
        this.cidades = cidades;
        this.bairros = bairros;
        this.motoristas = motoristas;
    }

    public Viagem criarViagem(String cpf,String bOrigem,String bDestino,String formaPagamento,String catVeiculo, String cidadeS) {

        LocalTime data_hora = LocalTime.now();
        Random r = new Random();
        int identificador = r.nextInt((1000000 - 1) + 1) + 1;
        Cidade cidade = cidades.getCidade(cidade);
        Bairro bairroOrigem = bairros.getBairro(cidadeS,bOrigem); 
        Bairro bairroDestino = bairros.getBairro(cidadeS,bDestino);
        Roteiro roteiro = new Roteiro(cidade, bairroOrigem, bairroDestino);

        return new Viagem(identificador, data_hora, roteiro);

    }

    // Ajusta pontuação do motorista em função de uma avaliação
    public boolean pontuarMotorista(String cpfMotorista,int avaliacao) {

        Motorista motorista = motoristas.getMoto(cpfMotorista);
        if (motorista!=null) {
        motorista.qtdAval++;
        motorista.somAval+=avaliacao;
            return true;
        } else
        return false;

    }
}
