package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Biblioteca {

    List<Libro> libros = new ArrayList<>();

    public void agregarLibro(String titulo, String autor, String categoria, int ejemplaresDisponibles){
        libros.add(new Libro(titulo, autor, categoria, ejemplaresDisponibles));
    }

    public void modificarLibro(int index){
        Scanner scn = new Scanner(System.in);
        Libro libro = libros.get(index);
        System.out.println(libro.toString());
        String titulo = scn.next();
        libro.setTitulo(titulo);
        String autor = scn.next();
        libro.setAutor(autor);
        String categoria = scn.next();
        libro.setCategoria(categoria);
        int numDisponibles = scn.nextInt();
        libro.setEjemplaresDisponibles(numDisponibles);
        libros.add(index, libro);
    }

    public void eliminarLibro(int index){

    }

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