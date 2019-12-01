package com.tf.GarOOpa.casosDeUso.servicos;

import com.tf.GarOOpa.entidades.Motorista;
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

    public Viagem criarViagem(String cpf,
                              String bairroOrigem,
                              String bairroDestino,
                              String formaPagamento,
                              String catVeiculo) {
        return new Viagem(cpf, bairroOrigem, bairroDestino, formaPagamento, catVeiculo);

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
