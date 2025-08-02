package com.negocio.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Producto> productos;
    private List<Integer> cantidades;
    private LocalDateTime fecha;
    private double total;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.total = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
        calcularTotal();
    }

    // ERROR 5: Cálculo incorrecto del total (suma precios sin considerar cantidades)
    private void calcularTotal() {
        total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }
    }

    // ERROR 6: Método que puede causar IndexOutOfBoundsException
    public Producto obtenerPrimerProducto() {
        if (productos.isEmpty()) {
            return null; // Evitar excepción si está vacío
        }
        return productos.get(0);
    }

    // ERROR 7: Descuento mal aplicado
    public double aplicarDescuento(double porcentaje) {
        // Aplica el descuento sumándolo en lugar de restándolo
        return total - (total * porcentaje / 100);
    }

    // Getters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<Producto> getProductos() { return productos; }
    public List<Integer> getCantidades() { return cantidades; }
    public LocalDateTime getFecha() { return fecha; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNombre() +
                ", productos=" + productos.size() +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}
