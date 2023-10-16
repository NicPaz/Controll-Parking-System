package controllparkingsystem;
import java.util.ArrayList;

import model.DaoVeiculo;
import model.Veiculo;
import view.TelaInicial;


public class ControllParkingSystem {

    public static void main(String[] args) {
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        // Buscando todos os veículos
        ArrayList<Veiculo> veiculos = daoVeiculo.buscarTodos();
        System.out.println("Veículos encontrados:");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.getNome());
            
        }

        // Buscando um veículo por código
        Veiculo veiculoEncontrado = daoVeiculo.buscar(1);
        if (veiculoEncontrado != null) {
            System.out.println("Veículo encontrado:");
            System.out.println(veiculoEncontrado);
        } else {
            System.out.println("Veículo não encontrado.");
        }
        
         new TelaInicial().setVisible(true);
    }
    
    
}
