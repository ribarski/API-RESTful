package com.example.SaudeBemEstar.atendimento.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AtendimentoDTO {
    private LocalDate data;
    private String medico;
    private String paciente;
    private String diagnostico;
    private String observacoes;
}