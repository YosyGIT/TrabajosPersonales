# SmartStock: Sistema de Gestión de Inventarios 📦

SmartStock es una aplicación de consola desarrollada en **Java** diseñada para gestionar múltiples almacenes e inventarios de productos de forma eficiente. El sistema permite el control total sobre el stock, la búsqueda de artículos y la generación de informes de reposición.

## 🛠️ Funcionalidades Principal
* **Gestión Multi-Inventario**: Soporte para hasta 10 almacenes independientes con tamaños personalizables.
* **Control de Productos**: Registro detallado de productos incluyendo nombre, precio y cantidad.
* **Identificación Automática**: Generación dinámica de IDs únicos con formato `PROD-000X` para cada producto.
* **Búsqueda Flexible**: Filtro de búsqueda por nombre que permite localizar productos en segundos.
* **Alertas de Reposición**: Sistema de informes que identifica productos por debajo de un límite de stock definido por el usuario.

## 💻 Conceptos de Programación Aplicados
* **Encapsulamiento**: Uso de modificadores de acceso `private` y métodos `getter/setter` para proteger la integridad de los datos.
* **Lógica de Arrays**: Gestión manual de arreglos de objetos y contadores de posición.
* **Tratamiento de Strings**: Limpieza de espacios con `trim()`, conversiones a minúsculas para búsquedas y formateo de precios reemplazando comas por puntos.
* **Estructura Estática**: Uso de miembros `static` para contadores globales y persistencia temporal de datos en el `main`.

## 🚀 Instalación y Uso
1. Clona este repositorio o descarga las clases del paquete `personal02`.
2. Compila el proyecto: `javac personal02/*.java`.
3. Ejecuta la aplicación: `java personal02.AppSmartStock`.

---
*Desarrollado como parte de mis prácticas de programación en Java.*