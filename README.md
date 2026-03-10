# 📂 Sistema de Gestión de Archivos - GOREPA (Caso de Estudio)

> **Curso:** Lenguaje de Programación II (LP II)  
> **Estado:** Prototipo Funcional

## 📖 Descripción del Proyecto

Este proyecto consiste en un **Sistema de Gestión de Archivos** desarrollado como una propuesta tecnológica para una de las áreas administrativas del **Gobierno Regional de Pasco**.

El software fue diseñado para **atender la problemática de gestión documentaria** de la institución, ofreciendo una solución capaz de digitalizar y centralizar el flujo de documentos. El desarrollo se basó en los requerimientos reales del área para simular un entorno de producción.

## 🚀 Características del Sistema

* **Arquitectura MVC:** Implementación del patrón Modelo-Vista-Controlador para garantizar un código organizado y mantenible.
* **Gestión de Expedientes:** Módulos para el registro, búsqueda y seguimiento de documentos (físicos/digitales).
* **Control de Acceso:** Autenticación y administración básica de usuarios.
* **Interfaz de Usuario:** Diseñada para facilitar la transición de procesos manuales a digitales.

## 🛠️ Tecnologías

* **Lenguaje:** Java
* **Arquitectura:** MVC
* **Build Tool:** Ant
* **Base de Datos:** MySQL (Ver nota de versión)

---

## 💾 Nota sobre la Base de Datos
> [!NOTE]
> **Migración de Oracle a MySQL:**  
>
> Originalmente, el sistema fue desarrollado para conectarse a una base de datos **Oracle**, alineándose con la infraestructura tecnológica de la entidad gubernamental y requisitos del curso.  
>
> Para esta versión pública del repositorio, se ha migrado la capa de persistencia a **MySQL**, facilitando así la ejecución y revisión del código en cualquier entorno de desarrollo local sin dependencias complejas.

---

## 📁 Estructura del Proyecto (MVC)

```bash
- src/model/ — entidades y persistencia
- src/controller/ — lógica de negocio
- src/view/ — interfaz
```
---
## 🗄️ Estructura de la Base de Datos

Aquí se muestra la organización principal de la base de datos utilizada en el proyecto.

### 🔹 Tabla `USERS`
Tabla que almacena información de los usuarios del sistema.

- **ID** (PK) – Identificador único del usuario.  
- **CARGO** – Rol del usuario (`Administrador` / `Usuario`).  
- **DATOS** – Nombre completo del usuario.  
- **USUARIO** – Nombre de usuario único.  
- **CONTRASEÑA** – Contraseña del usuario.  
- **ESTADO** – Estado activo/inactivo.  

**Ejemplo de datos:**
- Administrador: Juan Pérez (`jperez`)  
- Usuario: John Doe (`jdoe`)  

---

### 🔹 Tabla `NACIMIENTOS`
Tabla que almacena archivos de actas de nacimiento.

- **ID_LIBRO** (PK) – Identificador de registro.  
- **N°_LIBRO** – Número del libro de actas.  
- **AÑO_DE_ACTA_DE_NACIMIENTO** – Año de la acta.  
- **N°_FOLIO** – Folio del libro.  
- **DECLARANTE** – Nombre del declarante.  
- **NOMBRE_DEL_NACIDO** – Nombre de la persona nacida.  
- **OBSERVACIONES** – Comentarios o notas especiales.  
- **MUNICIPALIDAD** – Municipalidad donde se registró.  
- **FECHA** – Fecha del registro.

**Ejemplo de registros:**
- '002', '2021', 'F-102', 'María Torres', 'Ana López', 'Acta corregida', 'Pasco', '2021-03-18'  
- '004', '2023', 'F-104', 'Rosa Fernández', 'Lucía Castillo', 'Observación médica', 'Pasco', '2023-01-09'  

---

### 🔹 Tabla `ARCHIVOS_JUDICIALES`
Tabla que almacena información de expedientes judiciales.

- **ID** (PK) – Identificador del expediente.  
- **NÚMERO_EXPEDIENTE** – Código único del expediente.  
- **DEMANDADO** – Nombre de la persona demandada.  
- **DEMANDANTE** – Nombre de la persona demandante.  
- **JUEZ** – Nombre del juez encargado.  
- **MATERIA** – Tipo de caso (Civil, Penal, Laboral, Familia, Comercial).  
- **OBSERVACIONES** – Comentarios adicionales.  
- **AÑO** – Año del expediente.  
- **N°_CAJA** – Número de la caja donde se archiva.

**Ejemplo de registros:**
- 'EXP-2026-001', 'Carlos Díaz', 'María López', 'Juez Ramírez', 'Civil', 'Sin observaciones', 2026, 'CAJA-01'  
- 'EXP-2026-005', 'Paola Gutiérrez', 'José Morales', 'Juez Chávez', 'Civil', 'Datos verificados', 2026, 'CAJA-05'
---

## 
> [!IMPORTANT]
> *Derecho de imágenes a quien corresponda.*  
> Estas imágenes se usan únicamente con fines educativos o personales y **no para propósitos comerciales**.

---