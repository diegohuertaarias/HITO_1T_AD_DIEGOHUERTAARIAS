package com.example.demo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}