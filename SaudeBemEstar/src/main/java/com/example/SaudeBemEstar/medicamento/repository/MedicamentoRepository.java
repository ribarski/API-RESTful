package com.example.SaudeBemEstar.medicamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, UUID> {

    // O Spring Data JPA já fornece as implementações padrão para:
    // findById(), findAll(), save(), delete()
}
