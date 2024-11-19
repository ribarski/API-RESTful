package com.example.SaudeBemEstar.medicamento.service;

import com.example.SaudeBemEstar.exception.BadRequestException;
import com.example.SaudeBemEstar.medicamento.dto.MedicamentoDTO;
import com.example.SaudeBemEstar.medicamento.mapper.MedicamentoMapper;
import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import com.example.SaudeBemEstar.medicamento.repository.MedicamentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoMapper medicamentoMapper;

    public List<MedicamentoDTO> buscarTodos() {
        return medicamentoRepository.findAll().stream()
                .map(medicamentoMapper::toMedicamentoDTO)
                .toList();
    }

    @Transactional
    public MedicamentoDTO criarMedicamento(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = medicamentoMapper.toMedicamento(medicamentoDTO);
        return medicamentoMapper.toMedicamentoDTO(medicamentoRepository.save(medicamento));
    }

    public MedicamentoDTO buscarPorId(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Medicamento não encontrado"));
        return medicamentoMapper.toMedicamentoDTO(medicamento);
    }

    @Transactional
    public void atualizarMedicamento(Long id, MedicamentoDTO medicamentoDTO) {
        Medicamento medicamentoExistente = medicamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Medicamento não encontrado"));

        medicamentoMapper.toMedicamento(medicamentoDTO).setId(medicamentoExistente.getId());
        medicamentoRepository.save(medicamentoExistente);
    }

    @Transactional
    public void removerMedicamento(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Medicamento não encontrado"));
        medicamentoRepository.delete(medicamento);
    }
}
