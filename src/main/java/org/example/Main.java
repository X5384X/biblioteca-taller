package org.example;

public class Main {
    
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
                
        Administrador a1 = new Administrador(123, "Juanito", "Personal de Biblioteca", b);
        Usuario a2 = new Administrador(2456, "Susana Oria", "Personal de Biblioteca", b);
        Usuario u1 = new Usuario(1234, "Aquiles Brinco", "Estudiante", false);
        b.nuevoUsuario(u1);
        // a1.agregarUsuario(u1, b);
        // a1.agregarLibro(b, u1, "El señor de los anillos", "J.R.R. Tolkien", "Fantasía", 20);
        // System.out.println(b.getLibros());
        
        a1.agregarLibro(b, a1, "Indigno de ser Humano", "Dazai Osamu", "Ficción Moderna", 10);
        a1.agregarLibro(b, a2, "El señor de los anillos", "J.R.R. Tolkien", "Fantasía", 20);
        a1.agregarLibro(b, a1, "Crimen y Castigo", "Fyodor Dostoevsky", "Drama Psicológico", 30);
        a1.agregarLibro(b, a1, "El Ladrón del Rayo", "Rick Riordan", "Fantasía", 2);
        
        //Prestamo y Busqueda por Nombre
        u1.agregarPrestamo(b.prestamo("Indigno de ser Humano", 1));
        System.out.println();
        //Prestamo y Busqueda por Autor
        u1.agregarPrestamo(b.prestamo("J.R.R. Tolkien", 2));
        System.out.println();
        //Prestamo y Busqueda por Categoria
        u1.agregarPrestamo(b.prestamo("Drama Psicológico", 3));
        System.out.println();

        //Devolucion
        b.devolucion(u1);
        System.out.println();

        //Renovacion
        b.renovacion(u1);
        System.out.println();
        
    }
}