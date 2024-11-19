package com.example.SaudeBemEstar.recomendacao.mapper;

import com.example.SaudeBemEstar.recomendacao.dto.RecomendacaoDTO;
import com.example.SaudeBemEstar.recomendacao.model.Recomendacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecomendacaoMapper {

    RecomendacaoDTO toRecomendacaoDTO(Recomendacao recomendacao);
    Recomendacao toRecomendacao(RecomendacaoDTO recomendacaoDTO);
}
