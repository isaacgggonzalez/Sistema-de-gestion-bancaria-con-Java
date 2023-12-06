CREATE TABLE cliente(
    id_cliente BIGSERIAL PRIMARY KEY,
    cedula BIGINT UNIQUE NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nac DATE NOT NULL
);

CREATE TABLE cuenta(
    id_cuenta BIGSERIAL PRIMARY KEY,
    id_cliente BIGINT NOT NULL,
    saldo NUMERIC(18, 0),
	numero_cuenta BIGINT NOT NULL,
	pin_cuenta BIGINT NOT NULL,
    pin_transaccion BIGINT NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente),
    UNIQUE(id_cuenta, id_cliente)
);

CREATE TABLE transaccion(
    id_transaccion BIGSERIAL PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    monto NUMERIC(18,0) NOT NULL
);

CREATE TABLE deposito(
    id_deposito BIGSERIAL PRIMARY KEY,
    id_transaccion BIGINT UNIQUE NOT NULL,
    cajero VARCHAR(50),
    FOREIGN KEY(id_transaccion) REFERENCES transaccion(id_transaccion)
);

CREATE TABLE transferencia(
    id_transferencia BIGSERIAL PRIMARY KEY,
    id_transaccion BIGINT UNIQUE NOT NULL,
    id_cuenta_destino BIGINT NOT NULL,
    id_cuenta_origen BIGINT NOT NULL,
    FOREIGN KEY(id_cuenta_destino) REFERENCES cuenta(id_cuenta),
    FOREIGN KEY(id_cuenta_origen) REFERENCES cuenta(id_cuenta)   , 
    FOREIGN KEY(id_transaccion) REFERENCES transaccion(id_transaccion)
);

CREATE TABLE movimiento(
    id_movimiento BIGSERIAL PRIMARY KEY,
    id_transaccion BIGINT NOT NULL,
    id_cuenta BIGINT NOT NULL,
    FOREIGN KEY(id_transaccion) REFERENCES transaccion(id_transaccion),
    FOREIGN KEY(id_cuenta) REFERENCES cuenta(id_cuenta)
);


CREATE TABLE servicio(
    id_servicio BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    monto NUMERIC(18, 0)
);

CREATE TABLE pago_servicio(
    id_pago_servicio BIGSERIAL PRIMARY KEY,
    id_servicio BIGINT NOT NULL,
    id_transaccion BIGINT UNIQUE NOT NULL,
    FOREIGN KEY(id_transaccion) REFERENCES transaccion(id_transaccion),
    FOREIGN KEY(id_servicio) REFERENCES servicio(id_servicio)
);

CREATE TABLE tarjeta_credito(
    id_tarjeta_credito BIGSERIAL PRIMARY KEY,
    id_cliente BIGINT NOT NULL,
    linea NUMERIC(18,0) NOT NULL,--limite
    deuda NUMERIC(18, 0) NOT NULL DEFAULT 0,
    fecha_vencimiento DATE NOT NULL,
    nro_tarjeta NUMERIC(16,0) UNIQUE NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE pago_tarjeta(
    id_pago_tarjeta BIGSERIAL PRIMARY KEY,
    id_tarjeta_credito BIGINT UNIQUE NOT NULL,
    id_transaccion BIGINT NOT NULL,
    FOREIGN KEY(id_transaccion) REFERENCES transaccion(id_transaccion),
    FOREIGN KEY(id_tarjeta_credito) REFERENCES tarjeta_credito(id_tarjeta_credito)
);

INSERT INTO cliente(cedula, nombre, apellido, fecha_nac) VALUES (123456789, 'Juan', 'Perez', '1990-01-01');
INSERT INTO cliente(cedula, nombre, apellido, fecha_nac) VALUES (987654321, 'Maria', 'Gomez', '1985-05-15');
INSERT INTO cuenta(id_cliente, saldo, numero_cuenta, pin_cuenta, pin_transaccion) VALUES(1, 100000000, 1234567890, 1234, 4321);
INSERT INTO cuenta(id_cliente, saldo, numero_cuenta, pin_cuenta, pin_transaccion) VALUES(2, 100000000, 9876543210, 5678, 8765);

INSERT INTO servicio(nombre, monto) VALUES('AXEL S.A', 100000);
INSERT INTO servicio(nombre, monto) VALUES('TIGO', 130000);
INSERT INTO servicio(nombre, monto) VALUES('PERSONAL', 50000);
INSERT INTO servicio(nombre, monto) VALUES('ANDE', 300000);
INSERT INTO servicio(nombre, monto) VALUES('BRISTOL', 135000);
INSERT INTO servicio(nombre, monto) VALUES('UNA', 50000);
INSERT INTO servicio(nombre, monto) VALUES('CCPA', 100000);
INSERT INTO servicio(nombre, monto) VALUES('Cooperativa',80000);

INSERT INTO tarjeta_credito(id_cliente, linea, deuda, fecha_vencimiento, nro_tarjeta) VALUES(1, 30000000, 5000000, 1234123412341234);
