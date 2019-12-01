package com.tf.GarOOpa.casosDeUso.servicos;

import java.util.List;

import com.tf.GarOOpa.casosDeUso.repositorios.RepositorioViagens;
import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.Passageiro;
import com.tf.GarOOpa.entidades.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoMotorista {

    RepositorioViagens viagemRepo;
    RepositorioPassageiro passaRepo;
    RepositorioMotorista motoRepo;

    @Autowired
    public ServicoMotorista (RepositorioViagens viagemRepo, RepositorioPassageiro passaRepo, RepositorioMotorista motoRepo) {
        this.viagemRepo = viagemRepo;    
        this.passaRepo = passaRepo;
        this.motoRepo = motoRepo;

    }

    public List<Viagem> viagensPassadas(String cpf) {

        Motorista moto = motoRepo.getMoto(cpf);
        return viagemRepo.getViagem(moto);

    }

    public Boolean pontuarPassageiro(String cpfPassageiro, int aval) {

        Passageiro passa = passaRepo.getPassageiro(cpfPassageiro); 
        if (passa != null ) {
            passa.somAval += aval;
            passa.qtdAval++;
            return true;
        }else
            return false;

    }

}

