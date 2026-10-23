package com.bemestar.clinica.controller;

import com.bemestar.clinica.model.Medico;
import com.bemestar.clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico cadastrar(@RequestBody Medico medico) {
        return medicoService.cadastrar(medico);
    }
}
