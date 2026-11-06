package com.bemestar.clinica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequestDTO(
        @NotNull(message = "O nome do paciente é obrigatório!")
        String nomePaciente,

        @NotNull(message = "O ID do médico é obrigatório!")
        Long medicoId,

        String motivo,

        @NotNull(message = "Data obrigatória")
        @Future(message = "Insira uma data futura!")
        @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
        LocalDateTime dataHora
) {}
