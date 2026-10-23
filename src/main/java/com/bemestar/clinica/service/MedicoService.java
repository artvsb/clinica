package com.bemestar.clinica.service;

import com.bemestar.clinica.model.Medico;
import com.bemestar.clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastrar(Medico medico) {
        return medicoRepository.save(medico);
    }

}
