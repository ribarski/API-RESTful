package com.example.SaudeBemEstar.medicamento.mapper;

import com.example.SaudeBemEstar.medicamento.dto.MedicamentoDTO;
import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper {
    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);

    Medicamento toMedicamento(MedicamentoDTO medicamentoDTO);

    MedicamentoDTO toMedicamentoDTO(Medicamento medicamento);
}
