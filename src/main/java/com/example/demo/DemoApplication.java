package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Generar Reporte");
            System.out.println("2. Realizar Consulta");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (choice) {
                case 1:
                    generarReporte(scanner);
                    break;
                case 2:
                    realizarConsulta(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
            }
        }
    }

    private void generarReporte(Scanner scanner) {
        System.out.println("Generar Reporte:");
        System.out.println("1. Reporte de Clientes");
        System.out.println("2. Reporte de Productos");
        System.out.println("3. Reporte de Ventas");
        System.out.print("Elige una opción: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        switch (choice) {
            case 1:
                List<Map<String, Object>> clientes = jdbcTemplate.queryForList("SELECT * FROM Cliente");
                System.out.println("Reporte de Clientes:");
                clientes.forEach(cliente -> System.out.println(cliente.toString()));
                break;
            case 2:
                List<Map<String, Object>> productos = jdbcTemplate.queryForList("SELECT * FROM Producto");
                System.out.println("Reporte de Productos:");
                productos.forEach(producto -> System.out.println(producto.toString()));
                break;
            case 3:
                List<Map<String, Object>> ventas = jdbcTemplate.queryForList("SELECT * FROM Venta");
                System.out.println("Reporte de Ventas:");
                ventas.forEach(venta -> System.out.println(venta.toString()));
                break;
            default:
                System.out.println("Opción inválida. Por favor, intenta de nuevo.");
        }
    }

    private void realizarConsulta(Scanner scanner) {
        System.out.println("Realizar Consulta:");
        System.out.println("1. Consultar Clientes");
        System.out.println("2. Consultar Productos");
        System.out.println("3. Consultar Ventas");
        System.out.print("Elige una opción: ");

        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consumir nueva línea
                break;
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida. Por favor, ingresa un número.");
                scanner.next();  // Consumir la entrada inválida
            }
        }

        switch (choice) {
            case 1:
                System.out.print("Ingresa el nombre del cliente a buscar: ");
                String nombreCliente = scanner.nextLine();
                List<Map<String, Object>> clientes = jdbcTemplate.queryForList("SELECT * FROM Cliente WHERE Nombre LIKE ?", new Object[]{"%" + nombreCliente + "%"});
                System.out.println("Clientes Encontrados:");
                clientes.forEach(cliente -> System.out.println(cliente.toString()));
                break;
            case 2:
                System.out.print("Ingresa el nombre del producto a buscar: ");
                String nombreProducto = scanner.nextLine();
                List<Map<String, Object>> productos = jdbcTemplate.queryForList("SELECT * FROM Producto WHERE Nombre LIKE ?", new Object[]{"%" + nombreProducto + "%"});
                System.out.println("Productos Encontrados:");
                productos.forEach(producto -> System.out.println(producto.toString()));
                break;
            case 3:
                System.out.print("Ingresa la fecha de la venta a buscar (YYYY-MM-DD): ");
                String fechaVenta = scanner.nextLine();
                List<Map<String, Object>> ventas = jdbcTemplate.queryForList("SELECT * FROM Venta WHERE Fecha = ?", new Object[]{fechaVenta});
                System.out.println("Ventas Encontradas:");
                ventas.forEach(venta -> System.out.println(venta.toString()));
                break;
            default:
                System.out.println("Opción inválida. Por favor, intenta de nuevo.");
        }
    }
}
