package com.example.SaudeBemEstar.medicamento.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicamentoDTO {
    private Long id;
    private String nome;
    private String principioAtivo;
    private String dosagem;
    private Integer estoque;
}
