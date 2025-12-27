# Backend Frameworks Project Report Content

## Title Page
**Project Title:** Library Management System
**Course:** 23CS404 - Backend Frameworks
**Submitted By:** [Your Name/Student ID]
**Date:** [Current Date]

---

## 1. Abstract
The Library Management System is a comprehensive web-based application developed using the Spring Boot framework. It aims to automate the core operations of a library, including book management, member registration, borrowing transactions, and fine calculation. This backend system ensures data integrity and provides RESTful APIs for frontend consumption, replacing manual record-keeping with an efficient, digital solution.

## 2. Introduction
### 2.1 Problem Statement
Traditional library management involves manual record-keeping, which is prone to errors, time-consuming, and difficult to scale. Tracking book availability, managing member details, and calculating overdue fines manually leads to inefficiencies.

### 2.2 Objective
The primary objective is to develop a robust backend system that automates:
- Management of book inventory (add, update, delete).
- Member registration and tracking.
- The borrowing and returning process.
- Calculation of fines for overdue books.

### 2.3 Scope
The scope of this project covers the backend logic and database interactions. It exposes REST APIs that can be consumed by any frontend client (Web or Mobile).

## 3. System Analysis
### 3.1 Existing System
- Manual entry in registers.
- Hard to search for book availability.
- No automated fine calculation.

### 3.2 Proposed System
- **Automated workflows:** Automatic status updates for books.
- **Searchability:** Fast API responses for book queries.
- **Reliability:** ACID-compliant database transactions using Spring Data JPA.

## 4. System Design
### 4.1 Architecture
The project follows the **MVC (Model-View-Controller)** architecture pattern (specifically Service-Repository pattern for backend):
- **Controller Layer:** Handles HTTP requests and responses.
- **Service Layer:** Contains business logic.
- **Repository Layer:** Handles database interactions (DAO).
- **Model Layer:** Represents database entities.

### 4.2 Modules
1.  **Book Management Module**: Handles CRUD operations for books and categories.
2.  **Member Management Module**: Manages library members.
3.  **Borrowing Module**: Tracks issue and return dates.
4.  **Fine Module**: Calculates penalties for late returns.

## 5. Implementation Details
### 5.1 Technology Stack
-   **Language:** Java 17
-   **Framework:** Spring Boot 3.0.1
-   **Database:** MySQL / H2
-   **Build Tool:** Maven
-   **ORM:** Hibernate (via Spring Data JPA)

### 5.2 Key Entity Structures
**Book Entity:**
- `bookId`: Integer (Primary Key)
- `title`: String
- `author`: String
- `available`: Boolean
- `bookCategory`: Relationship

**Borrow Entity:**
- Links `Member` and `Book`.
- Tracks `borrowDate`, `dueDate`, `returnDate`.

### 5.3 Sample API Endpoints
- `GET /api/books` - List all books.
- `POST /api/borrows` - Create a new borrow record.
- `GET /api/members/{id}` - Get member details.

## 6. Testing
Unit testing is performed using **JUnit** and **Mockito**.
- Verified Controller endpoints return correct HTTP status codes.
- Tested Service layer logic for edge cases (e.g., borrowing an unavailable book).

## 7. Conclusion
The Library Management System backend was successfully implemented using Spring Boot. It provides a scalable and secure foundation for a library application, meeting all the specified requirements regarding book and member management. Future enhancements could include authentication (JWT) and notification services.
