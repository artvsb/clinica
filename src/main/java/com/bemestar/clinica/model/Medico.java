package com.bemestar.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "crm", nullable = false)
    private String crm;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

}
