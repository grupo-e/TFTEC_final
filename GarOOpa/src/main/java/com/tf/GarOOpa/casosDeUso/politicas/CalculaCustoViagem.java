package com.tf.GarOOpa.casosDeUso.politicas;

import com.tf.GarOOpa.entidades.*;
import java.util.*;

public interface CalculaCustoViagem {

    double custoViagem(List<Bairro> bairros);
    double CalccustoViagem(String catVeiculo, List<Bairro> bairros);


}