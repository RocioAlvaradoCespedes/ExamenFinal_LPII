package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlibro", nullable = false)
    private Long idLibro;

    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

    @Column(name = "autor", nullable = false, length = 60)
    private String autor;

    @Column(name = "fechapublicacion", nullable = false)
    private Date fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "idgenero", nullable = false)
    private Genero genero;

    // Constructores, getters y setters
}