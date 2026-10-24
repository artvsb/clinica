package com.bemestar.clinica.service;

import com.bemestar.clinica.model.Medico;
import com.bemestar.clinica.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public Medico cadastrar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> buscar(Long id) {
        return medicoRepository.findById(id);
    }

    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }

    public void atualizar(Long id, Medico medicoAtualizado) {
        medicoAtualizado.setId(id);
        medicoRepository.save(medicoAtualizado);
    }
}
