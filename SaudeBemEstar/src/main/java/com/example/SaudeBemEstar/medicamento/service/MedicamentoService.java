package com.example.SaudeBemEstar.medicamento.service;

import com.example.SaudeBemEstar.exception.BadRequestException;
import com.example.SaudeBemEstar.medicamento.dto.MedicamentoDTO;
import com.example.SaudeBemEstar.medicamento.dto.MedicamentoUpdateDTO;
import com.example.SaudeBemEstar.medicamento.mapper.MedicamentoMapper;
import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import com.example.SaudeBemEstar.medicamento.repository.MedicamentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Medicamento salvo = medicamentoRepository.save(medicamento);
        return medicamentoMapper.toMedicamentoDTO(salvo);
    }

    public MedicamentoDTO buscarPorId(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Medicamento não encontrado"));
        return medicamentoMapper.toMedicamentoDTO(medicamento);
    }

    @Transactional
    public void atualizarMedicamento(Long id, MedicamentoUpdateDTO medicamentoUpdateDTO) {
        Medicamento medicamentoExistente = medicamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Medicamento com ID " + id + " não encontrado"));

        Optional.ofNullable(medicamentoUpdateDTO.getNome()).ifPresent(medicamentoExistente::setNome);
        Optional.ofNullable(medicamentoUpdateDTO.getPrincipioAtivo()).ifPresent(medicamentoExistente::setPrincipioAtivo);
        Optional.ofNullable(medicamentoUpdateDTO.getDosagem()).ifPresent(medicamentoExistente::setDosagem);
        Optional.ofNullable(medicamentoUpdateDTO.getEstoque()).ifPresent(medicamentoExistente::setEstoque);

        medicamentoRepository.save(medicamentoExistente);
    }

    @Transactional
    public void removerMedicamento(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Medicamento não encontrado"));
        medicamentoRepository.delete(medicamento);
    }
}
