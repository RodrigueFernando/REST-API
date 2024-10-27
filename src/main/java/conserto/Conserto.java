package conserto;

import lombok.*;
import jakarta.persistence.*;
import mecanico.Mecanico;
import veiculo.Veiculo;

@Table(name = "consertos")
@Entity(name = "consertos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;
    private String dataSaida;
    private String cor;


    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    // Construtor que aceita um objeto de dados de cadastro
    public Conserto(DadosCadastro dados) {
       // this.ativo = true;

        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.cor = dados.cor();

        this.veiculo = new Veiculo(dados.veiculo().getMarca(), dados.veiculo().getModelo(), dados.veiculo().getAno());
        this.mecanico = new Mecanico(dados.mecanico().getNome(), dados.mecanico().getAnosExperiencia());
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if(dados.dataSaida() != null){
            this.dataSaida = dados.dataSaida();
        }
        if(dados.nome() != null) {
            this.mecanico.setNome(dados.nome()) ;
        }
        if(dados.anoExperiencia() != null) {
            this.mecanico.setAnosExperiencia(dados.anoExperiencia()) ;
        }

    }



}
