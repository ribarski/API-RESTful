package com.example.SaudeBemEstar.recomendacao.model;

import com.example.SaudeBemEstar.atendimento.model.Atendimento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recomendacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimento;
}
