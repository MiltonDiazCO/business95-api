# Business 95 (Backend)
Sistema Web para el Control y la Gestión de Inversiones

Business 95 es un sistema web diseñado para facilitar la gestión de inversiones y promover la transparencia entre los socios. Permite la administración conjunta de una o más inversiones, organizándolas de manera estructurada para mejorar la toma de decisiones. Además, optimiza la contabilidad mediante la centralización de transacciones y reportes.

## Descripción del repositorio
Este repositorio contiene la API de Business 95, desarrollada con Spring Boot. Proporciona servicios RESTful para la gestión de inversiones, socios y movimientos financieros, permitiendo la integración con el frontend y herramientas externas.

## Alcance de la API
- Gestión funcional de inversiones, movimientos y actividades de socios.
- Generación de reportes financieros coherentes y procesados desde el backend.

## Estructura del proyecto (Backend)
```
├── com
│   └── business95
│       └── api
│          └── apibusiness95-api
│              ├── Application.java
│              ├── config              # Configuración (seguridad, beans, CORS, etc.)
│              ├── controller          # Controladores REST
│              ├── dto                 # Clases DTO para entrada/salida de datos
│              ├── entity              # Entidades JPA (antes estaba como 'model')
│              ├── exception           # Manejo de excepciones personalizadas
│              ├── repository          # Interfaces de acceso a datos (CrudRepository, etc.)
│              ├── service             # Interfaces y clases de lógica de negocio
│              ├── util                # Clases utilitarias y helpers
│              └── validator           # Validaciones personalizadas

```

## 🧪 Tecnologías utilizadas
- Java 17
- Spring Boot 3+
- Spring Data JPA
- MySQL
- Maven

## Clonar Repositorio
```bash
git clone git@github.com:MiltonDiazCO/business95-api.git
git clone https://github.com/MiltonDiazCO/business95-api.git
```

## 🚀 Ejecución
```bash
# Compila y ejecuta la aplicación sin limpiar previamente el proyecto
mvn spring-boot:run

# Limpia el proyecto (elimina la carpeta target/) y luego compila y ejecuta la aplicación
mvn clean spring-boot:run
```

## Acceder a la API
```bash
http://{HOST}:{PORT}/api/v1/
```