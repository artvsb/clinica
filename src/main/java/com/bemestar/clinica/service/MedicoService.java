package com.bemestar.clinica.service;

import com.bemestar.clinica.model.Medico;
import com.bemestar.clinica.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void editar(Long id, Medico medicoAtualizado) {

        Optional<Medico> optionalMedico = medicoRepository.findById(id);

        if (optionalMedico.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado!");
        }

        Medico medicoExistente = optionalMedico.get();

        if (medicoAtualizado.getNome() != null) {
            medicoExistente.setNome(medicoAtualizado.getNome());
        }

        if (medicoAtualizado.getEmail() != null) {
            medicoExistente.setEmail(medicoAtualizado.getEmail());
        }

        if (medicoAtualizado.getCrm() != null) {
            medicoExistente.setCrm(medicoAtualizado.getCrm());
        }

        if (medicoAtualizado.getEspecialidade() != null) {
            medicoExistente.setEspecialidade(medicoAtualizado.getEspecialidade());
        }

        if(medicoAtualizado.getTelefone() != null ) {
            medicoExistente.setTelefone(medicoAtualizado.getTelefone());
        }

        if (medicoAtualizado.getAtendeConvenio() != null) {
            medicoExistente.setAtendeConvenio(medicoAtualizado.getAtendeConvenio());
        }

        medicoRepository.save(medicoExistente);
    }
}
