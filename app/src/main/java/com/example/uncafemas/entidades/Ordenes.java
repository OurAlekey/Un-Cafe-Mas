package com.example.uncafemas.entidades;

public class Ordenes {

    int codigo;
    String descipcion;
    int cantidad;
    int monto;

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    int precio;
    int idOrdeen;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdOrdeen() {
        return idOrdeen;
    }

    public void setIdOrdeen(int idOrdeen) {
        this.idOrdeen = idOrdeen;
    }
}
