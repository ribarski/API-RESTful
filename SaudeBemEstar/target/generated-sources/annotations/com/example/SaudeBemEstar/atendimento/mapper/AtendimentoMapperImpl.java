package com.example.SaudeBemEstar.atendimento.mapper;

import com.example.SaudeBemEstar.atendimento.dto.AtendimentoDTO;
import com.example.SaudeBemEstar.atendimento.model.Atendimento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T21:31:56-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AtendimentoMapperImpl implements AtendimentoMapper {

    @Override
    public Atendimento toAtendimento(AtendimentoDTO atendimentoDTO) {
        if ( atendimentoDTO == null ) {
            return null;
        }

        Atendimento.AtendimentoBuilder atendimento = Atendimento.builder();

        atendimento.data( atendimentoDTO.getData() );
        atendimento.medico( atendimentoDTO.getMedico() );
        atendimento.paciente( atendimentoDTO.getPaciente() );
        atendimento.diagnostico( atendimentoDTO.getDiagnostico() );
        atendimento.observacoes( atendimentoDTO.getObservacoes() );

        return atendimento.build();
    }

    @Override
    public AtendimentoDTO toAtendimentoDTO(Atendimento atendimento) {
        if ( atendimento == null ) {
            return null;
        }

        AtendimentoDTO.AtendimentoDTOBuilder atendimentoDTO = AtendimentoDTO.builder();

        atendimentoDTO.data( atendimento.getData() );
        atendimentoDTO.medico( atendimento.getMedico() );
        atendimentoDTO.paciente( atendimento.getPaciente() );
        atendimentoDTO.diagnostico( atendimento.getDiagnostico() );
        atendimentoDTO.observacoes( atendimento.getObservacoes() );

        return atendimentoDTO.build();
    }
}
