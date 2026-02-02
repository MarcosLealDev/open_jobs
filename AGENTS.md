# AGENTS.md

This file contains guidelines and commands for agentic coding agents working in this repository.

## Project Overview

This is a Spring Boot 3.5.9 application using Java 17 that implements a RESTful API for managing candidates and jobs. The project uses:
- Spring Boot with Web, Data JPA, and Validation starters
- PostgreSQL database with Hibernate
- Lombok for boilerplate reduction
- Maven for build management

## Build/Test Commands

### Core Maven Commands
```bash
# Clean and compile the project
mvn clean compile

# Run all tests
mvn test

# Run a single test class
mvn test -Dtest=OpenJobsApplicationTests

# Run a specific test method
mvn test -Dtest=OpenJobsApplicationTests#contextLoads

# Package the application
mvn clean package

# Install to local repository
mvn clean install

# Run the application (development)
mvn spring-boot:run

# Run with specific profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Database Setup
The application expects a PostgreSQL database running on localhost:5432 with:
- Database name: `open_jobs_db`
- Username: `admin`
- Password: `admin`

Use the provided `docker-compose.yml` to set up the database if needed.

## Code Style Guidelines

### Package Structure
Follow the established modular structure:
```
com.marcos.open_jobs/
├── modules/
│   ├── candidate/
│   │   ├── controllers/
│   │   ├── entities/
│   │   ├── repositories/
│   │   └── useCases/
│   └── company/
│       ├── controllers/
│       ├── entities/
│       ├── repositories/
│       └── useCases/
└── exceptions/
```

### Naming Conventions
- **Entities**: `{Domain}Entity` (e.g., `CandidateEntity`, `CompanyEntity`)
- **Controllers**: `{Domain}Controller` (e.g., `CandidateController`)
- **Repositories**: `{Domain}Repository` (e.g., `CandidateRepository`)
- **Use Cases**: `{Action}{Domain}UseCase` (e.g., `CreateCandidateUseCase`)
- **Exceptions**: Descriptive names ending with `Exception` (e.g., `UserFoundException`)

### Import Organization
- `jakarta.*` imports first (for JPA, validation)
- `org.springframework.*` imports next
- `com.marcos.open_jobs.*` imports
- Other third-party imports
- `java.*` imports last

### Code Style
- Use **Lombok** `@Data` annotation for entities to generate getters, setters, toString, etc.
- Apply **Bean Validation** annotations directly on entity fields
- Use `@Autowired` for constructor injection in controllers and services
- Follow RESTful conventions with proper HTTP methods and response codes

### Entity Guidelines
- Use `@Entity(name="{table_name}")` with lowercase table names
- Primary keys should be UUID with `@GeneratedValue(strategy = GenerationType.UUID)`
- Add `@CreationTimestamp` for audit fields like `createdAt`
- Apply validation annotations with custom error messages

### Controller Patterns
```java
@RestController
@RequestMapping("/{domain}")
public class {Domain}Controller {
    @Autowired
    private {UseCase} useCase;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody {Entity} entity) {
        try {
            var result = this.useCase.execute(entity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
```

### Error Handling
- Create custom exceptions extending `RuntimeException`
- Use `@ControllerAdvice` for global exception handling
- Return `ResponseEntity` with appropriate HTTP status codes
- Provide meaningful error messages to clients

### Validation Rules
- Use `@NotBlank` for required string fields
- Apply `@Email` for email validation
- Use `@Length(min=X, max=Y)` for string length constraints
- Implement custom regex patterns with `@Pattern` when needed
- Write clear, user-friendly error messages

### JPA Repository Patterns
- Extend `JpaRepository<Entity, UUID>`
- Use method naming conventions for derived queries
- Implement custom methods in use cases, not directly in controllers
- Return `Optional<T>` for methods that may not find results

### Use Case Implementation
- Mark with `@Service` annotation
- Use `@Autowired` for repository injection
- Implement business logic and validation
- Handle domain-specific exceptions
- Return entities or throw exceptions as needed

## Testing Guidelines
- Use JUnit 5 (included with Spring Boot Test)
- Test with `@SpringBootTest` for integration tests
- Focus on testing use cases and controllers
- Mock repositories when testing controllers in isolation

## Development Notes
- The application runs on port 8080 by default
- Use `http://localhost:8080` for API endpoints
- Hibernate DDL is set to `update` for development
- Spring Boot DevTools is included for hot reloading during development