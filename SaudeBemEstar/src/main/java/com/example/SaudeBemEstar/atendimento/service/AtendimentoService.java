package com.example.SaudeBemEstar.atendimento.service;

import com.example.projetoSpring.dto.AtendimentoDTO;
import com.example.projetoSpring.exception.BadRequestException;
import com.example.projetoSpring.mapper.AtendimentoMapper;
import com.example.projetoSpring.repository.AtendimentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final AtendimentoMapper atendimentoMapper;

    // Criar atendimento
    @Transactional
    public AtendimentoDTO criarAtendimento(AtendimentoDTO atendimentoDTO) {
        var atendimento = atendimentoMapper.toAtendimento(atendimentoDTO);
        return atendimentoMapper.toAtendimentoDTO(atendimentoRepository.save(atendimento));
    }

    // Atualizar atendimento
    @Transactional
    public void atualizarAtendimento(Long id, AtendimentoDTO atendimentoDTO) {
        var atendimentoExistente = atendimentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Atendimento não encontrado"));

        var atendimentoAtualizado = atendimentoMapper.toAtendimento(atendimentoDTO);
        atendimentoAtualizado.setId(atendimentoExistente.getId());
        atendimentoRepository.save(atendimentoAtualizado);
    }

    // Remover atendimento
    @Transactional
    public void removerAtendimento(Long id) {
        var atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Atendimento não encontrado"));
        atendimentoRepository.delete(atendimento);
    }

    // Buscar atendimentos com paginação
    public Page<AtendimentoDTO> buscarAtendimentos(Pageable pageable) {
        return atendimentoRepository.findAll(pageable).map(atendimentoMapper::toAtendimentoDTO);
    }

    // Buscar atendimentos por nome com paginação
    public Page<AtendimentoDTO> buscarAtendimentosPorNome(String name, Pageable pageable) {
        return atendimentoRepository.findByPaciente(name, pageable).map(atendimentoMapper::toAtendimentoDTO);
    }

    // Buscar atendimento por ID
    public AtendimentoDTO buscarAtendimentoPorId(Long id) {
        var atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Atendimento não encontrado"));
        return atendimentoMapper.toAtendimentoDTO(atendimento);
    }
}