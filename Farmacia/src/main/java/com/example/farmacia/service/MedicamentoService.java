package com.example.farmacia.service;

import com.example.farmacia.model.Medicamento;
import com.example.farmacia.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MedicamentoService {

    private final MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repository){
        this.repository = repository;
    }

    public List<Medicamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Medicamento> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Medicamento guardar(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
