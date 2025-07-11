# 📚 Book Manager API

A simple, clean, and production-ready Java backend REST API built with **Spring Boot 3.5**, **Java 17**, and **H2 database**. This application performs full CRUD operations on a collection of books and includes features like search, DTO mapping, exception handling, and Swagger UI for API documentation.

---

## 🚀 Features

- ✅ Add, update, delete, and retrieve books
- 🔍 Search by title, author, or both
- 📦 Clean layered architecture: Controller → Service → Repository
- 📄 DTO-based API responses
- 🧾 Global exception handling (`@ControllerAdvice`)
- 🧪 File-based H2 DB for local data persistence
- 📘 Swagger UI for testing & documentation
- ⚙️ Easy to deploy to platforms like Render or Railway

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- H2 Database (File mode)
- Swagger UI (via Springdoc OpenAPI)
- Maven

---

## 📁 Project Structure

```
book-manager-api/
├── controller/ # REST API endpoints
├── service/ # Business logic
├── model/ # JPA Entity (Book.java)
├── dto/ # Data Transfer Objects (BookDTO.java)
├── repository/ # JpaRepository interface
└── exception/ # Custom exceptions & handler
```

---

## 🔧 Getting Started Locally

### 1. Clone the repo

```bash
git clone https://github.com/VatsalPatel16/book-manager-api.git
cd book-manager-api
```

### 2. Build the project

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn spring-boot:run
```

The app will start at:
👉 http://localhost:8080

---

## 🔎 API Endpoints (Sample)
```
Method	    Endpoint	        Description
GET	    /api/books          Get all books
GET	    /api/books/{id}	Get book by ID
POST	    /api/books	        Add a new book
PUT	    /api/books/{id}	Update existing book
DELETE	    /api/books/{id}	Delete book by ID
GET	    /api/books/search	Search by title/author
```

---

## 📄 Swagger UI
```
After running the app, access Swagger UI here:

👉 http://localhost:8080/swagger-ui.html
(or)
👉 http://localhost:8080/swagger-ui/index.html

Explore and test all endpoints live.
```

---

## 💾 H2 Database (file mode)
```
Database file is stored at: ./data/bookdb.mv.db

You can inspect it using H2 Console (local only):

URL: jdbc:h2:file:./data/bookdb

Username: sa

No password
```

---

🧑‍💻 Author: Vatsal Patel