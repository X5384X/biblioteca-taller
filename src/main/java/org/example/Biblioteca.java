package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Biblioteca {

    List<Libro> libros = new ArrayList<>();

    public abstract void agregarLibro(String titulo, String autor, String categoria, int ejemplaresDisponibles);

    public abstract void modificarLibro(int index);

    public abstract void eliminarLibro(int index);

    public void prestamo(){

    }

    public void devolucion(){

    }
    
    public void renovacion(){

    }

    public void busqueda(String titulo){
        List<Libro> libEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (titulo.toLowerCase().equals(libro.getTitulo().toLowerCase())){
                libEncontrados.add(libro);
                System.out.println(libro.toString());
            }
        }
        if (libEncontrados.size()==0) System.out.println("No se ha encontrado el libro especificado"); 
    }

    public void registroUsuario(){
        
    }
}