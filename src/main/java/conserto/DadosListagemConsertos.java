package conserto;

import mecanico.Mecanico;
import veiculo.Veiculo;

public record DadosListagemConsertos(String dataEntrada,String dataSaida, String nome,String marca,String modelo) {

    // Construtor adicional que cria DadosListagemConsertos a partir de Conserto, Veiculo e Mecanico
    public DadosListagemConsertos(Conserto conserto, Veiculo veiculo, Mecanico mecanico) {
        this(conserto.getDataEntrada(),
             conserto.getDataSaida(),
                mecanico.getNome(),
                veiculo.getMarca(),
                veiculo.getModelo()
        );
    }

    public DadosListagemConsertos(Conserto conserto) {
        this(conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }


    // Não é necessário criar um segundo construtor, pois o record já faz isso automaticamente
}