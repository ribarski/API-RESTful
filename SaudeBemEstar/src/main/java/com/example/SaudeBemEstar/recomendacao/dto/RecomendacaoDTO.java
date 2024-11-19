package com.example.SaudeBemEstar.recomendacao.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public record RecomendacaoDTO(
        @NotNull String data,
        @NotNull String medico,
        @NotNull String paciente,
        @NotNull String orientacao,
        @Min(1) @Max(365) Integer duracao,
        MedicamentoDTO medicamento,
        AtendimentoDTO atendimento
) {}
