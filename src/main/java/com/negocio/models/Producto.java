package com.negocio.models;

// ERROR 1: Atributos públicos (Mala práctica de encapsulamiento)
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    // ERROR 2: Constructor sin validaciones
    public Producto(int id, String nombre, double precio, int stock) {
        if (id <= 0) throw new IllegalArgumentException("El id debe ser mayor que cero.");
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        if (precio <= 0) throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        if (stock < 0) throw new IllegalArgumentException("El stock no puede ser negativo.");

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public double getPrecio() { return precio; }

    public int getStock() { return stock; }


    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("El id debe ser mayor que cero.");
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("El stock no puede ser negativo.");
        this.stock = stock;
    }

    // ERROR 3: Método que permite stock negativo
    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        if (cantidad > stock) {
            throw new IllegalArgumentException("No hay suficiente stock disponible.");
        }
        this.stock -= cantidad;
    }

    // ERROR 4: Método con lógica incorrecta
    public boolean hayStock(int cantidad) {
        return stock >= cantidad; // Debería ser >= para permitir exactamente la cantidad
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
