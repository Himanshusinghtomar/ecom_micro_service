# E-Commerce Microservices Project

This project demonstrates a simple e-commerce application built using a microservices architecture. It consists of multiple Spring Boot services that communicate with each other, registered and discovered through a Eureka Service Registry.

---

## Project Structure

### **Microservices**
1. **Eureka Server**
    - Acts as the service registry for all other microservices.
    - URL: `http://localhost:8761`

2. **Product Service**
    - Manages product-related operations.
    - Endpoints:
        - `GET /products`: List all products.
        - `GET /products/{productName}/available`: Check if a specific product is available.
    - Port: `8081`

3. **Order Service**
    - Handles order placement.
    - Communicates with the Product Service to verify product availability.
    - Endpoints:
        - `POST /orders/{productName}`: Place an order for a specific product.
    - Port: `8082`

4. **User Service**
    - Manages user-related operations (currently a placeholder).
    - Endpoints:
        - `GET /users`: List all users.
    - Port: `8083`

---

## Features

1. **Microservices Architecture**:
    - Services are independently deployable and scalable.
    - Communication happens via REST and Eureka Service Discovery.

2. **Service Registry**:
    - Eureka Server allows dynamic service discovery, removing the need for hardcoded URLs.

3. **Inter-Service Communication**:
    - Order Service communicates with Product Service to check product availability using:
        - **RestTemplate** (basic option).
        - **OpenFeign** (preferred option).

---

## Prerequisites

- Java 17+
- Maven 3.6+
- IntelliJ IDEA (or any IDE of choice)
- Git
- Postman (optional, for API testing)

---

## Setup and Running Instructions

### **Step 1: Clone the Repository**
```bash
git clone https://github.com/Himanshusinghtomar/ecom_micro_service.git
cd ecom_micro_service
```

### **Step 2: Build and Run Each Service**

Open the project in IntelliJ IDEA.
For each microservice (eureka-server, product-service, order-service, user-service):
Navigate to the service directory.

Run the application using:
```bash
mvn spring-boot:run
```
### **Step 3: Test the Setup**

Visit the Eureka Server Dashboard:

URL: http://localhost:8761

Verify that all services (product-service, order-service, user-service) are registered.
Test individual endpoints using a tool like Postman or a browser:

1. **Product Service:**
   - GET http://localhost:8081/products
   - GET http://localhost:8081/products/Laptop/available

2. **Order Service:**
   - POST http://localhost:8082/orders/Laptop
3. **User Service:**
   - GET http://localhost:8083/users
### **Future Enhancements**

 **Centralized Configuration:**

- Add Spring Cloud Config Server to manage service configurations.

**Resilience:**

- Use Resilience4j or Spring Cloud Circuit Breaker to handle failures gracefully.

**API Gateway:**

- Add Spring Cloud Gateway to provide a single entry point for all services.

**Database Integration:**

- Connect each service to its own database (e.g., MySQL or PostgreSQL).

**Authentication and Authorization:**

- Add Spring Security and JWT for secure access.
