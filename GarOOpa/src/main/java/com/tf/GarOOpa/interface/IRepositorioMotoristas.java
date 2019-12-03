import com.tf.GarOOpa.entidades.*;
public interface IRepositorioMotoristas {

    Motorista recuperaPorCpf(String cpf);

    public void atualizaMotorista(Motorista moto);


}