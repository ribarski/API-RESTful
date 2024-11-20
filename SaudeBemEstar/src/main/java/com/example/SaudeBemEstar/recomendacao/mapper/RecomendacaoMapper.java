package com.example.SaudeBemEstar.recomendacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.SaudeBemEstar.recomendacao.dto.RecomendacaoDTO;
import com.example.SaudeBemEstar.recomendacao.model.Recomendacao;

@Mapper(componentModel = "spring")
public interface RecomendacaoMapper {
    @Mapping(target="atendimentoId", source="id")
    RecomendacaoDTO toRecomendacaoDTO(Recomendacao recomendacao);
    
    @Mapping(target="atendimento.id", source="atendimentoId")
    Recomendacao toRecomendacao(RecomendacaoDTO recomendacaoDTO);
}
