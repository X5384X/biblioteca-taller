package org.example;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

    List<Libro> libros = new ArrayList<>();

    public void agregarLibro(String titulo, String autor, String categoria, int ejemplaresDisponibles){
        libros.add(new Libro(titulo, autor, categoria, ejemplaresDisponibles));
    }

    public void modificarLibro(){

    }

    public void eliminarLibro(){

    }

    public void prestamo(){

    }

    public void devolucion(){

    }
    
    public void renovacion(){

    }

    public void busqueda(String titulo){
        for (Libro libro : libros) {
            if (titulo.equals(libro.getTitulo())){
                System.out.println(libro.toString());
                break;
            }
        }
        System.out.println("No se ha encontrado el libro especificado");
    }

    public void registroUsuario(){
        
    }
}