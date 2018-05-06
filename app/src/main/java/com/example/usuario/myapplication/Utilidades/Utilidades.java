package com.example.usuario.myapplication.Utilidades;

public class Utilidades {

    //Contantes de la tabla Usuarios

    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_CORREO = "correo";
    public static final String CAMPO_CONTRASEÑA = "contraseña";

    public static final String CREAR_TABLA_USUARIO= "CREATE TABLE "+
            TABLA_USUARIO +" ("+ CAMPO_ID +" INTEGER, "+ CAMPO_CORREO +" TEXT, "+ CAMPO_CONTRASEÑA +" TEXT) ";
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Constantes campos tabla Ventas

    public static final String TABLA_VENTA = "venta";

    public static final String CAMPO_IDVENTA = "idVentas";
    public static final String CAMPO_CLIENTE = "cliente";
    public static final String CAMPO_PRODUCTO = "producto";
    public static final String CAMPO_TIEMPO = "tiempo";
    public static final String CAMPO_PRECIO = "precio";

    public static final String CREAR_TABLA_VENTAS ="CREATE TABLE "+ TABLA_VENTA +
            " ("+ CAMPO_IDVENTA +" INTEGER, "+ CAMPO_CLIENTE +"TEXT, "+ CAMPO_PRODUCTO +" TEXT, "
            + CAMPO_TIEMPO +" TEXT, " + CAMPO_PRECIO + " TEXT)";
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Constantes campos tabla Clientes

    public static final  String TABLA_CLIENTE = "cliente";

    public static final String CAMPO_IDCLIENTE = "idCliente";
    public static final String CAMPO_NOMBRECLIENTE = "nombreCliente";
    public static final String CAMPO_CEDULACLIENTE = "cedulaCliente";
    public static final String CAMPO_CORREOCLIENTE = "correoCliente";
    public static final String CAMPO_TELEFONOCLIENTE = "telefonoCliente";
    public static final String CAMPO_DIRECCIONCLIENTE = "direccionCliente";

    public static final String CREAR_TABLA_CLIENTES = "CREATE TABLE " + TABLA_CLIENTE +
            " (" + CAMPO_IDCLIENTE + " INTEGER, " +  CAMPO_NOMBRECLIENTE + " TEXT, " + CAMPO_CEDULACLIENTE + " TEXT, " +
                CAMPO_CORREOCLIENTE + " TEXT, " + CAMPO_TELEFONOCLIENTE + " TEXT, " + CAMPO_DIRECCIONCLIENTE + " TEXT)";
}
