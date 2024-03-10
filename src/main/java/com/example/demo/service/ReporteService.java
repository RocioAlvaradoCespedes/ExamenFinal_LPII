package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.example.demo.repository.LibroRepository;

@Service
public class ReporteService {

    @Autowired
    private LibroRepository libroRepository;

    public int obtenerCantidadLibrosUltimosSeisMeses() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicio = fechaActual.minusMonths(6);
        return libroRepository.contarLibrosPorFechaPublicacion(fechaInicio, fechaActual);
    }
}