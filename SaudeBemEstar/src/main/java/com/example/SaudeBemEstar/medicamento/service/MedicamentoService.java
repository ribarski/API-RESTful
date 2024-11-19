package com.example.SaudeBemEstar.medicamento.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    // Criar um novo medicamento
    @Transactional
    public MedicamentoDTO criarMedicamento(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = new Medicamento(
                medicamentoDTO.getNome(),
                medicamentoDTO.getDosagem(),
                medicamentoDTO.getFrequencia(),
                medicamentoDTO.getTipo(),
                medicamentoDTO.getDataValidade()
        );
        medicamento = medicamentoRepository.save(medicamento);
        return new MedicamentoDTO(
                medicamento.getNome(),
                medicamento.getDosagem(),
                medicamento.getFrequencia(),
                medicamento.getTipo(),
                medicamento.getDataValidade()
        );
    }

    // Atualizar um medicamento
    @Transactional
    public MedicamentoDTO atualizarMedicamento(UUID id, MedicamentoDTO medicamentoDTO) {
        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(id);
        if (medicamentoOptional.isPresent()) {
            Medicamento medicamento = medicamentoOptional.get();
            medicamento.setNome(medicamentoDTO.getNome());
            medicamento.setDosagem(medicamentoDTO.getDosagem());
            medicamento.setFrequencia(medicamentoDTO.getFrequencia());
            medicamento.setTipo(medicamentoDTO.getTipo());
            medicamento.setDataValidade(medicamentoDTO.getDataValidade());
            medicamento = medicamentoRepository.save(medicamento);
            return new MedicamentoDTO(
                    medicamento.getNome(),
                    medicamento.getDosagem(),
                    medicamento.getFrequencia(),
                    medicamento.getTipo(),
                    medicamento.getDataValidade()
            );
        } else {
            throw new MedicamentoNotFoundException("Medicamento não encontrado.");
        }
    }

    // Remover um medicamento
    @Transactional
    public void removerMedicamento(UUID id) {
        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(id);
        if (medicamentoOptional.isPresent()) {
            medicamentoRepository.deleteById(id);
        } else {
            throw new MedicamentoNotFoundException("Medicamento não encontrado.");
        }
    }

    // Buscar todos os medicamentos
    public List<MedicamentoDTO> buscarMedicamentos() {
        List<Medicamento> medicamentos = medicamentoRepository.findAll();
        return medicamentos.stream().map(medicamento -> new MedicamentoDTO(
                medicamento.getNome(),
                medicamento.getDosagem(),
                medicamento.getFrequencia(),
                medicamento.getTipo(),
                medicamento.getDataValidade()
        )).toList();
    }

    // Buscar medicamento por ID
    public MedicamentoDTO buscarMedicamentoPorId(UUID id) {
        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(id);
        if (medicamentoOptional.isPresent()) {
            Medicamento medicamento = medicamentoOptional.get();
            return new MedicamentoDTO(
                    medicamento.getNome(),
                    medicamento.getDosagem(),
                    medicamento.getFrequencia(),
                    medicamento.getTipo(),
                    medicamento.getDataValidade()
            );
        } else {
            throw new MedicamentoNotFoundException("Medicamento não encontrado.");
        }
    }
}
