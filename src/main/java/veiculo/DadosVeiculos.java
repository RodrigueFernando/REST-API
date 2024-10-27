package veiculo;

import jakarta.validation.constraints.NotBlank;

public record DadosVeiculos(
        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotBlank
        String ano



) {
}