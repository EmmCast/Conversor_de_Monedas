# Conversor de Monedas

Un breve proyecto en el cual se visualizan cuentas de usuarios de un banco DC y MARVEL y en sus funciones esta 
buscar clientes
consultar saldo
hacer retiros 
hacer depositos 
y salir

##Requerimientos

Java 17
Base de datos PostgresSQL

## COnfiguraciones

Clonar el repositorio desde GitHub: git clone https://github.com/tu-usuario/tu-repositorio.git
Importar el proyecto en tu IDE (IntelliJ IDEA, Eclipse, etc.).
Configurar la base de datos.

## Instrucciones

Desde tu IDE: cómo ejecutar la clase principal (ConversorDeMonedasApplication).
Inserta el scrip de base de datos

CREATE TABLE cuentas (
    id SERIAL PRIMARY KEY,
    nombre_cliente VARCHAR(255) NOT NULL,
    tipo_cuenta VARCHAR(255) NOT NULL,
    saldo_disponible NUMERIC(15, 2) NOT NULL
);


INSERT INTO cuentas (nombre_cliente, tipo_cuenta, saldo_disponible) VALUES
('Tony Stark', 'Corriente', 1599.99),
('Bruce Wayne', 'Ahorro', 2000.50),
('Clark Kent', 'Corriente', 3050.75),
('Diana Prince', 'Ahorro', 4550.30),
('Peter Parker', 'Corriente', 950.25),
('Natasha Romanoff', 'Corriente', 1235.65),
('Steve Rogers', 'Ahorro', 750.00),
('Wanda Maximoff', 'Corriente', 1789.80),
('Stephen Strange', 'Ahorro', 3000.40),
('T Challa', 'Corriente', 9999.99);

select * from cuenta;

## Uso de aplicacion 

seleccione una cuenta de la lista que incorpora el inicio.
Opciones disponibles en el menú (consultar saldo, retirar, depositar, salir).


## Estructura

src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── ejercicios_tecnicos/
│   │           └── conversor_de_monedas/
│   │               ├── ConversorDeMonedasApplication.java
│   │               ├── model/
│   │               │   └── Cuenta.java
│   │               ├── service/
│   │               │   └── CuentaService.java
│   │               └── repository/
│   │                   └── CuentaRepository.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── ejercicios_tecnicos/
                └── conversor_de_monedas/
                    └── ConversorDeMonedasApplicationTests.java

## Autor

Isai Emmanuel Castro Hernandez

## Contacto 

Para cualquier duda o comentario, contáctanos en emmcast91@gmail.com.




