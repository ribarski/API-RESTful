package com.example.SaudeBemEstar.medicamento.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Api(tags = "Medicamentos")
@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @ApiOperation(value = "Retorna todos os medicamentos")
    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> getAllMedicamentos() {
        List<MedicamentoDTO> medicamentos = medicamentoService.findAll();
        return ResponseEntity.ok(medicamentos);
    }

    @ApiOperation(value = "Cria um novo medicamento")
    @PostMapping
    public ResponseEntity<MedicamentoDTO> createMedicamento(@Valid @RequestBody MedicamentoDTO medicamentoDTO) {
        MedicamentoDTO createdMedicamento = medicamentoService.create(medicamentoDTO);
        return new ResponseEntity<>(createdMedicamento, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualiza um medicamento existente")
    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> updateMedicamento(@PathVariable UUID id, @Valid @RequestBody MedicamentoDTO medicamentoDTO) {
        MedicamentoDTO updatedMedicamento = medicamentoService.update(id, medicamentoDTO);
        return ResponseEntity.ok(updatedMedicamento);
    }

    @ApiOperation(value = "Deleta um medicamento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable UUID id) {
        medicamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
