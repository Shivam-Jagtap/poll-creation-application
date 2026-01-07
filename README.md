# 📊 Poll Creation Application – Backend

A Spring Boot backend application that allows users to create polls, vote on them, and view poll statistics.  
This project demonstrates real-world backend development using Java, Spring Boot, REST APIs, and a clean layered architecture.

---

## 🚀 Features

- User registration and verification
- Create and manage polls
- Vote on polls
- View polls created by a user
- View polls voted by a user
- View poll statistics and results
- RESTful API design
- Backend only (frontend independent)

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST APIs

---

## 🧱 Architecture

Controller → Service → DAO / Repository → Database

- Controller layer handles HTTP requests and responses  
- Service layer contains business logic and validations  
- DAO/Repository layer handles database operations  
- DTOs are used for clean separation between API and database models  

---

## ⚙️ Installation & Setup

### Clone the Repository

```bash
git clone https://github.com/Shivam-Jagtap/poll-creation-application.git
cd poll-creation-application

CREATE DATABASE poll_app_db;

mvn clean install
mvn spring-boot:run

```

### 🔌 API Documentation

#### 👤 User APIs
```
POST /poll/verify
```
Verifies user credentials.

```
POST /poll/adduser
```
Creates a new user.

```
PUT /poll/updateuser
```
Updates existing user details.

```
GET /poll/getuser/{userName}
```
Fetches user details by username.

#### 📊 Poll APIs
```
POST /poll/createpoll
```
Creates a new poll with multiple options.
```
GET /poll/getpolls/{userName}
```
Fetches all polls created by a specific user.
```
GET /poll/availablepolls
```
Fetches all active polls available for voting.
```
GET /poll/getPollDetail/{pollId}
```
Fetches complete poll details including options.
```
GET /poll/options/{pollId}
```
Fetches all options for a poll.

#### 🗳 Voting APIs
```
POST /poll/savevote
```
Submits a vote for a poll option.
```
PUT /poll/updatevote
```
Updates an existing vote.

```
GET /poll/getvotedpolls/{userName}
```
Fetches all polls voted by a user.

#### 📈 Analytics APIs
```
GET /poll/statistics/{pollId}
```
Fetches voting statistics for a poll.

### 🔄 Application Flow
1. User registers or logs in
2. User creates a poll
3. Other users view available polls
4. Users vote on poll options
5.Poll creator views poll statistics

### ✅ Best Practices Used
1. Layered architecture 
2. DTO-based API contracts
3. RESTful API conventions
4. Clear separation of concerns
5. Maintainable and extensible codebase


### 👨‍💻 Author
    Shivam Jagtap 
    Backend Software Engineer | Java & Spring Boot
    shivamjagtap42@gmail.com

