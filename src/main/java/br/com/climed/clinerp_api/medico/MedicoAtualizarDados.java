package br.com.climed.clinerp_api.medico;

import br.com.climed.clinerp_api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record MedicoAtualizarDados(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
