package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Biblioteca {

    List<Libro> libros = new ArrayList<>();

    public abstract void agregarLibro(String titulo, String autor, String categoria, int ejemplaresDisponibles);

    public abstract void modificarLibro(int index);

    public abstract void eliminarLibro(int index);

    public Libro prestamo(String busqueda, int num){
        List<Libro> libPrestamo = busqueda(busqueda, num);
        System.out.println("Elija el numero del libro que desea elejir");
        int i = 0;
        for (Libro libro : libPrestamo) {
            System.out.println("[i] "+libro.toString());
            i++;
        }
        Libro libP = libPrestamo.get(i);
        return libP;
    }

    public void devolucion(){

    }
    
    public void renovacion(){

    }

    public List busqueda(String busqueda, int num){
        List<Libro> libEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (num == 1) {
                if (busqueda.toLowerCase().equals(libro.getTitulo().toLowerCase())){
                    libEncontrados.add(libro);
                    System.out.println(libro.toString());
                }
            } else if (num == 2) {
                if (busqueda.toLowerCase().equals(libro.getAutor().toLowerCase())){
                    libEncontrados.add(libro);
                    System.out.println(libro.toString());
                }
            } else if (num == 3) {
                if (busqueda.toLowerCase().equals(libro.getCategoria().toLowerCase())){
                    libEncontrados.add(libro);
                    System.out.println(libro.toString());
                }
            }
        }
        if (libEncontrados.size()==0) System.out.println("No se ha encontrado el libro especificado"); 
        return libEncontrados;
    }

    public Usuario registroUsuario(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Introduzca su nombre de usuario:");
        String nombre = scn.next();
        return new Usuario(0, nombre, null);
    }

    public void gestLibros(){

    }

    public void gestUsuarios(){

    }
}