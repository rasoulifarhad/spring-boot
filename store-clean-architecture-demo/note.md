### The Core

- Contains core business logic
- Entities
- Use Cases / Service Classes
- Lightweight DTOs
- Interfaces
- Logging and Metrics(Use Slf4j & Micrometre)
  
### The Details

- The Implementation of Interfaces
- Detail-Specific Class Structure
- External Clients
- SQL
- Good place for database Migrations
  
### The App

- AKA "Where Spring Lives"
- Application Configuration
- Application Lifecycle
- "Input" (e.g. Controllers)
- Impossible to Clean; the "Dirtiest" of components
  
### Hide Your Internals

### Input: HTTP / Controllers

- simple: Use Spring Web/MVC
- Controllers Should be as minimal as possible:
	- Convert User Input
	- Handle AuthZ/AuthN (use Filters)
	- Call into Core Services via function calls or lightweight objects
  
### Input: Messages / Queues

- Use Observer Pattern
- Connect / Disconnect In Spring Lifecycle Listeners
- Spring Integration & MessageTemplate

### Service Classes

- Closest to "Use Cases"
- Keep them small and focused: Remember: Single Use
- Avoid `OrderService`, prefer `CustomerOrderQueryService`
	- it is more specific and evocative
- Almost all of them will live in Core
  
Created as @Bean manually

### Profiles and Env Vars

- Configuration should be Environment Agnostic
- Avoid Profiles for Environment Specific Config
	- Profiles are for profile-based things.
- Inject Env Vars
- Take a look at Spring Cloud Config and Spring Cloud Vault!

### Testing

- Components -> Fast Unit Tests
- Integration Tests go in the `App` Component
- Testcontainers (and Localstack) FTW!

### Datastores

- Remember:databases and stores are tools
- Everything goes behind a Repository Interface
- Implementation goes in the Details Module
- Databases, Caches, Microservice calls, Third Parties


See https://github.com/spember/spring-shoestore
See https://www.slideshare.net/StevePember/anatomy-of-a-spring-boot-app-with-clean-architecture-spring-io-2023