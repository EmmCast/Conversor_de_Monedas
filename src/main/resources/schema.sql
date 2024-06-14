CREATE TABLE cuentas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(255) NOT NULL,
    tipo_cuenta VARCHAR(255) NOT NULL,
    saldo_disponible DOUBLE NOT NULL
);