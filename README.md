# 🤝 Business 95 (Backend)
Sistema Web para el Control y la Gestión de Inversiones

Business 95 es un sistema web diseñado para facilitar la gestión de inversiones y promover la transparencia entre los socios. Permite la administración conjunta de una o más inversiones, organizándolas de manera estructurada para mejorar la toma de decisiones. Además, optimiza la contabilidad mediante la centralización de transacciones y reportes.

## 📘 Descripción del repositorio
Este repositorio contiene la API de Business 95, desarrollada con Spring Boot. Proporciona servicios RESTful para la gestión de inversiones, socios y movimientos financieros, permitiendo la integración con el frontend y herramientas externas.

## 🎯 Alcance de la API
- Gestión funcional de inversiones, movimientos y actividades de socios.
- Generación de reportes financieros coherentes y procesados desde el backend.

## 🗂️ Estructura del proyecto (Backend)
```
├── com
│   └── business95
│       └── api
│          ├── Application.java
│          ├── controller          # Controladores REST
│          ├── dto                 # Clases DTO para entrada/salida de datos
│          ├── entity              # Entidades JPA (antes estaba como 'model')
│          ├── enums                # Enumeraciones
│          ├── exception           # Manejo de excepciones personalizadas
│          ├── helper              # Clases auxiliares de apoyo
│          ├── mapper              # Conversión Entity, Projection <-> DTO (MapStruct / manual)
│          ├── projection          # Proyecciones para consultas personalizadas
│          ├── repository          # Interfaces de acceso a datos (CrudRepository, etc.)
│          ├── security            # Configuración de seguridad (JWT, filtros, CORS)
│          ├── service             # Interfaces y clases de lógica de negocio
│          ├── util                # Utilidades generales

```

## 🧪 Tecnologías utilizadas
- Java 21
- Spring Boot 3+
- Maven
- MySQL
- Spring Data JPA
- Spring Security
- JWT

# 📥 Clonar Repositorio
```bash
git clone git@github.com:MiltonDiazCO/business95-api.git
git clone https://github.com/MiltonDiazCO/business95-api.git
```

# ▶️ Ejecución
```bash
# Compila y ejecuta la aplicación sin limpiar previamente el proyecto
mvn spring-boot:run
mvn spring-boot:run -Pdev

# Limpia el proyecto (elimina la carpeta target/) y luego compila y ejecuta la aplicación
mvn clean spring-boot:run
mvn clean spring-boot:run -Pdev
```

## 🌐 Acceder a la API
```bash
http://{HOST}:{PORT}/api/v1/
```

# 🚀 Despliegue en Servidor Apache Tomcat

## 1. Cambiar el empaquetado a `war` en el `pom.xml`
```xml
<packaging>war</packaging>
```

## 2. Agregar la dependencia de Tomcat con alcance provided
```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-tomcat -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
    <scope>provided</scope>
</dependency>
```

## 3. Configurar el nombre final del artefacto
Dentro de la etiqueta `<build>` del `pom.xml`, agregar:
```xml
<finalName>${artifactId}</finalName>
```

## 4. Extender SpringBootServletInitializer en la clase principal
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Business95ApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Business95ApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Business95ApiApplication.class, args);
    }
}
```

## 5. Ajustar la configuración de la base de datos
Modificar el archivo `application.properties` `(o application.yml)` con las credenciales y URL correspondientes al entorno donde se desplegará la aplicación.

## 6. Generar el archivo .war
Ejecutar el siguiente comando:
```bash
mvn clean package
```

## 7. Desplegar en Tomcat
Copiar el archivo `.war` generado en la carpeta:
```
{TOMCAT_HOME}/webapps
```

## 8. Acceder a la API
```bash
http://{HOST}:{PORT}/{artifactId}/api/v1/
```