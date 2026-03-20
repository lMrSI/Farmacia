package com.example.farmacia.controller;

import com.example.farmacia.model.Medicamento;
import com.example.farmacia.service.MedicamentoService;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> c252f0f (push tabla base)

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service) {
        this.service = service;
    }

<<<<<<< HEAD
    @GetMapping
    public List<Medicamento> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
=======
    // =========================
    // CREATE
    // =========================
    @PostMapping
    public ResponseEntity<Medicamento> crear(@RequestBody Medicamento medicamento) {
        Medicamento creado = service.crear(medicamento);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // =========================
    // READ ALL
    // =========================
    @GetMapping
    public List<Medicamento> listar() {
        return service.listarTodos();
    }

    // =========================
    // READ BY ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> obtener(@PathVariable Long id) {
        Medicamento medicamento = service.obtenerPorId(id);
        return ResponseEntity.ok(medicamento);
    }

    // =========================
    // UPDATE
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> actualizar(
            @PathVariable Long id,
            @RequestBody Medicamento medicamento) {

        Medicamento actualizado = service.actualizar(id, medicamento);
        return ResponseEntity.ok(actualizado);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
>>>>>>> c252f0f (push tabla base)
    }
}
