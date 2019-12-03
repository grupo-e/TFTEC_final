package com.tf.GarOOpa.WebService;

import java.util.List;

import com.tf.GarOOpa.casosDeUso.repositorios.*;
import com.tf.GarOOpa.casosDeUso.servicos.*;
import com.tf.GarOOpa.entidades.*;
import com.tf.GarOOpa.casosDeUso.politicas.*;
import com.tf.GarOOpa.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicoController {

    Fachada fachada;

    private CalculaCustoViagem custoViagem;
    private SelecaoMotorista selecaoMotorista;
    private RepositorioCidades cidades;
    private RepositorioBairros repoBairro;
    private RepositorioPassageiro repoPassa;
    private RepositorioViagens repoVia;
    private RepositorioMotoristas motoristas;
    private ServicosPassageiro svrPassa;
    private ServicoMotorista svrMoto;

    @Autowired
    public ServicoController(CalculaCustoViagem custoViagem,SelecaoMotorista selecaoMotorista,RepositorioCidades cidades,RepositorioBairros bairros, RepositorioPassageiro repoPassa,RepositorioMotoristas repoMoto, RepositorioViagens repoVia) {

        fachada = new Fachada(custoViagem, selecaoMotorista, cidades, bairros, repoPassa, motoristas, repoVia);

    }

    public void solicitaVeiculoParaViagem(String cpf,String cidadeaux,String bairroOrigem,String bairroDestino,String formaPagamento,String catVeiculo) {
        
         fachada.solicitaVeiculoParaViagem(cpf, cidadeaux, bairroOrigem, bairroDestino, formaPagamento, catVeiculo);
    }

    public boolean informaPontuacaoMotorista(String cpf) {
        
        return fachada.informaPontuacaoMotorista(cpf);
        
    }

    public List<Viagem> recuperaViagensDoMotorista(String cpfMotorista){
        return fachada.recuperaViagensDoMotorista(cpfMotorista);
    }

    public boolean informaPontuacaoPassageiro(String cpfPassageiro){
       return fachada.informaPontuacaoPassageiro(cpfPassageiro);
    }
    
}