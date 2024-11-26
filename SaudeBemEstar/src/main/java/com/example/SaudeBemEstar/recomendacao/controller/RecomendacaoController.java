package com.example.SaudeBemEstar.recomendacao.controller;

import com.example.SaudeBemEstar.recomendacao.dto.RecomendacaoDTO;
import com.example.SaudeBemEstar.recomendacao.service.RecomendacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/recomendacoes")
@RequiredArgsConstructor
public class RecomendacaoController {

    private final RecomendacaoService recomendacaoService;

    @PostMapping
    public ResponseEntity<RecomendacaoDTO> criarRecomendacao(@RequestBody @Valid RecomendacaoDTO recomendacaoDTO) {
        return ResponseEntity.ok(recomendacaoService.criarRecomendacao(recomendacaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<RecomendacaoDTO>> listarRecomendacoes() {
        return ResponseEntity.ok(recomendacaoService.listarRecomendacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecomendacaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(recomendacaoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarRecomendacao(@PathVariable Long id, @RequestBody @Valid RecomendacaoDTO recomendacaoDTO) {
        recomendacaoService.atualizarRecomendacao(id, recomendacaoDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRecomendacao(@PathVariable Long id) {
        recomendacaoService.deletarRecomendacao(id);
        return ResponseEntity.noContent().build();
    }
}
