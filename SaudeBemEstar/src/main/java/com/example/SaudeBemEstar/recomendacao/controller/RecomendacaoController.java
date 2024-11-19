package com.example.SaudeBemEstar.recomendacao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Api(tags = "Recomendações")
@RestController
@RequestMapping("/recomendacoes")
public class RecomendacaoController {

    private final RecomendacaoService recomendacaoService;

    public RecomendacaoController(RecomendacaoService recomendacaoService) {
        this.recomendacaoService = recomendacaoService;
    }

    @ApiOperation(value = "Retorna todas as recomendações")
    @GetMapping
    public ResponseEntity<List<RecomendacaoDTO>> getAllRecomendacoes() {
        List<RecomendacaoDTO> recomendacoes = recomendacaoService.findAll();
        return ResponseEntity.ok(recomendacoes);
    }

    @ApiOperation(value = "Cria uma nova recomendação")
    @PostMapping
    public ResponseEntity<RecomendacaoDTO> createRecomendacao(@Valid @RequestBody RecomendacaoDTO recomendacaoDTO) {
        RecomendacaoDTO createdRecomendacao = recomendacaoService.create(recomendacaoDTO);
        return new ResponseEntity<>(createdRecomendacao, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualiza uma recomendação existente")
    @PutMapping("/{id}")
    public ResponseEntity<RecomendacaoDTO> updateRecomendacao(@PathVariable UUID id, @Valid @RequestBody RecomendacaoDTO recomendacaoDTO) {
        RecomendacaoDTO updatedRecomendacao = recomendacaoService.update(id, recomendacaoDTO);
        return ResponseEntity.ok(updatedRecomendacao);
    }

    @ApiOperation(value = "Deleta uma recomendação")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecomendacao(@PathVariable UUID id) {
        recomendacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
