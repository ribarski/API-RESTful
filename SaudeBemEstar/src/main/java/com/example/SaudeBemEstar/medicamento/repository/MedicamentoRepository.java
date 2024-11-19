package com.example.SaudeBemEstar.medicamento.repository;

import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
