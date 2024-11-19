package com.example.SaudeBemEstar.atendimento.repository;

import com.example.projetoSpring.domain.Atendimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    // Buscar atendimentos por paciente (com paginação)
    Page<Atendimento> findByPaciente(String name, Pageable pageable);

    // Buscar atendimento por ID
    Optional<Atendimento> findById(Long id);
}