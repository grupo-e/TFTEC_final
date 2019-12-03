package com.tf.GarOOpa.WebService;

import java.util.List;

import com.tf.GarOOpa.casosDeUso.politicas.CalculaCustoViagem;
import com.tf.GarOOpa.casosDeUso.politicas.SelecaoMotorista;
import com.tf.GarOOpa.casosDeUso.repositorios.RepositorioBairros;
import com.tf.GarOOpa.casosDeUso.repositorios.RepositorioCidades;
import com.tf.GarOOpa.casosDeUso.repositorios.RepositorioMotoristas;
import com.tf.GarOOpa.casosDeUso.repositorios.RepositorioPassageiro;
import com.tf.GarOOpa.casosDeUso.repositorios.RepositorioViagens;
import com.tf.GarOOpa.casosDeUso.servicos.ServicoMotorista;
import com.tf.GarOOpa.casosDeUso.servicos.ServicosPassageiro;
import com.tf.GarOOpa.entidades.Bairro;
import com.tf.GarOOpa.entidades.Cidade;
import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.Passageiro;
import com.tf.GarOOpa.entidades.Roteiro;
import com.tf.GarOOpa.entidades.Veiculo;
import com.tf.GarOOpa.entidades.Viagem;

import org.springframework.stereotype.Component;

@Component
public class Fachada {
    private CalculaCustoViagem custoViagem;
    private SelecaoMotorista selecaoMotorista;
    private RepositorioCidades cidades;
    private RepositorioBairros repoBairro;
    private RepositorioPassageiro repoPassa;
    private RepositorioViagens repoVia;
    private RepositorioMotoristas motoristas;
    private ServicosPassageiro svrPassa;
    private ServicoMotorista svrMoto;

    public Fachada(CalculaCustoViagem custoViagem,SelecaoMotorista selecaoMotorista,RepositorioCidades cidades,RepositorioBairros bairros, RepositorioPassageiro repoPassa,RepositorioMotoristas motoristas,RepositorioViagens repoVia) {

        this.custoViagem = custoViagem;
        this.selecaoMotorista = selecaoMotorista;
        this.cidades = cidades;
        repoBairro = bairros;
        this.motoristas = motoristas;
        this.repoVia = repoVia;
        this.repoPassa = repoPassa;
        svrPassa = new ServicosPassageiro(cidades, bairros, motoristas);
        svrMoto = new ServicoMotorista(repoVia, repoPassa, motoristas);
    
        
    }

    // Roteiro completo de como criar uma viagem
    public void solicitaVeiculoParaViagem(String cpf,String cidadeaux,String bairroOrigem,String bairroDestino,String formaPagamento,String catVeiculo) {
        Passageiro passageiro = repoPassa.recuperaPorCpf(cpf);
        Cidade cidade = cidades.getCidade(cidadeaux);
        Bairro origem = cidades.getBairro(cidadeaux,bairroOrigem);
        Bairro destino = cidades.getBairro(cidadeaux,bairroDestino);
        Roteiro r = new Roteiro(cidade, origem, destino);
        List<Bairro> roteiro = r.criarRoteiro(cidade, origem, destino);
        Motorista motorista = selecaoMotorista.selecionaMotoristaParaViagem(roteiro,catVeiculo); 
        Veiculo veiculo = motorista.getVeiculo();
        double custo = custoViagem.CalccustoViagem(catVeiculo, roteiro);
        Viagem viagem =  svrPassa.criarViagem(cpf, bairroOrigem, bairroDestino, formaPagamento, catVeiculo, cidadeaux);
        repoVia.cadastrarViagem(viagem);
    }

    public boolean informaPontuacaoMotorista(String cpf) {
        
        Motorista moto = motoristas.recuperaPorCpf(cpf);

        if(moto!=null){
            System.out.println(moto.somAval/moto.qtdAval);
            return true;
        }else 
            return false;
    }

    public List<Viagem> recuperaViagensDoMotorista(String cpfMotorista){
        return svrMoto.viagensPassadas(cpfMotorista);
    }

    public boolean informaPontuacaoPassageiro(String cpfPassageiro){
        Passageiro passa = repoPassa.recuperaPorCpf(cpfPassageiro);

        if(passa!=null){
            System.out.println(passa.somAval/passa.qtdAval);
            return true;
        }else 
            return false;
    }
}
