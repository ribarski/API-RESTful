package com.example.SaudeBemEstar.medicamento.mapper;

import com.example.SaudeBemEstar.medicamento.dto.MedicamentoDTO;
import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T21:31:56-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class MedicamentoMapperImpl implements MedicamentoMapper {

    @Override
    public Medicamento toMedicamento(MedicamentoDTO medicamentoDTO) {
        if ( medicamentoDTO == null ) {
            return null;
        }

        Medicamento.MedicamentoBuilder medicamento = Medicamento.builder();

        medicamento.nome( medicamentoDTO.getNome() );
        medicamento.principioAtivo( medicamentoDTO.getPrincipioAtivo() );
        medicamento.dosagem( medicamentoDTO.getDosagem() );
        medicamento.estoque( medicamentoDTO.getEstoque() );

        return medicamento.build();
    }

    @Override
    public MedicamentoDTO toMedicamentoDTO(Medicamento medicamento) {
        if ( medicamento == null ) {
            return null;
        }

        MedicamentoDTO.MedicamentoDTOBuilder medicamentoDTO = MedicamentoDTO.builder();

        medicamentoDTO.nome( medicamento.getNome() );
        medicamentoDTO.principioAtivo( medicamento.getPrincipioAtivo() );
        medicamentoDTO.dosagem( medicamento.getDosagem() );
        medicamentoDTO.estoque( medicamento.getEstoque() );

        return medicamentoDTO.build();
    }
}
