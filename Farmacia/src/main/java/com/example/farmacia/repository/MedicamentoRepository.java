package com.example.farmacia.repository;

import com.example.farmacia.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    Optional<Medicamento> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);
}
