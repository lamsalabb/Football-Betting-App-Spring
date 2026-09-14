Football Betting App
A full-stack football betting web application built with Java and Spring Boot. The application allows users to authenticate, view football match information, and place simulated bets using a persistent MySQL-backed system.
Features
    •    User registration and authentication
    •    Secure access control with Spring Security
    •    Football match and score management
    •    Mock football betting functionality
    •    Persistent user and betting data
    •    Server-rendered web interface using Thymeleaf
    •    MySQL database integration
    •    Email support through Spring Mail
Tech Stack
    •    Language: Java 21
    •    Framework: Spring Boot 3.4.4
    •    Web: Spring MVC, Thymeleaf
    •    Security: Spring Security
    •    Database: MySQL
    •    Persistence: Spring Data JPA / Hibernate
    •    Build Tool: Maven
    •    Testing: Spring Boot Test, Spring Security Test
Architecture
The application follows a layered Spring Boot architecture:
Web Browser
     │
     ▼
Controllers
     │
     ▼
Services
     │
     ▼
Repositories
     │
     ▼
MySQL Database
    •    Controllers handle HTTP requests and user interactions.
    •    Services contain application and betting logic.
    •    Repositories provide database access through Spring Data JPA.
    •    Entities represent persistent application data.
    •    Thymeleaf renders the server-side web pages.
    •    Spring Security manages authentication and authorization.
Getting Started
Prerequisites
Make sure you have the following installed:
    •    Java 21+
    •    Maven
    •    MySQL
1. Clone the repository
git clone https://github.com/lamsalabb/Football-Betting-App-Spring.git
cd Football-Betting-App-Spring
2. Create the database
Create a MySQL database for the application:
CREATE DATABASE football_betting;
3. Configure the application
Update the database configuration in:
src/main/resources/application.properties
Set your MySQL credentials and other environment-specific configuration.
Example:
spring.datasource.url=jdbc:mysql://localhost:3306/football_betting
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
Do not commit production credentials or other secrets to the repository.
4. Run the application
Using Maven:
./mvnw spring-boot:run
Or:
mvn spring-boot:run
The application will start on the configured Spring Boot port.
Project Structure
src/
├── main/
│   ├── java/
│   │   └── ...
│   └── resources/
│       ├── templates/
│       ├── static/
│       └── application.properties
└── test/
    └── java/
Testing
Run the test suite with:
./mvnw test
Future Improvements
Potential areas for extending the application include:
    •    Integrating a third-party football scores API
    •    Adding additional betting markets
    •    Adding bet history and user statistics
    •    Introducing real-time score updates
    •    Improving responsive/mobile UI
    •    Adding automated integration and end-to-end tests
    •    Containerizing the application with Docker
Disclaimer
This project is intended for educational and demonstration purposes. The betting functionality is simulated and does not involve real-money gambling.
