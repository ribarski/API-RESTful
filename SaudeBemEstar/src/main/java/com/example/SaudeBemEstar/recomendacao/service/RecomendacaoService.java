package com.example.SaudeBemEstar.recomendacao.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecomendacaoService {

    private final RecomendacaoRepository recomendacaoRepository;

    public RecomendacaoService(RecomendacaoRepository recomendacaoRepository) {
        this.recomendacaoRepository = recomendacaoRepository;
    }

    // Criar uma nova recomendação
    @Transactional
    public RecomendacaoDTO criarRecomendacao(RecomendacaoDTO recomendacaoDTO) {
        Recomendacao recomendacao = new Recomendacao(
                recomendacaoDTO.data(),
                recomendacaoDTO.medico(),
                recomendacaoDTO.paciente(),
                recomendacaoDTO.medicamento(),
                recomendacaoDTO.orientacao(),
                recomendacaoDTO.duracao()
        );
        recomendacao = recomendacaoRepository.save(recomendacao);
        return new RecomendacaoDTO(
                recomendacao.getData(),
                recomendacao.getMedico(),
                recomendacao.getPaciente(),
                recomendacao.getMedicamento(),
                recomendacao.getOrientacao(),
                recomendacao.getDuracao()
        );
    }

    // Atualizar uma recomendação
    @Transactional
    public RecomendacaoDTO atualizarRecomendacao(UUID id, RecomendacaoDTO recomendacaoDTO) {
        Optional<Recomendacao> recomendacaoOptional = recomendacaoRepository.findById(id);
        if (recomendacaoOptional.isPresent()) {
            Recomendacao recomendacao = recomendacaoOptional.get();
            recomendacao.setData(recomendacaoDTO.data());
            recomendacao.setMedico(recomendacaoDTO.medico());
            recomendacao.setPaciente(recomendacaoDTO.paciente());
            recomendacao.setMedicamento(recomendacaoDTO.medicamento());
            recomendacao.setOrientacao(recomendacaoDTO.orientacao());
            recomendacao.setDuracao(recomendacaoDTO.duracao());
            recomendacao = recomendacaoRepository.save(recomendacao);
            return new RecomendacaoDTO(
                    recomendacao.getData(),
                    recomendacao.getMedico(),
                    recomendacao.getPaciente(),
                    recomendacao.getMedicamento(),
                    recomendacao.getOrientacao(),
                    recomendacao.getDuracao()
            );
        } else {
            throw new RecomendacaoNotFoundException("Recomendação não encontrada.");
        }
    }

    // Remover uma recomendação
    @Transactional
    public void removerRecomendacao(UUID id) {
        Optional<Recomendacao> recomendacaoOptional = recomendacaoRepository.findById(id);
        if (recomendacaoOptional.isPresent()) {
            recomendacaoRepository.deleteById(id);
        } else {
            throw new RecomendacaoNotFoundException("Recomendação não encontrada.");
        }
    }

    // Buscar todas as recomendações
    public List<RecomendacaoDTO> buscarRecomendacoes() {
        List<Recomendacao> recomendacoes = recomendacaoRepository.findAll();
        return recomendacoes.stream().map(recomendacao -> new RecomendacaoDTO(
                recomendacao.getData(),
                recomendacao.getMedico(),
                recomendacao.getPaciente(),
                recomendacao.getMedicamento(),
                recomendacao.getOrientacao(),
                recomendacao.getDuracao()
        )).toList();
    }

    // Buscar recomendação por ID
    public RecomendacaoDTO buscarRecomendacaoPorId(UUID id) {
        Optional<Recomendacao> recomendacaoOptional = recomendacaoRepository.findById(id);
        if (recomendacaoOptional.isPresent()) {
            Recomendacao recomendacao = recomendacaoOptional.get();
            return new RecomendacaoDTO(
                    recomendacao.getData(),
                    recomendacao.getMedico(),
                    recomendacao.getPaciente(),
                    recomendacao.getMedicamento(),
                    recomendacao.getOrientacao(),
                    recomendacao.getDuracao()
            );
        } else {
            throw new RecomendacaoNotFoundException("Recomendação não encontrada.");
        }
    }
}
