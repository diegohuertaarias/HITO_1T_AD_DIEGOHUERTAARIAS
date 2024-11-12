package com.example.demo.Repositorios;

import com.example.demo.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}