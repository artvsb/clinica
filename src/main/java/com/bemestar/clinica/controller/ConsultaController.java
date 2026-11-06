package com.bemestar.clinica.controller;

import com.bemestar.clinica.dto.ConsultaRequestDTO;
import com.bemestar.clinica.dto.ConsultaResponseDTO;
import com.bemestar.clinica.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ConsultaResponseDTO agendar(ConsultaRequestDTO dto) {
        return consultaService.agendar(dto);
    }


}
