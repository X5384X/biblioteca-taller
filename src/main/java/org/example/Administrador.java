package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.example.Usuario;

public class Administrador extends Biblioteca {
    private int id;
    private String name;
    private String tipo;
    private List<Administrador> admins = new ArrayList<Administrador>();
    Scanner reader =  new Scanner(System.in);

    public Administrador(int id, String nombre, String tipo){
        this.id = id;
        this.name = nombre;
        this.tipo = tipo;
        admins.add(this);
        Biblioteca.nuevoUsuario(this);
    }
    
    private boolean verificarPermisos(int i){
        return admins.contains(i);
    }

    public List<Usuario> listaUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(Biblioteca.getUsuarios());
        return usuarios;
    }

    public List<Libro> listaLibros(){
        List<Libro> libros = new ArrayList<>();
        libros.add(Biblioteca.getLibros());
        return libros;
    }

    public boolean verDisponibilidad(Libro l){
        return true;
    }

    public void encontrarUsuarioConId(Usuario a, int b){
        List<Usuario> usuarios = listaUsuarios();
        if(verificarPermisos(a.getId())){
            List<Usuario> usuarioEncontrado = usuarios.stream()
            .filter(user -> user.getId() == b)
            .collect(Collectors.toList());
            if(usuarioEncontrado.size() < 1){
                System.out.println("Usuario no existe.");
            } else {
                Usuario n = usuarioEncontrado.get(0);
            }
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    public void modificarUsuario(Usuario a, int id){
        if(verificarPermisos(a.getId())){
            // definir el metodo
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    public void eliminarUsuario(Usuario a, int b){
        List<Usuario> usuarios = listaUsuarios();
        if(verificarPermisos(a.getId())){
            List<Usuario> usuarioEncontrado = usuarios.stream()
            .filter(user -> user.getId() == b)
            .collect(Collectors.toList());
            if(usuarioEncontrado.size() < 1){
                System.out.println("Usuario no existe.");
            } else {
                Usuario n = usuarioEncontrado.get(0);
                Biblioteca.quitarUsuario(n);
            }
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    public void agregarUsuario(Usuario a){
        if(verificarPermisos(a.getId())){
            System.out.println("Crear un nuevo usuario");
            int nuevoUsuarioId = (int) Math.random();
            System.out.print("Nombre: ");
            String nombre = reader.nextLine();
            System.out.print("Tipo: ");
            String tipo = reader.nextLine();

            if (!listaUsuarios().contains(nuevoUsuarioId)) {
                System.out.println("Usuario creado");
                Usuario usuario = new Usuario(nuevoUsuarioId, nombre, tipo);
                Biblioteca.nuevoUsuario(usuario);
            } else {
                System.out.println("Usuario ya existe. Intente escoger un usuario distinto.");
            }
        }
    }

    @Override
    public void  agregarLibro(String titulo, String autor, String categoria, int ejemplaresDisponibles){
        Usuario a; 
        id = a.getId();
        if(verificarPermisos(id)){
            Biblioteca.ingresarLibro(titulo, autor, categoria, ejemplaresDisponibles);
        } else { 
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    @Override
    public void modificarLibro(int index){
        Usuario admin;
        id = admin.getId();
        List<Libro> listaLibros = listaLibros();
        if(verificarPermisos(id)){
            Libro libro = listaLibros.get(index);
            System.out.print("Titulo: ");
            libro.setTitulo(reader.nextLine());
            System.out.println("Autor:");
            libro.setAutor(reader.nextLine());
            System.out.println("Categoria:");
            libro.setCategoria(reader.nextLine());
            System.out.println("Ejemplares:");
            libro.setEjemplaresDisponibles(reader.nextInt());
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    @Override
    public void eliminarLibro(int index){
        Usuario admin;
        id = admin.getId();
        if(verificarPermisos(id)){
            Biblioteca.quitarLibro(index);
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

}