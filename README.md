# Conversor de Monedas

Este proyecto es un servicio RESTful para la conversión de divisas. Permite convertir un monto de una divisa a otra basada en tasas de cambio almacenadas en una base de datos.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (o cualquier base de datos soportada por JPA)
- Maven

## Estructura del Proyecto

- `Entity` : Define la entidad `Divisa`.
- `DTO` : Contiene los objetos de transferencia de datos `Request` y `Response`.
- `Repository` : Interfaz para el acceso a datos `IDivisaRepository`.
- `Service` : Interfaz y su implementación `IDivisaService` y `DivisaServiceImpl`.
- `Controller` : Controlador REST `DivisaController`.

## Configuración

### Base de Datos

Este servicio utiliza una base de datos H2 en memoria para almacenar las tasas de cambio de las divisas. A continuación, se presenta el script SQL para crear la tabla y poblarla con datos iniciales:

```sql
CREATE TABLE Divisas (
    id_divisa SERIAL PRIMARY KEY NOT NULL,
    codigo VARCHAR(3) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    moneda VARCHAR(50) NOT NULL,
    valor DOUBLE NOT NULL
);

INSERT INTO Divisas (codigo, pais, moneda, valor) VALUES ('USD', 'Estados Unidos', 'Dólar Estadounidense', 18.22);
INSERT INTO Divisas (codigo, pais, moneda, valor) VALUES ('EUR', 'Europa', 'Euro', 19.62);
INSERT INTO Divisas (codigo, pais, moneda, valor) VALUES ('JPY', 'Japón', 'Yen', 0.12);
INSERT INTO Divisas (codigo, pais, moneda, valor) VALUES ('GBP', 'Reino Unido', 'Libra Esterlina', 23.19);
INSERT INTO Divisas (codigo, pais, moneda, valor) VALUES ('AUD', 'Australia', 'Dólar Australiano', 12.044578);
INSERT INTO Divisas (codigo, pais, moneda, valor) VALUES ('CAD', 'Canadá', 'Dólar Canadiense', 13.2390);
INSERT INTO Divisas (codigo, pais, moneda, valor) VALUES ('CHF', 'Suiza', 'Franco Suizo', 20.319);
INSERT INTO Divisas (codigo, pais, moneda, valor) VALUES ('CNY', 'China', 'Yuan', 2.54003);