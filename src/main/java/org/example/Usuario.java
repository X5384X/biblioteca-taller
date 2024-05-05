package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario{
    private int id;
    private String nombre;
    private String tipo; // Estudiante, Profesor, Personal de la Biblioteca
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

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
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

    public List<Libro> getHistorialPrestamos() {
        return historialPrestamos;
    }

    public void setHistorialPrestamos(List<Libro> historialPrestamos) {
        this.historialPrestamos = historialPrestamos;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", nombre: " + nombre + ", tipo: " + tipo + "]";
    }
}