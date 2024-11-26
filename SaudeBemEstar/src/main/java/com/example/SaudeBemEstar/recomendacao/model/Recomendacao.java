package com.example.SaudeBemEstar.recomendacao.model;

import com.example.SaudeBemEstar.atendimento.model.Atendimento;
import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "atendimento_id", nullable = false)
    private Atendimento atendimento;

    @ManyToOne
    @JoinColumn(name = "medicamento_id", nullable = false)
    private Medicamento medicamento;

    private String observacao;
}
