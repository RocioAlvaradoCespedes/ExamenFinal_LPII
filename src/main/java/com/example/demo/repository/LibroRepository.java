package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

	int contarLibrosPorFechaPublicacion(LocalDate fechaInicio, LocalDate fechaActual);
}

