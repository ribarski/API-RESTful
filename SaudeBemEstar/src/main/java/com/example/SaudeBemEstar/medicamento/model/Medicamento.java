package com.example.SaudeBemEstar.medicamento.model;

import com.example.SaudeBemEstar.atendimento.model.Atendimento;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String principioAtivo;

    private String dosagem;

    private Integer estoque;

    @ManyToMany(mappedBy = "medicamentos")
    private List<Atendimento> atendimentos;
}
