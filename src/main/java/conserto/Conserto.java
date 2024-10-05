package conserto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import mecanico.Mecanico;
import veiculo.Veiculo;

@Table(name = "consertos")
@Entity(name = "consertos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    // Construtor que aceita um objeto de dados de cadastro
    public Conserto(DadosCadastro dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.veiculo = new Veiculo(dados.veiculo().getMarca(), dados.veiculo().getModelo(), dados.veiculo().getAno());
        this.mecanico = new Mecanico(dados.mecanico().getNome(), dados.mecanico().getAnosExperiencia());
    }
}
