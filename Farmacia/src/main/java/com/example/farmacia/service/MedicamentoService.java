package com.example.farmacia.service;

import com.example.farmacia.model.Medicamento;
import com.example.farmacia.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public Medicamento crear(Medicamento medicamento) {

        if (medicamentoRepository.existsByCodigo(medicamento.getCodigo())) {
            throw new RuntimeException("Ya existe un medicamento con ese código");
        }

        return medicamentoRepository.save(medicamento);
    }

    public List<Medicamento> listarTodos() {
        return medicamentoRepository.findAll();
    }

    public Medicamento obtenerPorId(Long id) {
        return medicamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));
    }

    public Medicamento actualizar(Long id, Medicamento medicamento) {

        Medicamento existente = obtenerPorId(id);

        existente.setCodigo(medicamento.getCodigo());
        existente.setNombre(medicamento.getNombre());
        existente.setDescripcion(medicamento.getDescripcion());
        existente.setLaboratorio(medicamento.getLaboratorio());
        existente.setPrecio(medicamento.getPrecio());
        existente.setStock(medicamento.getStock());
        existente.setRequiereReceta(medicamento.isRequiereReceta());
        existente.setFechaVencimiento(medicamento.getFechaVencimiento());

        return medicamentoRepository.save(existente);
    }

    public void eliminar(Long id) {
        Medicamento medicamento = obtenerPorId(id);
        medicamentoRepository.delete(medicamento);
    }
}
