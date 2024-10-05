package veiculo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Veiculo {

    private String marca;
    private String modelo;
    private String ano;




}
