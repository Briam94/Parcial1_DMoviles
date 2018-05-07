package com.example.usuario.myapplication.Modelos;

public class Usuarios {

    private Integer id;
    private String correo;
    private String contrasena;

    public Usuarios(Integer id, String correo, String contrasena) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
