# Assignment 1 – Java Web Service Development Report

**Course:**Elective I – Web Service   
**Student Name:** [Your Full Name]  
**ID Number:** [Your Student ID]  
**Instructor:** [Instructor Name]  
**Date:** [Submission Date]  
**GitHub Repository:** [GitHub Repo URL]

---

## Table of Contents
1. [Introduction](#1-introduction)
2. [Implementation Steps](#2-implementation-steps)
3. [Tools and Technologies Used](#3-tools-and-technologies-used)
4. [Results and Observations](#4-results-and-observations)
5. [Conclusion](#5-conclusion)
6. [References](#6-references)

---

## 1. Introduction

This report covers the development and testing of different types of **Java-based web services** and API testing tools.  
The assignment includes three major exercises:

### 1.1 Java Web Service Development
This exercise focuses on building a **RESTful web service** using Java  with Spring Boot.  
The goal is to understand how to create and expose HTTP endpoints that handle CRUD operations.

### 1.2 Web API Design and Testing Tools
This part explores **API design principles** and the use of **Postman** for testing and validating REST APIs.  
It emphasizes sending various HTTP requests (GET, POST, PUT, DELETE) and interpreting the JSON responses.

### 1.3 SOAP-based Web Services
This section focuses on developing a **SOAP web service** using **JAX-WS** in Java.  
The objective is to understand how XML-based messages are structured and exchanged between client and server.

---

## 2. Implementation Steps

### 2.1 Java RESTful Web Service

**Steps:**
1. Created a new Spring Boot project using [Spring Initializr](https://start.spring.io/).
2. Added dependency: `spring-boot-starter-web`.
3. Implemented a simple `UserController` with CRUD endpoints:
   - `GET /users`
   - `POST /users`
   - `PUT /users/{id}`
   - `DELETE /users/{id}`
4. Ran the server on port `8080`.
5. Tested endpoints using Postman.

**Example Code Snippet:**
```java
@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        users.add(user);
        return "User added successfully!";
    }
}
```

---

### 2.2 Web API Design and Testing (Postman)

**Steps:**
1. Opened **Postman** and created a new collection named `User API`.
2. Added requests for each HTTP method (GET, POST, PUT, DELETE).
3. Verified responses and HTTP status codes.
4. Saved responses for documentation.

**Example Request:**
```
GET http://localhost:8080/users
```

**Example Response:**
```json
[
  { "id": 1, "name": "John Doe" },
  { "id": 2, "name": "Sara Smith" }
]
```

---

### 2.3 SOAP-based Web Service

**Steps:**
1. Created a Java project and added `javax.xml.ws` dependency.
2. Defined a service interface `CalculatorService`:
   ```java
   @WebService
   public interface CalculatorService {
       int add(int a, int b);
       int subtract(int a, int b);
   }
   ```
3. Implemented and published the service:
   ```java
   @WebService(endpointInterface = "service.CalculatorService")
   public class CalculatorServiceImpl implements CalculatorService {
       public int add(int a, int b) { return a + b; }
       public int subtract(int a, int b) { return a - b; }
   }

   public class Publisher {
       public static void main(String[] args) {
           Endpoint.publish("http://localhost:8081/ws/calculator", new CalculatorServiceImpl());
           System.out.println("Service is running...");
       }
   }
   ```
4. Tested the service using **SOAP UI** by sending XML requests.

---

## 3. Tools and Technologies Used

| Tool / Framework | Purpose |
|------------------|----------|
| **Java 17** | Programming language |
| **Spring Boot** | RESTful API development |
| **Maven** | Dependency and build management |
| **Postman** | Testing REST APIs |
| **SOAP UI** | Testing SOAP-based web services |
| **Git & GitHub** | Version control and code hosting |
| **JAX-WS** | Java API for XML Web Services |
| **VS Code / IntelliJ IDEA** | Development environment |

---

## 4. Results and Observations

### 4.1 RESTful Web Service (Postman Snapshots)
*(Add screenshots here)*

Example Response:
```json
{
  "message": "User added successfully!"
}
```

### 4.2 SOAP Web Service (SOAP UI Snapshots)
*(Add screenshots here)*

**Example SOAP Request:**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service/">
   <soapenv:Body>
      <ser:add>
         <a>5</a>
         <b>10</b>
      </ser:add>
   </soapenv:Body>
</soapenv:Envelope>
```

**Example SOAP Response:**
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:addResponse xmlns:ns2="http://service/">
         <return>15</return>
      </ns2:addResponse>
   </soap:Body>
</soap:Envelope>
```

---

## 5. Conclusion

This assignment provided hands-on experience in developing and testing both REST and SOAP web services using Java.  
It helped in understanding:
- How RESTful APIs use JSON for lightweight communication.
- How SOAP uses XML for structured message exchange.
- The importance of tools like Postman and SOAP UI in verifying web services.
- Version control best practices with Git and GitHub.

---

## 6. References

1. [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
2. [Postman API Testing Tool](https://www.postman.com/)
3. [SOAP UI Tool](https://www.soapui.org/)
4. [JAX-WS Java Documentation](https://docs.oracle.com/javaee/7/api/javax/xml/ws/package-summary.html)
5. [GitHub Docs](https://docs.github.com/)

---

**Prepared by:** [Mengistu Tadess]  
**Date:** [oct 24,2025]  
**GitHub Repository:** [(https://github.com/mengistu3137)]
