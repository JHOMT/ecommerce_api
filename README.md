# Ecommerce

Un proyecto de Spring Boot para una tienda en línea con MariaDB. Este repositorio contiene el backend del proyecto. El frontend se desarrollará y subirá en otro repositorio.

## Tabla de Contenidos

- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
- [Licencia](#licencia)

## Instalación

Sigue estos pasos para configurar el proyecto localmente.

### Prerrequisitos

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) o superior
- [Maven](https://maven.apache.org/)
- [MariaDB](https://mariadb.org/)

### Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/JHOMT/ecommerce_api.git
    ```

2. Navega al directorio del proyecto:

   ```bash
   cd ecommerce_api
    ```
   
3. Instala las dependencias:

   ```bash
   mvn install
    ```
   
4. Ejecuta el proyecto:

   ```bash
   mvn spring-boot:run
    ```

### Configuración
Configure la conexión a la base de datos MariaDB en el archivo src/main/resources/application.properties:

## Configuración

Configura la conexión a la base de datos MariaDB en el archivo `src/main/resources/application.properties`:

```properties
# Configuración de la base de datos MariaDB
spring.datasource.url=${DB_URL:jdbc:mariadb://localhost:3306/ecommerce}
spring.datasource.username=${DB_USERNAME:tu-usuario}
spring.datasource.password=${DB_PASSWORD:tu-contraseña}

# Configuración de JPA e Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### Uso
El proyecto se ejecutará en http://localhost:8080.

## Licencia
```
Este `README.md` proporciona una guía completa y estructurada para el backend de tu proyecto "ecommerce" utilizando Spring Boot y MariaDB. Puedes adaptarlo según las necesidades y características específicas de tu proyecto.
```