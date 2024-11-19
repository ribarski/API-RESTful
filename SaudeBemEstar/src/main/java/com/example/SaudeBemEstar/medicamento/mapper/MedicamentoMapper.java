package com.example.SaudeBemEstar.medicamento.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicamentoMapper {

    // Instância do Mapper
    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);

    // Método para converter de Medicamento para MedicamentoDTO
    MedicamentoDTO toDTO(Medicamento medicamento);

    // Método para converter de MedicamentoDTO para Medicamento
    Medicamento toEntity(MedicamentoDTO dto);
}
