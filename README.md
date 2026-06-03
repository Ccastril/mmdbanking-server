# MMDBanking Server

An in-progress Java Spring Boot backend prototype for a banking application. This project demonstrates a layered backend structure using controllers, services, repositories, domain models, and MongoDB persistence.

## Overview

MMDBanking Server is a Spring Boot and MongoDB project that models core banking concepts such as users, accounts, account types, transactions, and transaction types.

The goal of this project is to demonstrate Java backend development patterns, including REST controller organization, service-layer separation, repository-based persistence, Maven project structure, and environment-based configuration.

This is a prototype project and is not intended to represent a production-ready banking system.

## Current Features

* User, account, and transaction domain models
* Controller structure for banking-related resources
* Service layer for business logic separation
* Repository layer for MongoDB persistence
* Maven-based Spring Boot project setup
* Environment-variable based database configuration
* Example application configuration for local setup

## In Progress / Not Yet Implemented

* Complete authentication and authorization flow
* Production-ready login/session/token handling
* Request and response DTOs
* Centralized exception handling
* Request validation
* Role-based access control
* Expanded unit and integration test coverage
* API documentation with Swagger/OpenAPI
* Dockerized local development setup

## Tech Stack

**Language:** Java
**Framework:** Spring Boot
**Database:** MongoDB
**Build Tool:** Maven
**Architecture:** Layered controller/service/repository structure
**Testing:** Spring Boot test structure

## Project Structure

```text
mmdbanking-server/
├── src/
│   ├── main/
│   │   ├── java/com/mmdbanking/
│   │   │   ├── authentication/
│   │   │   ├── controllers/
│   │   │   ├── models/
│   │   │   ├── repositories/
│   │   │   ├── services/
│   │   │   ├── templates/
│   │   │   └── MmdbankingMongoServerApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-example.properties
│   └── test/
│       └── java/com/mmdbanking/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Architecture

The project follows a layered backend structure:

```text
Client / API Consumer
        ↓
Controllers
        ↓
Services
        ↓
Repositories
        ↓
MongoDB
```

### Controllers

Controllers are responsible for handling incoming API requests and routing them to the appropriate service methods.

Current controller areas include:

* `UserController`
* `AccountController`
* `TransactionController`

### Services

Services are responsible for organizing business logic and coordinating operations between controllers and repositories.

Current service areas include:

* `UserService`
* `AccountService`
* `TransactionService`

The project also includes service interfaces such as:

* `IUserService`
* `IAccountService`
* `ITransactionService`

### Repositories

Repositories define the persistence layer for MongoDB-backed domain objects.

Current repositories include:

* `UserRepository`
* `AccountRepository`
* `TransactionRepository`

### Models

The model layer represents the core domain objects for the banking application.

Current models include:

* `User`
* `Account`
* `AccountTypes`
* `Transaction`
* `TransactionType`

## Configuration

The project uses environment variables for database configuration.

`application.properties`:

```properties
spring.data.mongodb.uri=${MONGODB_URI}
server.servlet.context-path=/mmdbanking
spring.data.mongodb.database=${MONGODB_DATABASE:MMDBankingCluster}
```

An example configuration file is included at:

```text
src/main/resources/application-example.properties
```

For local development, set the required environment variables in your shell or IDE.

Required environment variable:

```text
MONGODB_URI
```

Optional environment variable:

```text
MONGODB_DATABASE
```

## Getting Started

### Prerequisites

* Java 17+
* Maven
* MongoDB Atlas or a local MongoDB instance

### Clone the Repository

```bash
git clone git@github.com:Ccastril/mmdbanking-server.git
cd mmdbanking-server
```

### Configure Environment Variables

Set your MongoDB connection string:

```bash
export MONGODB_URI="your-mongodb-connection-string"
```

Optionally set the database name:

```bash
export MONGODB_DATABASE="MMDBankingCluster"
```

### Run the Application

Using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or using Maven directly:

```bash
mvn spring-boot:run
```

The application uses the following context path:

```text
/mmdbanking
```

## Testing

Run tests with:

```bash
./mvnw test
```

## Skills Demonstrated

* Java backend development
* Spring Boot application structure
* REST API organization
* Layered controller/service/repository design
* MongoDB persistence with Spring Data
* Maven project configuration
* Environment-based application configuration
* Basic banking domain modeling
* Separation of concerns across backend layers

## Future Improvements

* Complete authentication and authorization
* Add request and response DTOs
* Add validation annotations for request payloads
* Add centralized exception handling
* Add detailed API endpoint documentation
* Add unit tests for services
* Add integration tests for repositories/controllers
* Add Swagger/OpenAPI documentation
* Add Docker support for local development
* Add CI workflow for build and test validation
