CREATE TABLE Libro (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       titulo VARCHAR(255) NOT NULL,
                       autor VARCHAR(255) NOT NULL,
                       precio DECIMAL(10, 2) NOT NULL,
                       stock INT NOT NULL
);

CREATE TABLE Cliente (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         nombre VARCHAR(255) NOT NULL,
                         direccion VARCHAR(255),
                         telefono VARCHAR(20),
                         email VARCHAR(255)
);

CREATE TABLE Venta (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       fecha DATE NOT NULL,
                       cliente_id INT,
                       FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE DetalleVenta (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              venta_id INT,
                              libro_id INT,
                              cantidad INT NOT NULL,
                              precio DECIMAL(10, 2) NOT NULL,
                              FOREIGN KEY (venta_id) REFERENCES Venta(id),
                              FOREIGN KEY (libro_id) REFERENCES Libro(id)
);