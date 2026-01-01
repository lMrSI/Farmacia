package com.example.farmacia.repository;

import com.example.farmacia.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    // JpaRepository ya trae métodos CRUD básicos: findAll, findById, save, deleteById
}
