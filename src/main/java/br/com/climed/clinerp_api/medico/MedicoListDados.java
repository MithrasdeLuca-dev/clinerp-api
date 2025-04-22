package br.com.climed.clinerp_api.medico;

public record MedicoListDados(Long id, String nome, String email, String crm, Boolean status, Especialidade especialidade) {

    public MedicoListDados(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getStatus(), medico.getEspecialidade());
    }
}
