package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BibliotecaTest {

    private Biblioteca biblioteca;
    private Usuario usuarioMock;
    private Libro libroMock;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        usuarioMock = mock(Usuario.class);
        libroMock = mock(Libro.class);
        when(libroMock.getTitulo()).thenReturn("El Quijote");
        when(libroMock.getAutor()).thenReturn("Miguel de Cervantes");
        when(libroMock.getCategoria()).thenReturn("Novela");
        when(libroMock.getFechaPrestamo()).thenReturn(LocalDate.now());
        when(libroMock.getFechaDevolucion()).thenReturn(LocalDate.now().plusDays(7));
    }

    @Test
    void testPrestamo() {
        biblioteca.ingresarLibro("El Quijote", "Miguel de Cervantes", "Novela", 3);
        Libro libroPrestado = biblioteca.prestamo("El Quijote", 1);
        assertNotNull(libroPrestado);
        assertEquals("El Quijote", libroPrestado.getTitulo());
        assertEquals(LocalDate.now(), libroPrestado.getFechaPrestamo());
        assertEquals(LocalDate.now().plusDays(7), libroPrestado.getFechaDevolucion());
    }

    @Test
    void testDevolucion() {
        List<Libro> prestamos = new ArrayList<>();
        prestamos.add(libroMock);
        when(usuarioMock.getHistorialPrestamos()).thenReturn(prestamos);
        biblioteca.devolucion(usuarioMock);
        verify(usuarioMock).getHistorialPrestamos();
    }

    @Test
    void testRenovacion() {
        List<Libro> prestamos = new ArrayList<>();
        prestamos.add(libroMock);
        when(usuarioMock.getHistorialPrestamos()).thenReturn(prestamos);
        biblioteca.renovacion(usuarioMock);
        verify(libroMock).setFechaPrestamo(LocalDate.now().plusDays(7));
        verify(libroMock).setFechaDevolucion(LocalDate.now().plusDays(14));
    }

    @Test
    void testBusquedaPorTitulo() {
        biblioteca.ingresarLibro("El Quijote", "Miguel de Cervantes", "Novela", 3);
        ArrayList<Libro> resultados = biblioteca.busqueda("El Quijote", 1);
        assertEquals(1, resultados.size());
        assertEquals("El Quijote", resultados.get(0).getTitulo());
    }

    @Test
    void testRegistroUsuario() {
        Usuario usuario = biblioteca.registroUsuario();
        assertNotNull(usuario);
        assertEquals(0, usuario.getId());
        assertFalse(usuario.esAdmin());
    }

    @Test
    void testIngresarYQuitarLibro() {
        biblioteca.ingresarLibro("El Quijote", "Miguel de Cervantes", "Novela", 3);
        assertEquals(1, biblioteca.getLibros().size());
        biblioteca.quitarLibro(0);
        assertEquals(0, biblioteca.getLibros().size());
    }

    @Test
    void testNuevoYQuitarUsuario() {
        biblioteca.nuevoUsuario(usuarioMock);
        assertEquals(1, biblioteca.getUsuarios().size());
        biblioteca.quitarUsuario(usuarioMock);
        assertEquals(0, biblioteca.getUsuarios().size());
    }
}
