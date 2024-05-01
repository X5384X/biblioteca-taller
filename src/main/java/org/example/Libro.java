package org.example;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private String autor;
    private String categoria;
    private int ejemplaresDisponibles;
    private List<Integer> calificaciones;
    private List<String> comentarios;

    public Libro(String titulo, String autor, String categoria, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }
}