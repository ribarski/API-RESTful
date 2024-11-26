package com.example.SaudeBemEstar.atendimento.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
