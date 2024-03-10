package com.example.demo.controllers;

import com.example.demo.model.Genero;
import com.example.demo.model.Libro;
import com.example.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public String getAllLibros(Model model) {
        List<Libro> libros = libroService.getAllLibros();
        model.addAttribute("libro", libros);
        return "librosList";
    }

    @GetMapping("/registrar")
    public String showRegistrarForm(Model model) {
    
        model.addAttribute("libros", new Libro());
        return "registrarLibro";
    }

    @PostMapping("/registrar")
    public String registrarLibro(@ModelAttribute Libro libro, Model model) {
        libroService.createLibro(libro);
        return "redirect:/libro/libros";
    }

    @GetMapping("/editar/{id}")
    public String showEditarForm(@PathVariable Long id, Model model) {
        Libro libro = libroService.getLibroById(id);
        model.addAttribute("libro", libro);
        return "editarLibro";
    }

    @PostMapping("/editar")
    public String editarLibro(@ModelAttribute Libro libro, Model model) {
        libroService.updateLibro(libro);
        return "redirect:/libro/libros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id, Model model) {
        libroService.deleteLibro(id);
        return "redirect:/libro/libros";
    }
}