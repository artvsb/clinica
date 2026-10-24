package com.bemestar.clinica.controller;

import com.bemestar.clinica.model.Medico;
import com.bemestar.clinica.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico cadastrar(@RequestBody Medico medico) {
        return medicoService.cadastrar(medico);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Medico> listar() {
        return medicoService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Medico> buscar(@PathVariable Long id) {
        return medicoService.buscar(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        medicoService.deletar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody Medico medicoAtualizado) {
        medicoService.atualizar(id, medicoAtualizado);
    }

}
