package com.example.SaudeBemEstar.recomendacao.mapper;

import com.example.SaudeBemEstar.atendimento.model.Atendimento;
import com.example.SaudeBemEstar.medicamento.model.Medicamento;
import com.example.SaudeBemEstar.recomendacao.dto.RecomendacaoDTO;
import com.example.SaudeBemEstar.recomendacao.model.Recomendacao;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T21:31:56-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class RecomendacaoMapperImpl implements RecomendacaoMapper {

    @Override
    public Recomendacao toRecomendacao(RecomendacaoDTO recomendacaoDTO) {
        if ( recomendacaoDTO == null ) {
            return null;
        }

        Recomendacao.RecomendacaoBuilder recomendacao = Recomendacao.builder();

        recomendacao.atendimento( recomendacaoDTOToAtendimento( recomendacaoDTO ) );
        recomendacao.medicamento( recomendacaoDTOToMedicamento( recomendacaoDTO ) );
        recomendacao.observacao( recomendacaoDTO.getObservacao() );

        return recomendacao.build();
    }

    @Override
    public RecomendacaoDTO toRecomendacaoDTO(Recomendacao recomendacao) {
        if ( recomendacao == null ) {
            return null;
        }

        RecomendacaoDTO recomendacaoDTO = new RecomendacaoDTO();

        recomendacaoDTO.setAtendimentoId( recomendacaoAtendimentoId( recomendacao ) );
        recomendacaoDTO.setMedicamentoId( recomendacaoMedicamentoId( recomendacao ) );
        recomendacaoDTO.setObservacao( recomendacao.getObservacao() );

        return recomendacaoDTO;
    }

    protected Atendimento recomendacaoDTOToAtendimento(RecomendacaoDTO recomendacaoDTO) {
        if ( recomendacaoDTO == null ) {
            return null;
        }

        Atendimento.AtendimentoBuilder atendimento = Atendimento.builder();

        atendimento.id( recomendacaoDTO.getAtendimentoId() );

        return atendimento.build();
    }

    protected Medicamento recomendacaoDTOToMedicamento(RecomendacaoDTO recomendacaoDTO) {
        if ( recomendacaoDTO == null ) {
            return null;
        }

        Medicamento.MedicamentoBuilder medicamento = Medicamento.builder();

        medicamento.id( recomendacaoDTO.getMedicamentoId() );

        return medicamento.build();
    }

    private Long recomendacaoAtendimentoId(Recomendacao recomendacao) {
        if ( recomendacao == null ) {
            return null;
        }
        Atendimento atendimento = recomendacao.getAtendimento();
        if ( atendimento == null ) {
            return null;
        }
        Long id = atendimento.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long recomendacaoMedicamentoId(Recomendacao recomendacao) {
        if ( recomendacao == null ) {
            return null;
        }
        Medicamento medicamento = recomendacao.getMedicamento();
        if ( medicamento == null ) {
            return null;
        }
        Long id = medicamento.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
