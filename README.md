# Quiz App Backend (Microservices Architecture)

This repository contains a **Quiz Application Backend** built using **Microservices Architecture** with **Spring Boot, Java, and MySQL**.  
The project demonstrates how to break down a monolithic application into smaller, independent services that communicate with each other using **Spring Cloud** and **Netflix Eureka**.  

---

## 📌 Project Overview

The backend is divided into **three microservices/projects**:

1. **Service Registry**  
   - Built with **Netflix Eureka Server**.  
   - Handles service discovery and registration.  
   - Both `Quiz Service` and `Question Service` register themselves here.

2. **Question Service**  
   - Manages the **question-related operations**.  
   - Provides APIs for admins and quiz service.  
   - Exposes CRUD operations on questions and additional APIs consumed by quiz service.

3. **Quiz Service**  
   - Consumes the `Question Service` APIs to generate and manage quizzes.  
   - Handles quiz creation, fetching quiz questions, and calculating scores.  

---

## ⚙️ Tech Stack & Dependencies

- **Java** (Spring Boot)  
- **Spring Framework** (Spring Cloud, Spring Data JPA, etc.)  
- **MySQL** (database)  
- **Netflix Eureka Server & Client** (service registry & discovery)  
- **Lombok** (boilerplate code reduction)  
- **Spring Boot Starter Web** (REST APIs)  
- **Spring Boot Starter Data JPA** (ORM support)  
- **Spring Cloud OpenFeign** (service-to-service communication)

---

## 🏗️ Architecture

```plaintext
                +------------------+
                |  Service Registry|
                |  (Eureka Server) |
                +---------+--------+
                          |
        ------------------+-----------------
        |                                  |
+-------v--------+                +--------v-------+
| Question       |                | Quiz Service   |
| Service        |                | (Consumer)     |
| (CRUD on Qs)   |                | - Generate quiz|
| - Add Q        |                | - Get Qs       |
| - Update Q     |                | - Submit Quiz  |
| - Delete Q     |                | - Get Score    |
+----------------+                +----------------+
