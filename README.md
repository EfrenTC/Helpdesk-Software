# 📚 HELPDESK SOFTWARE

API REST para la **gestión de solicitudes de soporte** y **temas**, desarrollada con **Spring Boot 3** y **JPA/Hibernate**. Pensada como proyecto académico y práctica de Spring Boot, H2 y testing.  

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Propósito |
|------------|-----------|
| Java 21 | Lenguaje principal |
| Spring Boot 3 | Framework para la API REST |
| Spring Data JPA | Persistencia de datos |
| PostgreSQL / H2 | Base de datos |
| JUnit 5 + Mockito | Tests unitarios |
| Swagger/OpenAPI | Documentación de endpoints |

---

## 📂 Estructura del proyecto

src/main/java/org/factoriaf5/digital_academy/
├─ model # Entidades JPA (Solicitud, Tema)
├─ dto # Objetos de transferencia de datos
├─ repository # Repositorios JPA
├─ service # Lógica de negocio
├─ mapper # Conversión entre entidades y DTOs
├─ controller # Endpoints REST
├─ exception # Manejo de excepciones personalizadas

---

## 🚀 Funcionalidades principales

### Solicitudes (Requests)

- Crear, listar, actualizar y eliminar solicitudes  
- Actualizar estado, descripción, tema o nombre del solicitante  
- Marcar solicitudes como **atendidas** y asignar técnico  
- Filtrar solicitudes por tema o por solicitante  

### Temas (Topics)

- Listar todos los temas disponibles  
- Gestionar temas para clasificar solicitudes  

---

## 📌 Endpoints principales

| Método | URL | Descripción | Request body ejemplo |
|--------|-----|------------|-------------------|
| GET | `/solicitudes` | Listar todas las solicitudes | – |
| GET | `/solicitudes/{id}` | Obtener solicitud por ID | – |
| POST | `/solicitudes` | Crear nueva solicitud | `{ "nombreSolicitante": "Juan", "descripcion": "Problema con PC", "temaId": 1 }` |
| PATCH | `/solicitudes/{id}/atender` | Marcar solicitud como atendida | `{ "nombreTecnico": "María López" }` |
| PUT | `/solicitudes/{id}` | Actualizar solicitud | `{ "descripcion": "Nuevo detalle", "temaId": 2 }` |
| DELETE | `/solicitudes/{id}` | Eliminar solicitud | – |
| GET | `/temas` | Listar todos los temas | – |

---

## 🏃‍♂️ Cómo ejecutar el proyecto

1. Clonar el repositorio:

```bash
git clone https://github.com/usuario/digital-academy-support-api.git
cd digital-academy-support-api
Construir con Maven:

mvn clean install
Ejecutar la API:

mvn spring-boot:run
La API estará disponible en: http://localhost:8080

📄 Documentación interactiva con Swagger
Consulta y prueba los endpoints directamente en tu navegador:

http://localhost:8080/swagger-ui.html
🗂️ Base de datos
H2 (pruebas en memoria)
URL: jdbc:h2:mem:testdb
Usuario: SA
Contraseña: (vacío)
Consola: http://localhost:8080/h2-console
PostgreSQL (producción / desarrollo real)
Configurar los datos de conexión en application.properties

📝 Diagrama de clases
Entidades principales: Solicitud, Tema

DTOs: para requests y responses

Relación: Solicitud → Tema (muchos a uno)

(Se puede añadir imagen del diagrama aquí)

🧪 Cobertura de tests
Test unitarios con JUnit 5 y Mockito

Servicios y controladores probados para garantizar que la lógica de negocio y los endpoints funcionen correctamente

🔧 Notas adicionales
Se recomienda usar Postman o Swagger UI para probar la API

Se ha implementado validación de datos y manejo de errores personalizados

Todos los endpoints devuelven JSON como formato de respuesta