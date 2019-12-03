package com.tf.GarOOpa.entidades;
import java.util.List;
import com.tf.GarOOpa.entidades.geometria.*;

public class Roteiro{
    private Cidade cidade;
    private Bairro borigem;
    private Bairro bdestino;

    public Roteiro(Cidade cidade, Bairro borigem, Bairro bdestino){
        this.cidade=cidade;
        this.borigem=borigem;
        this.bdestino=bdestino;
    }

    public Cidade getCidade(){
        return cidade;
    } 

    public Bairro getBairroOrigem(){
        return borigem;
    }

    public Bairro getBairroDestino(){
        return bdestino;
    }  
    
    public List<Bairro> criarRoteiro(Cidade cidade, Bairro origem, Bairro destino) {

        List<Bairro> r = null;

        Ponto pOrigem = origem.getLimites().getPInfDir();
        Ponto pDestino = destino.getLimites().getPSupEsq();
        Reta r1 = new Reta(pOrigem, pDestino);
        List<Bairro> bairros = cidade.getBairros();
         
        for (int i = 0; i < bairros.size(); i++) {
            
            if (bairros.get(i).getLimites().classificaAlt(r1).equals(SituacaoReta.INTERSECTA) || bairros.get(i).getLimites().classificaAlt(r1).equals(SituacaoReta.TODA_DENTRO)) {

                r.add(bairros.get(i));

            }

        }


        
        return r;

    }
    
}