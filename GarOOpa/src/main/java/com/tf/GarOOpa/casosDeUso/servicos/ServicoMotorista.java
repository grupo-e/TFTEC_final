package com.tf.GarOOpa.casosDeUso.servicos;

import java.util.List;

import com.tf.GarOOpa.casosDeUso.repositorios.*;
import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.Passageiro;
import com.tf.GarOOpa.entidades.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoMotorista {

    RepositorioViagens viagemRepo;
    RepositorioPassageiro passaRepo;
    RepositorioMotoristas motoRepo;

    @Autowired
    public ServicoMotorista (RepositorioViagens viagemRepo, RepositorioPassageiro passaRepo, RepositorioMotoristas motoRepo) {
        this.viagemRepo = viagemRepo;    
        this.passaRepo = passaRepo;
        this.motoRepo = motoRepo;

    }

    public List<Viagem> viagensPassadas(String cpf) {

        Motorista moto = motoRepo.recuperaPorCpf(cpf);
        return viagemRepo.getViagem(moto);

    }

    public Boolean pontuarPassageiro(String cpfPassageiro, int aval) {

        Passageiro passa = passaRepo.recuperaPorCpf(cpfPassageiro); 
        if (passa != null ) {
            passa.somAval += aval;
            passa.qtdAval++;
            return true;
        }else
            return false;

    }

}

