# Software Developer (Client-Facing) Technical Assessment

This repository contains the complete solution for the Java/J2EE technical assessment, demonstrating implementation skills in full-stack development, DevOps infrastructure, and client communication.

## 1. Project Overview and Implementation

### Core Requirements Demonstrated

The project successfully demonstrates expertise in all minimum and key opportunity-boosting requirements:

| Category | Skills Implemented |
| :--- | :--- |
| **Technology Stack** | **Java 8, MySQL, J2EE (Servlet/JSP), Payara/Glassfish** (Containerized) |
| **DevOps** | **Docker, Docker Compose, Git** (Used for environment setup and deployment) |
| **Process** | SDLC, Requirement Gathering, **Testing** (UAT & Integration Concepts) |
| **Client-Facing** | Demonstrated in Video 2: Simplified explanation of CRUD functionality for non-technical users. |

### 1.2 Deployment and Execution Instructions

The application uses Docker Compose to set up a clean, self-contained environment.

1.  **Prerequisites:** Ensure **Java 8 JDK** and **Docker Desktop** are running.
2.  **Build WAR File:** Package the Java source code using Maven.
    ```bash
    mvn clean package
    ```
3.  **Execute DDL:** Create the necessary `employee` table in the MySQL container.
    ```bash
    type employee_ddl.sql | docker exec -i mdk-mysql_db-1 mysql -u root -pyour_root_password crud_db
    ```
4.  **Run Stack:** Starts MySQL and Payara, and mounts/deploys the `MDK-1.0-SNAPSHOT.war`.
    ```bash
    docker compose up -d
    ```
5.  **Access Application:** Wait 30 seconds for the server to boot, then navigate to:
    `http://localhost:8080/MDK-1.0-SNAPSHOT/list`

***

## 2. Solution Summary: Video Content

### 2.1 Video 1: Q&A and Process Understanding

This video addresses process maturity and soft skills:

* **Requirement Gathering & CR Handling (Q.b):** Explained the structured process of gathering requirements through stakeholder interviews (System Analyst perspective) and handling **Change Requests** by analyzing scope, conducting technical impact analysis, and obtaining client sign-off.
* **Software Quality (Q.c):** Highlighted the methodology: **Clean Code Standards**, **Code Review**, and mandatory **Unit Testing (JUnit)** and **Integration Testing** (verifying DB and server connectivity).
* **SDLC/DevOps Stages (Q.d):** Detailed the modern development flow: **Design → Code/Git → Build/Containerization → UAT → Production Deployment → Monitoring/Observability**.

### 2.2 Video 2: Java Demo and Code Explanation

This video demonstrates the technical implementation:

* **CRUD Implementation:** Demonstrated all four operations (Create, Read, Update, Delete) on the web interface.
* **Technical Highlights:**
    * Showed **`EmployeeDAO.java`** implementing secure **JDBC** using **`PreparedStatement`** to prevent SQL injection.
    * Confirmed connection using **`mysql_db`** as the service hostname and addressed compatibility issues using the `allowPublicKeyRetrieval=true` parameter.
* **Client-Facing Demo (Kritis):** Presented the application with non-technical language (using analogies like "contact list") to the *end-user*, focusing purely on **business value** and ease of use, as requested.
