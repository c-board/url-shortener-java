# URL Shortener Java

A simple URL shortener application built with Java and Spring Boot. This application allows users to shorten long URLs and redirect to the original URL using the shortened version.

## Features

- Shorten long URLs to a more manageable format.
- Redirect to the original URL using the shortened link.
- Simple RESTful API for URL shortening and redirection.

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- JPA/Hibernate
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- A web browser or API client (e.g., Postman)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/url-shortener-java.git
   cd url-shortener-java
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

### Usage

- **Shorten a URL**:
  - Send a POST request to `http://localhost:8080/api/shorten` with the long URL in the request body.
  - Example using `curl`:
    ```bash
    curl -X POST -H "Content-Type: text/plain" -d "https://www.example.com" http://localhost:8080/api/shorten
    ```

- **Redirect to the original URL**:
  - Access the shortened URL in your browser or via an HTTP GET request.

### Configuration

- **CORS**: The application is configured to allow all origins for development purposes. Update the `SecurityConfig.java` file to specify allowed origins in production.

- **Port**: The application runs on port 8080 by default. You can change this in the `application.properties` file.
