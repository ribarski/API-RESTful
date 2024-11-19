package com.example.SaudeBemEstar.recomendacao.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecomendacaoDTO {
    private Long id;
    private String descricao;
    private String tipo;
    private Long atendimentoId;
}
