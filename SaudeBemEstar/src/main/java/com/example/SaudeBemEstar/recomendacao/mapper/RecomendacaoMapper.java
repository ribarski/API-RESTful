package com.example.SaudeBemEstar.recomendacao.mapper;

import com.example.SaudeBemEstar.recomendacao.dto.RecomendacaoDTO;
import com.example.SaudeBemEstar.recomendacao.model.Recomendacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecomendacaoMapper {

    @Mapping(target = "atendimento.id", source = "atendimentoId")
    @Mapping(target = "medicamento.id", source = "medicamentoId")
    Recomendacao toRecomendacao(RecomendacaoDTO recomendacaoDTO);

    @Mapping(target = "atendimentoId", source = "atendimento.id")
    @Mapping(target = "medicamentoId", source = "medicamento.id")
    RecomendacaoDTO toRecomendacaoDTO(Recomendacao recomendacao);
}
