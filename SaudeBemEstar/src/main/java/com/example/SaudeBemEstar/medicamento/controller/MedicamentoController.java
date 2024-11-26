package com.example.SaudeBemEstar.medicamento.controller;

import com.example.SaudeBemEstar.medicamento.dto.MedicamentoDTO;
import com.example.SaudeBemEstar.medicamento.dto.MedicamentoUpdateDTO;
import com.example.SaudeBemEstar.medicamento.service.MedicamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> buscarTodos() {
        return ResponseEntity.ok(medicamentoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(medicamentoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MedicamentoDTO> criarMedicamento(@RequestBody @Valid MedicamentoDTO medicamentoDTO) {
        MedicamentoDTO criado = medicamentoService.criarMedicamento(medicamentoDTO);
        return ResponseEntity.ok(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarMedicamento(@PathVariable Long id, @RequestBody @Valid MedicamentoUpdateDTO MedicamentoUpdateDTO) {
        medicamentoService.atualizarMedicamento(id, MedicamentoUpdateDTO);
        return ResponseEntity.noContent().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMedicamento(@PathVariable Long id) {
        medicamentoService.removerMedicamento(id);
        return ResponseEntity.noContent().build();
    }
}
