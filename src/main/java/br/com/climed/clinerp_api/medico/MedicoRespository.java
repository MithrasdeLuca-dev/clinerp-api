package br.com.climed.clinerp_api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicoRespository extends JpaRepository<Medico, Long> {

    @Query("SELECT m FROM Medicos m WHERE m.status = true")
    Page<Medico> findMedicosAtivos(Pageable pageable);
}
