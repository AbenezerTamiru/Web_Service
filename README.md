# Assignment 1 Part 1 – Java Web Service Development Report

**Course:** Elective I – Web Service  
**GitHub Repository:** [https://github.com/mengistu3137/Web_Service](https://github.com/mengistu3137/Web_Service)

---

## 👥 Team Members

| No | Name | ID Number |
|----|------|------------|
| 1 | **Abenezer Tamiru** | RU2154/14 |
| 2 | **Betselot Abraham** | RU1612/14 |
| 3 | **Mengistu Tadesse** | RU1187/14 |
| 4 | **Natnael Bayu** | RU1408/14 |
| 5 | **Iman Hussen** | RU0279/14 |

---

> 🧑‍🏫 **Instructor Note:**  
> This repository contains three separate branches, each representing one completed exercise for the assignment:  
> 1. **Java Web Service Development** – [`Java-web-service`](https://github.com/mengistu3137/Web_Service/tree/Java-web-service)  
> 2. **Web API Design and Testing Tools (Postman)** – [`*Web API Design and Testing Tools`](https://github.com/mengistu3137/Web_Service/tree/web-api-design-and-testing-tools)  
> 3. **SOAP-based Web Services** – [`soap-based-web-services`](https://github.com/mengistu3137/Web_Service/tree/soap-based-web-services)  
>
> Each branch includes:
> - Full implementation source code  
> - A detailed README report following the required structure  
> - Screenshots and test results demonstrating successful execution  
>
> Please navigate to the respective branches above to review each completed exercise in detail.

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



## 3. Tools and Technologies Used

| Tool / Framework | Purpose |
|------------------|----------|
| **Java 17** | Programming language |
| **Spring Boot** | RESTful API development |
| **Maven** | Dependency and build management |
| **Postman** | Testing REST APIs 
| **Git & GitHub** | Version control and code hosting
| **VS Code| Development environment |

---

## 4. Results and Observations

### 4.1 RESTful Web Service (Postman Snapshots)

![Creating USer](https://github.com/mengistu3137/Web_Service/blob/Java-web-service/Screenshot%202025-10-24%20112212.png)
*Creating User*

![Getting User](https://github.com/mengistu3137/Web_Service/blob/Java-web-service/Screenshot-2025-10-24%20112352.png)
*Getting User*

Example Response:
```json
{
  "message": "User added successfully!"
}
```



## 5. Conclusion

This assignment provided hands-on experience in developing and testing both REST and Java web services using Java.  
It helped in understanding:
- How RESTful APIs use JSON for lightweight communication
- The importance of tools like Postman in  web services.
- Version control best practices with Git and GitHub.

---

## 6. References

1. [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
2. [Postman API Testing Tool](https://www.postman.com/)
**GitHub Repository:** [(https://github.com/mengistu3137/Web_Service)]
