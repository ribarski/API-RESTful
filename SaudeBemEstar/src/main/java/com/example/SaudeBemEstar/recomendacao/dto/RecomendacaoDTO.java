package com.example.SaudeBemEstar.recomendacao.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecomendacaoDTO {
    @NotNull
    private Long atendimentoId;

    @NotNull
    private Long medicamentoId;

    private String observacao;
}
