package com.example.demo;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VentaProductoId implements Serializable {
    private Long idVenta;
    private Long idProducto;


}