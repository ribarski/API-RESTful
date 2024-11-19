package com.example.SaudeBemEstar.atendimento.model;

import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import com.example.SaudeBemEstar.recomendacao.model.Recomendacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private String medico;

    private String paciente;

    private String diagnostico;

    private String observacoes;

    @ManyToMany
    @JoinTable(
            name = "atendimento_medicamento",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> medicamentos;

    @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
    private List<Recomendacao> recomendacoes;
}
