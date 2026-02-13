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

**Migración de Oracle a MySQL:**

Originalmente, el sistema fue desarrollado para conectarse a una base de datos **Oracle**, alineándose con la infraestructura tecnológica de la entidad gubernamental y requisitos del curso. 

Para esta versión pública del repositorio, se ha migrado la capa de persistencia a **MySQL**, facilitando así la ejecución y revisión del código en cualquier entorno de desarrollo local sin dependencias complejas.

---

## 📁 Estructura del Proyecto (MVC)

```bash
- src/model/ — entidades y persistencia
- src/controller/ — lógica de negocio
- src/view/ — interfaz
```

---