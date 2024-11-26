package com.example.SaudeBemEstar.recomendacao.service;

import com.example.SaudeBemEstar.atendimento.repository.AtendimentoRepository;
import com.example.SaudeBemEstar.medicamento.repository.MedicamentoRepository;
import com.example.SaudeBemEstar.recomendacao.dto.RecomendacaoDTO;
import com.example.SaudeBemEstar.recomendacao.mapper.RecomendacaoMapper;
import com.example.SaudeBemEstar.recomendacao.model.Recomendacao;
import com.example.SaudeBemEstar.recomendacao.repository.RecomendacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecomendacaoService {

    private final RecomendacaoRepository recomendacaoRepository;
    private final AtendimentoRepository atendimentoRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final RecomendacaoMapper recomendacaoMapper;

    @Transactional
    public RecomendacaoDTO criarRecomendacao(RecomendacaoDTO recomendacaoDTO) {
        // Verifica se o atendimento existe
        atendimentoRepository.findById(recomendacaoDTO.getAtendimentoId())
                .orElseThrow(() -> new IllegalArgumentException("Atendimento não encontrado"));

        // Verifica se o medicamento existe
        medicamentoRepository.findById(recomendacaoDTO.getMedicamentoId())
                .orElseThrow(() -> new IllegalArgumentException("Medicamento não encontrado"));

        Recomendacao recomendacao = recomendacaoMapper.toRecomendacao(recomendacaoDTO);
        return recomendacaoMapper.toRecomendacaoDTO(recomendacaoRepository.save(recomendacao));
    }

    public List<RecomendacaoDTO> listarRecomendacoes() {
        return recomendacaoRepository.findAll().stream()
                .map(recomendacaoMapper::toRecomendacaoDTO)
                .toList();
    }

    public RecomendacaoDTO buscarPorId(Long id) {
        Recomendacao recomendacao = recomendacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recomendação não encontrada"));
        return recomendacaoMapper.toRecomendacaoDTO(recomendacao);
    }

    @Transactional
    public void atualizarRecomendacao(Long id, RecomendacaoDTO recomendacaoDTO) {
        Recomendacao recomendacaoExistente = recomendacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recomendação não encontrada"));

        recomendacaoExistente.setObservacao(recomendacaoDTO.getObservacao());
        recomendacaoExistente.setAtendimento(
                atendimentoRepository.findById(recomendacaoDTO.getAtendimentoId())
                        .orElseThrow(() -> new IllegalArgumentException("Atendimento não encontrado"))
        );
        recomendacaoExistente.setMedicamento(
                medicamentoRepository.findById(recomendacaoDTO.getMedicamentoId())
                        .orElseThrow(() -> new IllegalArgumentException("Medicamento não encontrado"))
        );

        recomendacaoRepository.save(recomendacaoExistente);
    }

    @Transactional
    public void deletarRecomendacao(Long id) {
        if (!recomendacaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Recomendação não encontrada");
        }
        recomendacaoRepository.deleteById(id);
    }
}
