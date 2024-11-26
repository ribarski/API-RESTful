package com.example.SaudeBemEstar.atendimento.service;

import com.example.SaudeBemEstar.atendimento.dto.AtendimentoDTO;
import com.example.SaudeBemEstar.atendimento.model.Atendimento;
import com.example.SaudeBemEstar.exception.BadRequestException;
import com.example.SaudeBemEstar.atendimento.mapper.AtendimentoMapper;
import com.example.SaudeBemEstar.atendimento.repository.AtendimentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final AtendimentoMapper atendimentoMapper;

    @Transactional
    public AtendimentoDTO criarAtendimento(AtendimentoDTO atendimentoDTO) {
        var atendimento = atendimentoMapper.toAtendimento(atendimentoDTO);
        return atendimentoMapper.toAtendimentoDTO(atendimentoRepository.save(atendimento));
    }

    @Transactional
    public void atualizarAtendimento(Long id, AtendimentoDTO atendimentoDTO) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if(atendimento.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Atendimento não encontrado");

        var atendimentoAtualizado = atendimentoMapper.toAtendimento(atendimentoDTO);
        atendimentoAtualizado.setId(id);
        atendimentoRepository.save(atendimentoAtualizado);
    }


    @Transactional
    public void removerAtendimento(Long id) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if(atendimento.isEmpty()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Atendimento não encontrado");
        atendimentoRepository.delete(atendimento.get());
    }

    public List<AtendimentoDTO> buscarAtendimentos() {
        return atendimentoRepository.findAll() // Retorna uma lista de entidades Atendimento
                .stream() // Inicia o processamento em fluxo
                .map(atendimentoMapper::toAtendimentoDTO) // Mapeia de Atendimento para AtendimentoDTO
                .collect(Collectors.toList()); // Coleta o resultado em uma lista
    }

    public Page<AtendimentoDTO> buscarAtendimentos(Pageable pageable) {
        return atendimentoRepository.findAll(pageable)
                .map(atendimentoMapper::toAtendimentoDTO);
    }

    public AtendimentoDTO buscarAtendimentoPorId(Long id) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if (atendimento.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendimento não encontrado");
        return atendimentoMapper.toAtendimentoDTO(atendimento.get());
    }
}