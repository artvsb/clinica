package com.bemestar.clinica.dto;

import java.time.LocalDateTime;

public record ConsultaResponseDTO(
        Long idConsulta,
        String nomePaciente,
        String nomeMedico,
        LocalDateTime dataHora,
        String motivo
) {
}
