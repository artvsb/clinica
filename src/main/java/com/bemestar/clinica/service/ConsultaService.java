package com.bemestar.clinica.service;

import com.bemestar.clinica.dto.ConsultaRequestDTO;
import com.bemestar.clinica.dto.ConsultaResponseDTO;
import com.bemestar.clinica.model.Consulta;
import com.bemestar.clinica.model.Medico;
import com.bemestar.clinica.repository.ConsultaRepository;
import com.bemestar.clinica.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaResponseDTO agendar(ConsultaRequestDTO dto) {
        Consulta consulta = new Consulta();
        consulta.setNomePaciente(dto.nomePaciente());
        consulta.setMotivo(dto.motivo());
        consulta.setDataHora(dto.dataHora());
        consulta.setMedico(buscarMedicoOuFalhar(dto.medicoId()));
        consulta.setValor(buscarMedicoOuFalhar(dto.medicoId()).getValorConsulta());

        Consulta salva = consultaRepository.save(consulta);
        return paraResposta(salva);
    }

    private Medico buscarMedicoOuFalhar(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Médico não encontrado"
                ));
    }


    private ConsultaResponseDTO paraResposta(Consulta consulta) {
        return new ConsultaResponseDTO(
                consulta.getId(),
                consulta.getNomePaciente(),
                consulta.getMedico().getNome(),
                consulta.getDataHora(),
                consulta.getMotivo()
        );
    }
}
