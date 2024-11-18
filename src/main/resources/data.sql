CREATE OR REPLACE DATABASE tienda;
USE tienda;

-- Tabla Cliente
CREATE TABLE Cliente (
                         ID_cliente INT PRIMARY KEY AUTO_INCREMENT,
                         Nombre VARCHAR(100),
                         Telefono VARCHAR(15),
                         Direccion VARCHAR(255)
);

-- Tabla Producto
CREATE TABLE Producto (
                          ID_Producto INT PRIMARY KEY AUTO_INCREMENT,
                          Nombre VARCHAR(100),
                          Precio DECIMAL(10, 2),
                          Stock INT,
                          Fecha DATE
);

-- Tabla Venta
CREATE TABLE Venta (
                       ID_Venta INT PRIMARY KEY AUTO_INCREMENT,
                       Fecha DATE,
                       Total DECIMAL(10, 2),
                       ID_cliente INT,
                       FOREIGN KEY (ID_cliente) REFERENCES Cliente(ID_cliente)
);

-- Tabla VentaProducto (tabla intermedia entre Venta y Producto)
CREATE TABLE VentaProducto (
                               ID_venta INT,
                               ID_Producto INT,
                               Cantidad INT,
                               Total DECIMAL(10, 2),
                               PRIMARY KEY (ID_venta, ID_Producto),
                               FOREIGN KEY (ID_venta) REFERENCES Venta(ID_Venta),
                               FOREIGN KEY (ID_Producto) REFERENCES Producto(ID_Producto)
);
