package com.example.usuario.myapplication.Modelos;

public class Ventas {

    private Integer idVentas;

    private String  cliente, producto, tiempo, precio;

    public Ventas(Integer idVentas, String cliente, String producto, String tiempo, String precio) {
        this.idVentas = idVentas;
        this.cliente = cliente;
        this.producto = producto;
        this.tiempo = tiempo;
        this.precio = precio;
    }

    public Ventas() {

    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
