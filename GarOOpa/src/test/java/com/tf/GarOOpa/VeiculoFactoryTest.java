package com.tf.GarOOpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tf.GarOOpa.entidades.VeiculoFactory;
import com.tf.GarOOpa.entidades.geometria.SituacaoReta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VeiculoFactoryTest {

    VeiculoFactory vf;

    @BeforeEach
    private void setup() {
        
        vf = new VeiculoFactory();

    }
    @DisplayName("Classifica retas")
    @ParameterizedTest
    @CsvSource({"Luxo, VeiculoLuxo",
                "Normal, VeiculoNormal",
                "Simples, VeiculoSimples",
                "Luxo, VeiculoSimples",
                "Luxo, VeiculoNormal",
                "Normal, VeiculoSimples",
                "Normal, VeiculoLuxo",
                "Simples, VeiculoNormal",
                "Simples, VeiculoLuxo"            
                })
    public void getVeiculoTest(String tipo,SituacaoReta rEsp) {
               
        assertEquals(rEsp,vf.getVeiculo(tipo));

    }

}