package com.example.SaudeBemEstar.recomendacao.service;

import com.example.SaudeBemEstar.exception.BadRequestException;
import com.example.SaudeBemEstar.recomendacao.dto.RecomendacaoDTO;
import com.example.SaudeBemEstar.recomendacao.mapper.RecomendacaoMapper;
import com.example.SaudeBemEstar.recomendacao.model.Recomendacao;
import com.example.SaudeBemEstar.recomendacao.repository.RecomendacaoRepository;
import com.example.SaudeBemEstar.atendimento.repository.AtendimentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecomendacaoService {

    private final RecomendacaoRepository recomendacaoRepository;
    private final AtendimentoRepository atendimentoRepository;
    private final RecomendacaoMapper recomendacaoMapper;

    public List<RecomendacaoDTO> buscarPorAtendimento(Long atendimentoId) {
        return recomendacaoRepository.findByAtendimentoId(atendimentoId).stream()
                .map(recomendacaoMapper::toRecomendacaoDTO)
                .toList();
    }

    @Transactional
    public RecomendacaoDTO criarRecomendacao(RecomendacaoDTO recomendacaoDTO) {
        var atendimento = atendimentoRepository.findById(recomendacaoDTO.getAtendimentoId())
                .orElseThrow(() -> new BadRequestException("Atendimento não encontrado"));

        Recomendacao recomendacao = recomendacaoMapper.toRecomendacao(recomendacaoDTO);
        recomendacao.setAtendimento(atendimento);
        return recomendacaoMapper.toRecomendacaoDTO(recomendacaoRepository.save(recomendacao));
    }

    public RecomendacaoDTO buscarPorId(Long id) {
        Recomendacao recomendacao = recomendacaoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Recomendação não encontrada"));
        return recomendacaoMapper.toRecomendacaoDTO(recomendacao);
    }

    @Transactional
    public void atualizarRecomendacao(Long id, RecomendacaoDTO recomendacaoDTO) {
        Recomendacao recomendacaoExistente = recomendacaoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Recomendação não encontrada"));

        var atendimento = atendimentoRepository.findById(recomendacaoDTO.getAtendimentoId())
                .orElseThrow(() -> new BadRequestException("Atendimento não encontrado"));

        Recomendacao recomendacaoAtualizada = recomendacaoMapper.toRecomendacao(recomendacaoDTO);
        recomendacaoAtualizada.setId(recomendacaoExistente.getId());
        recomendacaoAtualizada.setAtendimento(atendimento);
        recomendacaoRepository.save(recomendacaoAtualizada);
    }

    @Transactional
    public void removerRecomendacao(Long id) {
        Recomendacao recomendacao = recomendacaoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Recomendação não encontrada"));
        recomendacaoRepository.delete(recomendacao);
    }
}
