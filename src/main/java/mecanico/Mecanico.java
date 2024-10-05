package mecanico;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Mecanico {
    private String nome;
    private String anosExperiencia;


}
