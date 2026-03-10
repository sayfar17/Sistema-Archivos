#TABLA USUARIOS
CREATE TABLE USERS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CARGO VARCHAR(255) NOT NULL,
    DATOS VARCHAR(255) NOT NULL,
    USUARIO VARCHAR(255) UNIQUE NOT NULL,
    CONTRASEÑA VARCHAR(255) NOT NULL,
    ESTADO VARCHAR(255) NOT NULL
);
-- ROL ADMIN
INSERT INTO USERS (CARGO, DATOS, USUARIO, CONTRASEÑA, ESTADO)
VALUES ('Administrador', 'Juan Pérez', 'jperez', 'admin123','Activo');
-- ROL USER
INSERT INTO USERS (CARGO, DATOS, USUARIO, CONTRASEÑA, ESTADO)
VALUES ('Usuario', 'John Doe', 'jdoe', 'pswd123','Activo');

#TABLA DE ARCHIVOS DE NACIMIENTO
CREATE TABLE NACIMIENTOS (
    ID_LIBRO INT AUTO_INCREMENT PRIMARY KEY,
    `N°_LIBRO` VARCHAR(50) NOT NULL,
    AÑO_DE_ACTA_DE_NACIMIENTO VARCHAR(10) NOT NULL,
    `N°_FOLIO` VARCHAR(50) NOT NULL,
    DECLARANTE VARCHAR(255) NOT NULL,
    NOMBRE_DEL_NACIDO VARCHAR(255) NOT NULL,
    OBSERVACIONES VARCHAR(255),
    MUNICIPALIDAD VARCHAR(255) NOT NULL,
    FECHA DATE NULL
);
-- VALORES DE PRUEBA
INSERT INTO NACIMIENTOS (`N°_LIBRO`, AÑO_DE_ACTA_DE_NACIMIENTO, `N°_FOLIO`, DECLARANTE, NOMBRE_DEL_NACIDO, OBSERVACIONES, MUNICIPALIDAD, FECHA)
VALUES 
#('001', '2020', 'F-101', 'Pedro Gómez', 'Luis Pérez', 'Sin observaciones', 'Pasco', '2020-05-12'),
('002', '2021', 'F-102', 'María Torres', 'Ana López', 'Acta corregida', 'Pasco', '2021-03-18'),
('003', '2022', 'F-103', 'Juan Díaz', 'Carlos Ramírez', 'Duplicado de folio', 'Pasco', '2022-07-25'),
('004', '2023', 'F-104', 'Rosa Fernández', 'Lucía Castillo', 'Observación médica', 'Pasco', '2023-01-09'),
('005', '2024', 'F-105', 'Miguel Herrera', 'José Sánchez', 'Datos verificados', 'Pasco', '2024-11-30'),
('006', '2025', 'F-106', 'Carmen Rojas', 'Paola Gutiérrez', 'Registro digital', 'Pasco', '2025-02-14'),
('007', '2025', 'F-107', 'Alberto Vega', 'Diego Morales', 'Acta en revisión', 'Pasco', '2025-06-21'),
('008', '2025', 'F-108', 'Elena Chávez', 'Sofía Aguilar', 'Sin observaciones', 'Pasco', '2025-08-03'),
('009', '2025', 'F-109', 'Ricardo Paredes', 'Martín Flores', 'Corrección de nombre', 'Pasco', '2025-09-15'),
('010', '2025', 'F-110', 'Patricia León', 'Gabriela Núñez', 'Acta validada', 'Pasco', '2025-12-01');

#TABLA DE ARCHIVOS JUDICIALES
CREATE TABLE ARCHIVOS_JUDICIALES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NÚMERO_EXPEDIENTE VARCHAR(50) NOT NULL,
    DEMANDADO VARCHAR(255) NOT NULL,
    DEMANDANTE VARCHAR(255) NOT NULL,
    JUEZ VARCHAR(255) NOT NULL,
    MATERIA VARCHAR(255) NOT NULL,
    OBSERVACIONES VARCHAR(255),
    AÑO YEAR NOT NULL,
    `N°_CAJA` VARCHAR(50) NOT NULL
);

-- VALORES DE PRUEBA
INSERT INTO ARCHIVOS_JUDICIALES 
(NÚMERO_EXPEDIENTE, DEMANDADO, DEMANDANTE, JUEZ, MATERIA, OBSERVACIONES, AÑO, `N°_CAJA`)
VALUES
('EXP-2026-001', 'Carlos Díaz', 'María López', 'Juez Ramírez', 'Civil', 'Sin observaciones', 2026, 'CAJA-01'),
('EXP-2026-002', 'Ana Torres', 'Pedro Gómez', 'Juez Fernández', 'Penal', 'Revisión pendiente', 2026, 'CAJA-02'),
('EXP-2026-003', 'Luis Pérez', 'Rosa Castillo', 'Juez Herrera', 'Laboral', 'Acta corregida', 2026, 'CAJA-03'),
('EXP-2026-004', 'Miguel Sánchez', 'Lucía Aguilar', 'Juez Vega', 'Familia', 'Duplicado de expediente', 2026, 'CAJA-04'),
('EXP-2026-005', 'Paola Gutiérrez', 'José Morales', 'Juez Chávez', 'Civil', 'Datos verificados', 2026, 'CAJA-05'),
('EXP-2026-006', 'Ricardo Paredes', 'Gabriela Núñez', 'Juez León', 'Comercial', 'Observación técnica', 2026, 'CAJA-06'),
('EXP-2026-007', 'Martín Flores', 'Patricia Rojas', 'Juez Torres', 'Penal', 'Acta en revisión', 2026, 'CAJA-07'),
('EXP-2026-008', 'Diego Ramírez', 'Elena Vargas', 'Juez Díaz', 'Civil', 'Sin observaciones', 2026, 'CAJA-08'),
('EXP-2026-009', 'Sofía Aguilar', 'Alberto Vega', 'Juez Castillo', 'Laboral', 'Corrección de nombre', 2026, 'CAJA-09'),
('EXP-2026-010', 'Juan Herrera', 'Carmen Rojas', 'Juez Sánchez', 'Familia', 'Acta validada', 2026, 'CAJA-10');
