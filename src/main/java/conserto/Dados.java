package conserto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dados {

    private String dataEntrada;
    private String dataSainda;
    private String anoExperiencia;
    private String nome;
    private String ano;
    private String marca;
    private String modelo;

    public Dados(DadosCadastro dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSainda = dados.dataSaida();
        this.anoExperiencia = String.valueOf(dados.mecanico());
        this.nome = String.valueOf(dados.mecanico());
        this.ano = String.valueOf(dados.veiculo());
        this.marca = String.valueOf(dados.veiculo());
        this.modelo = String.valueOf(dados.veiculo());
    }


}
