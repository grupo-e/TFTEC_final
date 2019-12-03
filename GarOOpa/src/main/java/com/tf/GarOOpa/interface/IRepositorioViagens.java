
import java.util.LinkedList;
import java.util.List;

import com.tf.GarOOpa.entidades.Motorista;
import com.tf.GarOOpa.entidades.Viagem;

public interface IRepositorioViagens {

    public List<Viagem> getViagem(Motorista motorista);

}