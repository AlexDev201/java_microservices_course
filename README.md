# Master Microservices with Spring Boot, Docker, Kubernetes

Repositorio de aprendizaje del curso **"Master Microservices with SpringBoot, Docker, Kubernetes"** (Udemy - Eazy Bytes).
Organizado como monorepo: cada sección del curso vive en su propia carpeta (`section_N/`) y puede contener varios microservicios.

## Temario del curso

- Arquitectura de microservicios vs monolítica y SOA
- Microservicios production-ready con Java, Spring Boot y Spring Cloud
- Documentación con Open API Specification y Swagger
- Right-sizing de microservicios e identificación de service boundaries
- Docker: imágenes y contenedores
- Docker Compose para correr todos los microservicios de la aplicación
- Cloud native apps y metodología 15-factor
- Configuration management con Spring Cloud Config Server
- Service Discovery y Registration con Spring Eureka Server
- Cross-cutting concerns y routing con Spring Cloud Gateway
- Resiliencia con Resilience4J
- Observabilidad y monitoreo con Prometheus, Loki, Promtail, Tempo y Grafana
- Seguridad con OAuth2, OpenID Connect y Spring Security
- Event-driven microservices con RabbitMQ, Kafka, Spring Cloud Functions y Spring Cloud Stream
- Kubernetes como orquestador de contenedores
- Kubernetes en GCP (Google Kubernetes Engine)
- Helm y su rol en el mundo de los microservicios
- Comandos más comunes de Docker, Kubernetes y Helm

## Progreso

| Sección | Tema | Servicios | Estado |
|---------|------|-----------|--------|
| 2 | Spring Boot REST APIs, validaciones y excepciones | `accounts`, `cards`, `loans` | ✅ Completada |
| 3 | Docker | | ⬜ Pendiente |
| 4 | Docker Compose | | ⬜ Pendiente |
| 5 | Spring Cloud Config Server | | ⬜ Pendiente |
| 6 | Spring Eureka Server | | ⬜ Pendiente |
| 7 | Spring Cloud Gateway | | ⬜ Pendiente |
| 8 | Resilience4J | | ⬜ Pendiente |
| 9 | Observabilidad (Prometheus, Grafana, Loki, Tempo) | | ⬜ Pendiente |
| 10 | OAuth2 / OpenID Connect | | ⬜ Pendiente |
| 11 | Event-driven (RabbitMQ, Kafka) | | ⬜ Pendiente |
| 12 | Kubernetes | | ⬜ Pendiente |
| 13 | Kubernetes en GCP | | ⬜ Pendiente |
| 14 | Helm | | ⬜ Pendiente |

## Estructura

```
java_microservices_course/
├── section_2/
│   ├── accounts/       # Microservicio de cuentas (Spring Boot, puerto 8080)
│   ├── cards/          # Microservicio de tarjetas (Spring Boot, puerto 8081)
│   └── loans/          # Microservicio de préstamos (Spring Boot, puerto 8090)
└── ...
```

## Cómo correr los servicios

### accounts (section_2)

Puerto por defecto: `8080` (ver `src/main/resources/application.yml`). Base de datos H2 en memoria (`jdbc:h2:mem:testdb`).

```bash
cd section_2/accounts
./mvnw spring-boot:run
```

Consola H2: `http://localhost:8080/h2-console`

Crear cuenta:

```bash
curl -X POST http://localhost:8080/api/create \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Madin Reddp",
    "email": "tutor@eazybytes.com",
    "mobileNumber": "3104787594"
  }'
```

Respuestas: `201` creado · `400` customer ya existe (mobileNumber duplicado).

### cards (section_2)

Puerto: `8081`. CRUD por `mobileNumber` (mismo patrón que accounts).

```bash
cd section_2/cards
./mvnw spring-boot:run
```

```bash
# Crear tarjeta
curl -X POST "http://localhost:8081/api/create?mobileNumber=3104787594"
# Consultar tarjeta
curl "http://localhost:8081/api/fetch?mobileNumber=3104787594"
# Actualizar tarjeta (Body: CardsDto con cardNumber, cardType, totalLimit, amountUsed, availableAmount)
curl -X PUT http://localhost:8081/api/update -H "Content-Type: application/json" -d '{ ... }'
# Eliminar tarjeta
curl -X DELETE "http://localhost:8081/api/delete?mobileNumber=3104787594"
```

### loans (section_2)

Puerto: `8090`. CRUD por `mobileNumber` (mismo patrón que accounts).

```bash
cd section_2/loans
./mvnw spring-boot:run
```

```bash
# Crear préstamo
curl -X POST "http://localhost:8090/api/create?mobileNumber=3104787594"
# Consultar préstamo
curl "http://localhost:8090/api/fetch?mobileNumber=3104787594"
# Actualizar préstamo (Body: LoansDto con loanNumber, loanType, totalLoan, amountPaid, outstandingAmount)
curl -X PUT http://localhost:8090/api/update -H "Content-Type: application/json" -d '{ ... }'
# Eliminar préstamo
curl -X DELETE "http://localhost:8090/api/delete?mobileNumber=3104787594"
```

Los tres microservicios exponen Swagger UI en `http://localhost:{puerto}/swagger-ui/index.html`.
