import com.tf.GarOOpa.entidades.Passageiro;


public interface IRepositorioPassageiro {

    Passageiro recuperaPorCpf(String cpf);

   public void atualizarPassageiro(Passageiro passageiro);
    
   
}