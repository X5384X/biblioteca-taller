package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador extends Usuario implements InterfaceBiblioteca {
    private List<Administrador> admins = new ArrayList<Administrador>();
    Scanner reader =  new Scanner(System.in);

    public Administrador(int id, String nombre, String tipo, Biblioteca b){
        super(id, nombre, tipo, true);
        admins.add(this);
        b.nuevoUsuario(this);
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

    public boolean verDisponibilidad(Usuario a, Libro l){
        if(a.esAdmin()){
            if (l.getEjemplaresDisponibles() >= 1) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    public Usuario encontrarUsuarioConId(Usuario a, int b, Biblioteca c){
        List<Usuario> usuarios = listaUsuarios(c);
        if(a.esAdmin()){
            for(Usuario usuario: usuarios){
                if(usuario.getId() == b){
                    return usuario;
                }
            }
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
        return null;
    }

    public void modificarUsuario(Usuario a, int id, Biblioteca c){
        if(a.esAdmin()){
            Usuario usuarioModificar = encontrarUsuarioConId(a, id, c);
            System.out.print("Seleccione nuevo nombre: ");
            usuarioModificar.setNombre(reader.nextLine());
            System.out.print("Tipo: ");
            usuarioModificar.setTipo(reader.nextLine());
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    public void eliminarUsuario(Usuario a, int b, Biblioteca c){
        if(a.esAdmin()){
            Usuario usuarioEncontrado = encontrarUsuarioConId(a, b, c);
            if(usuarioEncontrado == null){
                System.out.println("Usuario no existe.");
            } else {
                c.quitarUsuario(usuarioEncontrado);
            }
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    public void agregarUsuario(Usuario a, Biblioteca c){
        if(a.esAdmin()){
            System.out.println("Creae un nuevo usuario");
            int nuevoUsuarioId = (int) Math.random();
            System.out.print("Nombre: ");
            String nombre = reader.nextLine();
            System.out.print("Tipo: ");
            String tipo = reader.nextLine();

            if (!listaUsuarios(c).contains(nuevoUsuarioId)) {
                System.out.println("Usuario creado");
                Usuario usuario = new Usuario(nuevoUsuarioId, nombre, tipo, false);
                c.nuevoUsuario(usuario);
            } else {
                System.out.println("Usuario ya existe. Intente escoger un usuario distinto.");
            }
        } else { 
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    @Override
    public void agregarLibro(Biblioteca b, Usuario a, String titulo, String autor, String categoria, int ejemplaresDisponibles){
        if(a.esAdmin()){
            b.ingresarLibro(titulo, autor, categoria, ejemplaresDisponibles);
        } else { 
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    @Override
    public void modificarLibro(Biblioteca b, Usuario a, int index){
        List<Libro> listaLibros = new ArrayList<>();
        listaLibros.addAll(listaLibros(b));
        if(a.esAdmin()){
            Libro libro = listaLibros.get(index);
            System.out.print("Nuevo titulo: ");
            libro.setTitulo(reader.nextLine());
            System.out.println("Nuevo autor:");
            libro.setAutor(reader.nextLine());
            System.out.println("Nueva categoria:");
            libro.setCategoria(reader.nextLine());
            System.out.println("Nueva cantidad de ejemplares:");
            libro.setEjemplaresDisponibles(reader.nextInt());
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

    @Override
    public void eliminarLibro(Biblioteca b, Usuario a, int index){
        if(a.esAdmin()){
            b.quitarLibro(index);
        } else {
            throw new IllegalArgumentException("No se tienen los permisos suficientes.");
        }
    }

}