package conserto;


import mecanico.Mecanico;
import veiculo.Veiculo;

public  record DadosCadastro(String dataEntrada, String dataSaida , Mecanico mecanico,

                             Veiculo veiculo){


}
