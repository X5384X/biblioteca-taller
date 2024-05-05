package org.example;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Biblioteca {

    List<Libro> libros = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public abstract void agregarLibro(Biblioteca b, Usuario u, String titulo, String autor, String categoria, int ejemplaresDisponibles);

    public abstract void modificarLibro(Biblioteca b, Usuario u, int index);

    public abstract void eliminarLibro(Biblioteca b, Usuario u, int index);

    public Libro prestamo(String busqueda, int num){
        ArrayList<Libro> libPrestamo = busqueda(busqueda, num);
        System.out.println("Elija el numero del libro que desea elejir");
        int i = 0;
        for (Libro libro : libPrestamo) {
            System.out.println("["+i+"] "+libro.toString());
            i++;
        }
        int e = scn.nextInt();
        Libro libP = libPrestamo.get(e);
        LocalDate fp = libP.getFechaPrestamo();
        LocalDate fd = libP.getFechaDevolucion();
        fp = LocalDate.now();
        System.out.println("La fecha del prestamo es: "+fp);
        fd = fp.plusDays(7);
        System.out.println("La fecha de devolución es: "+fd);
        libP.setFechaPrestamo(fp);
        libP.setFechaDevolucion(fd);
        return libP;
    }

    public void devolucion(Usuario u){
        int n = 0;
        System.out.println("Elija el numero del libro que desea devolver");
        for (Libro libro : u.getHistorialPrestamos()) {
            System.out.println("["+n+"] "+libro.toString());
            n++;
        }
        int e = scn.nextInt();
        u.getHistorialPrestamos().remove(e);
    }
    
    public void renovacion(Usuario u){
        int n = 0;
        System.out.println("Elija el libro que desea renovar");
        for (Libro libro : u.getHistorialPrestamos()) {
            System.out.println("["+n+"] "+libro.toString());
            n++;
        }
        int e = scn.nextInt();
        Libro libD = u.getHistorialPrestamos().get(e);
        LocalDate fp = libD.getFechaPrestamo();
        LocalDate fd = libD.getFechaDevolucion();
        fp = fd;
        System.out.println("La fecha de renovación es: "+fp);
        fd = fd.plusDays(7);
        System.out.println("La nueva fecha de devolución es: "+fd);
        libD.setFechaPrestamo(fp);
        libD.setFechaDevolucion(fd);
    }

    public ArrayList busqueda(String busqueda, int num){
        ArrayList<Libro> libEncontrados = new ArrayList<>();
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
        System.out.println("Introduzca su nombre de usuario:");
        String nombre = scn.next();
        return new Usuario(0, nombre, null);
    }

    public List<Libro> getLibros(){
        return libros;
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public static void quitarUsuario(Usuario n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarUsuario'");
    }

    public void nuevoUsuario(Usuario u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nuevoUsuario'");
    }

    public static void ingresarLibro(String titulo, String autor, String categoria, int ejemplaresDisponibles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ingresarLibro'");
    }

    public void quitarLibro(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarLibro'");
    }
}