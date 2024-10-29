package conserto;


import jakarta.validation.constraints.NotBlank;
import mecanico.Mecanico;
import veiculo.Veiculo;

public  record DadosCadastro(

        String nome,
        @NotBlank
        String dataEntrada,

        @NotBlank
        String dataSaida ,


        @NotBlank
        String cor,

        Mecanico mecanico,

        Veiculo veiculo){


}