package com.tf.GarOOpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tf.GarOOpa.entidades.geometria.Area;
import com.tf.GarOOpa.entidades.geometria.Ponto;
import com.tf.GarOOpa.entidades.geometria.Reta;
import com.tf.GarOOpa.entidades.geometria.SituacaoReta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AreaTest{
    private Area area;

    @BeforeEach
    public void setup() {
        area = new Area(new Ponto(10,30),new Ponto(50,10));
    }

    /*@DisplayName("Classifica pontos")
    @ParameterizedTest
    @CsvSource({"30,40,1","30,20,0","30,0,2",
                "5,40,9","5,20,8","5,0,10",
                "55,40,5","55,20,4","55,0,6"})
    public void codPontoTest(int x,int y,byte rEsp) {
        byte observed = area.codificaPonto(new Ponto(x,y));
        assertEquals(rEsp,observed);
    }*/

    @DisplayName("Classifica retas")
    @ParameterizedTest
    @CsvSource({"15,20,35,20,TODA_DENTRO",
                "15,50,35,50,TODA_FORA",
                "15,5,35,5,TODA_FORA",
                "5,40,5,10,TODA_FORA",
                "55,40,55,5,TODA_FORA",
                "30,90,90,20,TODA_FORA",
                "-5,15,15,-20,TODA_FORA"
                })
    public void codRetaTest(int xi,int yi,int xf,int yf,SituacaoReta rEsp) {
        Reta reta = new Reta(new Ponto(xi,yi),new Ponto(xf,yf));
        SituacaoReta observed = area.classificaAlt(reta);
        assertEquals(rEsp,observed);
    }
}