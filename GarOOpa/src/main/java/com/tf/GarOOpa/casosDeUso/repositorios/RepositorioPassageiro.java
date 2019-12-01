package com.tf.GarOOpa.casosDeUso.repositorios;

import com.tf.GarOOpa.entidades.Passageiro;

public interface RepositorioPassageiro {

    Passageiro recuperaPorCpf(String cpf);
    void atualizarPassageiro(Passageiro passageiro);

}