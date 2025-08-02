package com.negocio.services;

import com.negocio.models.Producto;
import java.util.ArrayList;
import java.util.List;

public class InventarioService {
    private List<Producto> productos;

    public InventarioService() {
        this.productos = new ArrayList<>();
        inicializarProductos();
    }

    // Al iniciar el programa verifica si ya existe el producto, y si no existe, lo crea
    private void inicializarProductos() {
        if (buscarProductoPorId(1)== null){
            productos.add(new Producto(1, "Hamburguesa", 15.50, 20));
        }
        if (buscarProductoPorId(2)== null){
        productos.add(new Producto(2, "Pizza", 25.00, 15));
        }
        if (buscarProductoPorId(3)== null){
        productos.add(new Producto(3, "Tacos", 8.75, 30));
        }
        if (buscarProductoPorId(4)== null){
        productos.add(new Producto(4, "Refresco", 3.50, 50));
        }
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public boolean venderProducto(int id, int cantidad) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null && producto.hayStock(cantidad)) {
            producto.reducirStock(cantidad);
            System.out.println("Venta realizada: " + producto.getNombre() + ", cantidad: " + cantidad);
            return true;
        }
        return false;
    }

    public List<Producto> obtenerProductosDisponibles() {
        List<Producto> disponibles = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getStock() > 0) {
                disponibles.add(producto);
            }
        }
        return disponibles;
    }
    public boolean eliminarProducto(int id) {
       if (productos != null) {
           System.out.println("Eliminando producto: " + productos.get(id).getNombre());
       }
        return false;
    }

    public boolean agregarNuevoProducto(Producto nuevoProducto) {
        if (existeProductoConNombre(nuevoProducto.getNombre())) {
            System.out.println("Error: Ya existe un producto con ese nombre.");
            return false;
        }
        productos.add(nuevoProducto);
        System.out.println("Producto agregado exitosamente: " + nuevoProducto.getNombre());
        return true;
    }

    public boolean existeProductoConNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return true; // Ya existe
            }
        }
        return false; // No existe
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productos;
    }
}