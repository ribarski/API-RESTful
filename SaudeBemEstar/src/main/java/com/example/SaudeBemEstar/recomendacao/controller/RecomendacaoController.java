package com.example.SaudeBemEstar.recomendacao.controller;

import com.example.SaudeBemEstar.recomendacao.dto.RecomendacaoDTO;
import com.example.SaudeBemEstar.recomendacao.service.RecomendacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recomendacoes")
@RequiredArgsConstructor
public class RecomendacaoController {

    private final RecomendacaoService recomendacaoService;

    @GetMapping("/atendimento/{atendimentoId}")
    public ResponseEntity<List<RecomendacaoDTO>> buscarPorAtendimento(@PathVariable Long atendimentoId) {
        return ResponseEntity.ok(recomendacaoService.buscarPorAtendimento(atendimentoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecomendacaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(recomendacaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RecomendacaoDTO> criarRecomendacao(@RequestBody @Valid RecomendacaoDTO recomendacaoDTO) {
        return new ResponseEntity<>(recomendacaoService.criarRecomendacao(recomendacaoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarRecomendacao(@PathVariable Long id, @RequestBody @Valid RecomendacaoDTO recomendacaoDTO) {
        recomendacaoService.atualizarRecomendacao(id, recomendacaoDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerRecomendacao(@PathVariable Long id) {
        recomendacaoService.removerRecomendacao(id);
        return ResponseEntity.noContent().build();
    }
}

