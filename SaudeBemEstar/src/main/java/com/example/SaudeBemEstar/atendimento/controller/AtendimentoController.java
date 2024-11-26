package com.example.SaudeBemEstar.atendimento.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.SaudeBemEstar.atendimento.dto.AtendimentoDTO;
import com.example.SaudeBemEstar.atendimento.service.AtendimentoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/atendimentos")
@Log4j2
@RequiredArgsConstructor
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<List<AtendimentoDTO>> buscarAtendimentos() {
        return ResponseEntity.ok(atendimentoService.buscarAtendimentos());
    }

    // Buscar atendimento pageable
    @GetMapping("/find")
    public ResponseEntity<Page<AtendimentoDTO>> buscarAtendimentos(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.unsorted());
        return ResponseEntity.ok(atendimentoService.buscarAtendimentos(pageable));
    }

    // Buscar atendimento por ID
    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> buscarAtendimentoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(atendimentoService.buscarAtendimentoPorId(id));
    }

    // Criar atendimento
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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