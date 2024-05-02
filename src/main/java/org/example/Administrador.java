package org.example;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario{
    private List<Administrador> admins = new ArrayList<Administrador>();

    public Administrador(int id, String nombre, String tipo){
        super(id, nombre, tipo);
        admins.add(this);
    }
    
    private boolean verificarPermisos(int i){
        return admins.contains(i);
    }

    public void agregarLibro(Usuario u){
        Libro l;
        if(verificarPermisos(u.getId())){
            // listaLibros.add(l);
        };
    }

    public static boolean verDisponibilidad(Libro l){
        return true;
    }

}