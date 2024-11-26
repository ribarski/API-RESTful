package com.example.SaudeBemEstar.atendimento.mapper;

import com.example.SaudeBemEstar.atendimento.model.Atendimento;
import com.example.SaudeBemEstar.atendimento.dto.AtendimentoDTO;
import org.mapstruct.Mapper;




@Mapper(componentModel = "spring")
public interface AtendimentoMapper {
    Atendimento toAtendimento(AtendimentoDTO atendimentoDTO);
    AtendimentoDTO toAtendimentoDTO(Atendimento atendimento);
}