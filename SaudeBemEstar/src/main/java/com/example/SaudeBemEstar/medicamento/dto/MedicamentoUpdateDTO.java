package com.example.SaudeBemEstar.medicamento.dto;

import lombok.Data;

@Data
public class MedicamentoUpdateDTO {
    private String nome;
    private String principioAtivo;
    private String dosagem;
    private Integer  estoque;
}