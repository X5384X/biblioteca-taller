package org.example;

public class Administrador extends Usuario{
    private int adminId;

    public Administrador(int adminId, String nombre, String tipo){
        super(nombre, tipo);
        this.adminId = adminId;
    }
    
    public static void modificarUsuario(){}

    public static void eliminarUsuario(){}

    public static void agregarUsuario(){}

    public static void agregarLibro(){}

    public static void modificarLibro(){}

    public static void eliminarLibro(){}

    public static boolean verDisponibilidad(){
        return true;
    }

}