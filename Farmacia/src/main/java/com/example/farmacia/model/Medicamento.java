package com.example.farmacia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "medicamentos",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "codigo")
        }
)
public class Medicamento {

    // =========================
    // PK técnica
    // =========================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // Identificador de negocio
    // =========================
    @Column(nullable = false, length = 20)
    private String codigo; // Ej: MED-000123

    // =========================
    // Datos básicos
    // =========================
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false, length = 100)
    private String laboratorio;

    // =========================
    // Comercial
    // =========================
    @Column(nullable = false)
    private double precio;

    // =========================
    // Inventario
    // =========================
    @Column(nullable = false)
    private int stock;

    // =========================
    // Control legal
    // =========================
    @Column(nullable = false)
    private boolean requiereReceta;

    // =========================
    // Control sanitario
    // =========================
    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    // =========================
    // Auditoría
    // =========================
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    // =========================
    // Constructores
    // =========================
    public Medicamento() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Medicamento(String codigo, String nombre, String descripcion,
                       String laboratorio, double precio, int stock,
                       boolean requiereReceta, LocalDate fechaVencimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.precio = precio;
        this.stock = stock;
        this.requiereReceta = requiereReceta;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaRegistro = LocalDateTime.now();
    }

    // =========================
    // Getters y Setters
    // =========================
    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isRequiereReceta() {
        return requiereReceta;
    }

    public void setRequiereReceta(boolean requiereReceta) {
        this.requiereReceta = requiereReceta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
}
