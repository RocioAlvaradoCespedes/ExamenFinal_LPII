package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Libro;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;

@Repository
public interface ReporteRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT COUNT(l) FROM Libro l WHERE l.fechaPublicacion BETWEEN ?1 AND ?2")
    int contarLibrosPorFechaPublicacion(LocalDate fechaInicio, LocalDate fechaFin);
}