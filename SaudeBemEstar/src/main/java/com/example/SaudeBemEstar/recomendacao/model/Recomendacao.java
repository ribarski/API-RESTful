package com.example.SaudeBemEstar.recomendacao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recomendacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String data;
    private String medico;
    private String paciente;
    private String orientacao;
    private Integer duracao;

    @ManyToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;  // Relacionamento com Medicamento

    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimento;  // Relacionamento com Atendimento

}
