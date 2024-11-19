package com.example.SaudeBemEstar.recomendacao.repository;

import com.example.SaudeBemEstar.recomendacao.model.Recomendacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Long> {
    List<Recomendacao> findByAtendimentoId(Long atendimentoId);
}
