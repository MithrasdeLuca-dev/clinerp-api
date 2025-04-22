package br.com.climed.clinerp_api.controller;

import br.com.climed.clinerp_api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRespository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoRegisterDados dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<MedicoListDados> listarMedicos(Pageable pages) {
        return repository.findAll(pages).map(MedicoListDados::new);
    }

    @GetMapping("/ativos")
    public Page<MedicoListDados> listarMedicosAtivos(Pageable pageable) {
        return repository.findMedicosAtivos(pageable).map(MedicoListDados::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid MedicoAtualizarDados dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfo(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/ativarDesativar/{id}/{status}")
    @Transactional
    public void ativarDesativar(@PathVariable("id") Long id, @PathVariable("status") boolean status) {

        var medico = repository.getReferenceById(id);
        medico.ativarDesativar(status);
    }
}
