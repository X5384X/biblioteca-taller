package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario{
    private int id;
    private String nombre;
    private String tipo; // Estudiante, Profesor, Personal de la Biblioteca
    private List<Usuario> listaUsuarios;
    private List<Libro> historialPrestamos;
    private List<Libro> librosReservados;
    private List<Integer> calificaciones;

    public Usuario(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.historialPrestamos = new ArrayList<>();
        this.librosReservados = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public void agregarPrestamo(Libro libro) {
        historialPrestamos.add(libro);
    }

    public void realizarReserva(Libro libro) {
        librosReservados.add(libro);
    }

    public void agregarCalificacion(int calificacion) {
        calificaciones.add(calificacion);
    }

}