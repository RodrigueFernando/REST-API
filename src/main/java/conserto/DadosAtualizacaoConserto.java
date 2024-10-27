package conserto;

import jakarta.validation.constraints.NotNull;
import mecanico.Mecanico;

/*
public class DadosAtualizacaoConserto{
       Long id;
       String dataSaida;
       String anoExperiencia;
       String nome;
}
*/
public record DadosAtualizacaoConserto(
        @NotNull Long id,
        String dataSaida,

        String nome,

        String anoExperiencia,
        Mecanico mecanico

) {}
