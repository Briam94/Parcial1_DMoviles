package com.example.usuario.myapplication.Utilidades;

public class Utilidades {

    //Contantes de la tabla Usuarios

    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_CORREO = "correo";
    public static final String CAMPO_CONTRASEÑA = "contraseña";

    public static final String CREAR_TABLA_USUARIO= "CREATE TABLE "+
            TABLA_USUARIO +" ("+ CAMPO_ID +" INTEGER, "+ CAMPO_CORREO +" TEXT, "+ CAMPO_CONTRASEÑA +" TEXT) ";
}
