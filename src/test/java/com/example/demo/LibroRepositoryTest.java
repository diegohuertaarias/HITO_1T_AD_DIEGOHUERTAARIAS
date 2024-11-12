package com.example.demo;

import com.example.demo.Repositorios.LibroRepository;
import com.example.demo.entidad.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LibroRepositoryTest {
    @Autowired
    private LibroRepository libroRepository;

    @Test
    public void testCreateLibro() {
        Libro libro = new Libro();
        libro.setTitulo("Test Book");
        libro.setAutor("Test Author");
        libro.setPrecio(19.99);
        libro.setStock(10);

        Libro savedLibro = libroRepository.save(libro);
        assertThat(savedLibro).isNotNull();
        assertThat(savedLibro.getId()).isNotNull();
    }
}