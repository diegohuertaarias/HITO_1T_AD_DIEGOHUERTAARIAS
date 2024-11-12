package com.example.demo.Repositorios;

import com.example.demo.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}