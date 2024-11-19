package com.example.SaudeBemEstar.atendimento.controller;

import com.example.SaudeBemEstar.atendimento.dto.AtendimentoDTO;
import com.example.SaudeBemEstar.atendimento.service.AtendimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atendimentos")
@Log4j2
@RequiredArgsConstructor
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<Page<AtendimentoDTO>> buscarAtendimentos(Pageable pageable) {
        return ResponseEntity.ok(atendimentoService.buscarAtendimentos(pageable));
    }

    // Buscar atendimento por nome (com paginação)
    @GetMapping("/find")
    public ResponseEntity<Page<AtendimentoDTO>> buscarAtendimentosPorNome(@RequestParam String name, Pageable pageable) {
        return ResponseEntity.ok(atendimentoService.buscarAtendimentosPorNome(name, pageable));
    }

    // Buscar atendimento por ID
    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> buscarAtendimentoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(atendimentoService.buscarAtendimentoPorId(id));
    }

    // Criar atendimento
    @PostMapping
    public ResponseEntity<AtendimentoDTO> criarAtendimento(@RequestBody @Valid AtendimentoDTO atendimentoDTO) {
        return new ResponseEntity<>(atendimentoService.criarAtendimento(atendimentoDTO), HttpStatus.CREATED);
    }

    // Atualizar atendimento
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarAtendimento(@PathVariable Long id, @RequestBody @Valid AtendimentoDTO atendimentoDTO) {
        atendimentoService.atualizarAtendimento(id, atendimentoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Remover atendimento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAtendimento(@PathVariable Long id) {
        atendimentoService.removerAtendimento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}