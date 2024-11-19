package com.example.SaudeBemEstar.medicamento.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public record MedicamentoDTO(
        @NotNull String nome,
        @NotNull String dosagem,
        @NotNull String frequencia,
        @NotNull String tipo,
        @Past LocalDate dataValidade
) {}

