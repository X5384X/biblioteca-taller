package org.example;

public class Administrador extends Usuario{
    private int adminId;

    public Administrador(int adminId, String nombre, String tipo){
        super(nombre, tipo);
        this.adminId = adminId;
    }

    public int getAdminId(){
        return adminId;
    }
    
    public void modificarUsuario(){}

    public void eliminarUsuario(){}

    public void agregarUsuario(){}

    public void agregarLibro(){}

    public void modificarLibro(){}

    public void eliminarLibro(){}

    public static boolean verDisponibilidad(){
        return true;
    }

}