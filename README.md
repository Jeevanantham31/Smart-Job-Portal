# Smart Job Portal  
A Console-Based Job Portal Application built using **Java**, **Hibernate ORM**, and **MySQL**.  
This project allows **Users** to search & apply for jobs, and **Companies** to post & manage job listings.  

---

## 🚀 Features

### 👤 **User Features**
- Create user account  
- Login securely  
- View all available job postings  
- Apply for jobs  
- View all applications submitted  

### 🏢 **Company Features**
- Create company account  
- Login securely  
- Post jobs  
- View all jobs posted  
- Track applications (optional future enhancement)

---

## 🛠️ Tech Stack

| Layer | Technology |
|------|-------------|
| Language | Java (JDK 8+) |
| ORM | Hibernate 5 |
| Database | MySQL |
| Build tool | Maven |
| UI | Console-based with ANSI Colors |
| Pattern | DAO (Data Access Object) |

---

## 🧱 ER Diagram
<img width="670" height="500" alt="Screenshot 2025-11-17 173905" src="https://github.com/user-attachments/assets/374a83ef-ab0d-4bf5-bbd3-108aabaa46b1" />


### Relationships
- **Company ↔ Job → One-to-Many**
- **Job ↔ Application → One-to-Many**
- **User ↔ Application → One-to-Many**

---

## 📂 Project Structure
<img width="360" height="694" alt="image" src="https://github.com/user-attachments/assets/bd603251-808a-4afa-bcf8-a1999f5e5cb0" />


---

## 🗄️ Database Setup (MySQL)

Run these SQL queries:

```sql
CREATE DATABASE job_portal;

USE job_portal;

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE company (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    location VARCHAR(255)
);

CREATE TABLE job (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    description TEXT,
    location VARCHAR(255),
    company_id INT,
    FOREIGN KEY (company_id) REFERENCES company(id)
);

CREATE TABLE application (
    id INT PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(100),
    job_id INT,
    user_id INT,
    FOREIGN KEY (job_id) REFERENCES job(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);


