package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Administrador extends Biblioteca {
    private int id;
    private String name;
    private String tipo;
    private List<Administrador> admins = new ArrayList<Administrador>();
    Scanner reader =  new Scanner(System.in);

    public Administrador(int id, String nombre, String tipo, Biblioteca b){
        this.id = id;
        this.name = nombre;
        this.tipo = tipo;
        admins.add(this);
        Usuario admin = new Usuario(id, nombre, tipo);
        b.nuevoUsuario(admin);
    }
    
    private boolean verificarPermisos(int i){
        return admins.contains(i);
    }

    public List<Usuario> listaUsuarios(Biblioteca b){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(b.getUsuarios());
        return usuarios;
    }

    public List<Libro> listaLibros(Biblioteca b){
        List<Libro> libros = new ArrayList<>();
        libros.addAll(b.getLibros());
        return libros;
    }

    public boolean verDisponibilidad(Libro l){
        return true;
    }

    public void encontrarUsuarioConId(Usuario a, int b, Biblioteca c){
        List<Usuario> usuarios = listaUsuarios(c);
        if(verificarPermisos(a.getId())){
            List<Usuario> usuarioEncontrado = usuarios.stream()
            .filter(user -> user.getId() == b)
            .collect(Collectors.toList());
            if(usuarioEncontrado.size() < 1){
                System.out.println("Usuario no existe.");
            } else {
                Usuario n = usuarioEncontrado.get(0);
                System.out.println(n.toString());
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

    public void eliminarUsuario(Usuario a, int b, Biblioteca c){
        List<Usuario> usuarios = listaUsuarios(c);
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

    public void agregarUsuario(Usuario a, Biblioteca c){
        if(verificarPermisos(a.getId())){
            System.out.println("Creae un nuevo usuario");
            int nuevoUsuarioId = (int) Math.random();
            System.out.print("Nombre: ");
            String nombre = reader.nextLine();
            System.out.print("Tipo: ");
            String tipo = reader.nextLine();

            if (!listaUsuarios(c).contains(nuevoUsuarioId)) {
                System.out.println("Usuario creado");
                Usuario usuario = new Usuario(nuevoUsuarioId, nombre, tipo);
                c.nuevoUsuario(usuario);
            } else {
                System.out.println("Usuario ya existe. Intente escoger un usuario distinto.");
            }
        }
    }

    @Override
    public void  agregarLibro(Biblioteca b, Usuario a, String titulo, String autor, String categoria, int ejemplaresDisponibles){
        if(verificarPermisos(a.getId())){
            b.ingresarLibro(titulo, autor, categoria, ejemplaresDisponibles);
        } else { 
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    @Override
    public void modificarLibro(Biblioteca b, Usuario a, int index){
        List<Libro> listaLibros = new ArrayList<>();
        listaLibros.addAll(listaLibros(b));
        if(verificarPermisos(a.getId())){
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
    public void eliminarLibro(Biblioteca b, Usuario a, int index){
        if(verificarPermisos(a.getId())){
            b.quitarLibro(index);
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

}