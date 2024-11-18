package com.example.demo;


import jakarta.persistence.*;
import com.example.demo.VentaProductoId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VentaProducto {
    @EmbeddedId
    private VentaProductoId id;

    @ManyToOne
    @MapsId("idVenta")
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private int cantidad;
    private double total;


}