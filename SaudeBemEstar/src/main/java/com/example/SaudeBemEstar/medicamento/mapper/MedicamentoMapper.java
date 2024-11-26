package com.example.SaudeBemEstar.medicamento.mapper;

import com.example.SaudeBemEstar.medicamento.dto.MedicamentoDTO;
import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper {
    Medicamento toMedicamento(MedicamentoDTO medicamentoDTO);
    MedicamentoDTO toMedicamentoDTO(Medicamento medicamento);
}
