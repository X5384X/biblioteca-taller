package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest{
    private Administrador admin;
    private Biblioteca biblioteca;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        admin = new Administrador(1, "Admin", "Admin", biblioteca);
    }

    @Test
    void listaUsuarios() {
        Usuario user = new Usuario(2, "User", "User", false);
        biblioteca.nuevoUsuario(user);

        List<Usuario> usuarios = admin.listaUsuarios(biblioteca);

        assertEquals(1, usuarios.size());
        assertTrue(usuarios.contains(user));
    }

    @Test
    void listaLibros() {
        Libro libro = new Libro("Title", "Author", "Category", 5);
        biblioteca.ingresarLibro(libro.getTitulo(), libro.getAutor(), libro.getCategoria(), libro.getEjemplaresDisponibles());

        List<Libro> libros = admin.listaLibros(biblioteca);

        assertEquals(1, libros.size());
        assertTrue(libros.contains(libro));
    }

    @Test
    void verDisponibilidad() {
        Libro libro = new Libro("Title", "Author", "Category", 2);

        assertTrue(admin.verDisponibilidad(admin, libro));
        assertFalse(admin.verDisponibilidad(new Usuario(2, "User", "User", false), libro));
    }

    @Test
    void encontrarUsuarioConId() {
        Usuario user = new Usuario(2, "User", "User", false);
        biblioteca.nuevoUsuario(user);

        Usuario encontrado = admin.encontrarUsuarioConId(admin, 2, biblioteca);

        assertEquals(user, encontrado);
    }

    @Test
    void modificarUsuario() {
        Usuario user = new Usuario(2, "User", "User", false);
        biblioteca.nuevoUsuario(user);

        String input = "NewName\nNewType\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        admin.modificarUsuario(admin, 2, biblioteca);

        assertEquals("NewName", user.getNombre());
        assertEquals("NewType", user.getTipo());
    }

    @Test
    void eliminarUsuario() {
        Usuario user = new Usuario(2, "User", "User", false);
        biblioteca.nuevoUsuario(user);

        admin.eliminarUsuario(admin, 2, biblioteca);

        assertEquals(0, biblioteca.getUsuarios().size());
    }

    @Test
    void agregarUsuario() {
        String input = "NewUser\nNewType\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        admin.agregarUsuario(admin, biblioteca);

        assertEquals(1, biblioteca.getUsuarios().size());
    }

    @Test
    void agregarLibro() {
        String input = "NewTitle\nNewAuthor\nNewCategory\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        admin.agregarLibro(biblioteca, admin, "NewTitle", "NewAuthor", "NewCategory", 5);

        assertEquals(1, biblioteca.getLibros().size());
    }

    @Test
    void modificarLibro() {
        Libro libro = new Libro("Title", "Author", "Category", 5);
        biblioteca.ingresarLibro(libro.getTitulo(), libro.getAutor(), libro.getCategoria(), libro.getEjemplaresDisponibles());

        String input = "NewTitle\nNewAuthor\nNewCategory\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        admin.modificarLibro(biblioteca, admin, 0);

        assertEquals("NewTitle", libro.getTitulo());
        assertEquals("NewAuthor", libro.getAutor());
        assertEquals("NewCategory", libro.getCategoria());
        assertEquals(10, libro.getEjemplaresDisponibles());
    }

    @Test
    void eliminarLibro() {
        Libro libro = new Libro("Title", "Author", "Category", 5);
        biblioteca.ingresarLibro(libro.getTitulo(), libro.getAutor(), libro.getCategoria(), libro.getEjemplaresDisponibles());

        admin.eliminarLibro(biblioteca, admin, 0);

        assertEquals(0, biblioteca.getLibros().size());
    }
}