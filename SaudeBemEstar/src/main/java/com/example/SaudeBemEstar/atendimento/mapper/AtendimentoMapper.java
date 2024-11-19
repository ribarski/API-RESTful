package com.example.SaudeBemEstar.atendimento.mapper;

import com.example.projetoSpring.domain.Atendimento;
import com.example.projetoSpring.dto.AtendimentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AtendimentoMapper {

    AtendimentoMapper INSTANCE = Mappers.getMapper(AtendimentoMapper.class);

    Atendimento toAtendimento(AtendimentoDTO atendimentoDTO);

    AtendimentoDTO toAtendimentoDTO(Atendimento atendimento);
}