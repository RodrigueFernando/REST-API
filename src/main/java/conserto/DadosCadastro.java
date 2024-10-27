package conserto;


import jakarta.validation.constraints.NotBlank;
import mecanico.Mecanico;
import veiculo.Veiculo;

public  record DadosCadastro(
        @NotBlank
        String nome,
        @NotBlank
        String dataEntrada,

        @NotBlank
        String dataSaida ,

        @NotBlank
        String telefone,

        @NotBlank
        String cor,

        Mecanico mecanico,

        Veiculo veiculo){


}