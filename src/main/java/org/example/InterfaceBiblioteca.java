package org.example;

public interface InterfaceBiblioteca {
    public abstract void agregarLibro(Biblioteca b, Usuario u, String titulo, String autor, String categoria, int ejemplaresDisponibles);

    public abstract void modificarLibro(Biblioteca b, Usuario u, int index);

    public abstract void eliminarLibro(Biblioteca b, Usuario u, int index);
}
