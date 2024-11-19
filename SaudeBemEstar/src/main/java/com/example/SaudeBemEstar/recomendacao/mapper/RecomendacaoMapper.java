package com.example.SaudeBemEstar.recomendacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecomendacaoMapper {

    // Instância do Mapper
    RecomendacaoMapper INSTANCE = Mappers.getMapper(RecomendacaoMapper.class);

    // Método para converter de Recomendacao para RecomendacaoDTO
    RecomendacaoDTO toDTO(Recomendacao recomendacao);

    // Método para converter de RecomendacaoDTO para Recomendacao
    Recomendacao toEntity(RecomendacaoDTO dto);
}
