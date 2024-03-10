package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.LibroService;

@Controller
public class ReporteController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/reporte/cantidad-libros-ultimos-seis-meses")
    public String generarReporte(Model model) {
        int cantidadLibros = libroService.obtenerCantidadLibrosUltimosSeisMeses();
        model.addAttribute("cantidadLibros", cantidadLibros);
        return "reporteCantidadLibros";
    }
}