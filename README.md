# Employee Management System

A **Java-based web application** to manage employee records using **Servlets, JDBC, and MySQL**. The system allows users to **insert, delete, update, and view employee details** through a web interface. It uses **Apache Tomcat 9** as the servlet container and **MySQL** as the database.

---

## Features

- Add a new employee record.
- Update existing employee details.
- Delete an employee record.
- View individual employee details.
- View all employee records.
- Fields include:
  - Employee ID
  - Name
  - Address
  - Salary
  - Email

---
EmployeeManagementSystem/
├─ src/
│   └─ com/
│       └─ employeemanagement/
│           ├─ Employee.java                  ← Employee Bean class
│           ├─ DBConnection.java             ← DB connection class
│           ├─ AddEmployeeDAO.java           ← DAO for adding employee
│           ├─ UpdateEmployeeDAO.java        ← DAO for updating employee
│           ├─ DeleteEmployeeDAO.java        ← DAO for deleting employee
│           ├─ ViewEmployeeDAO.java          ← DAO for viewing employee(s)
│           ├─ AddEmployeeServlet.java
│           ├─ UpdateEmployeeServlet.java
│           ├─ DeleteEmployeeServlet.java
│           ├─ ViewEmployeeServlet.java
│           └─ ViewAllEmployeesServlet.java
├─ webapp/
│   ├─ welcome.html
│   ├─ addemployee.html
│   ├─ updateemployee.html
│   ├─ deleteemployee.html
│   ├─ viewemployee.html
│   └─ viewallemployee.html
├─ WEB-INF/
│   └─ web.xml                              ← Servlet mappings
└─ lib/
    └─ mysql-connector-java-x.x.x.jar       ← JDBC driver


## Technologies Used

- **Java Servlets**
- **JSP (optional, if used for frontend)**
- **JDBC** for database connectivity
- **MySQL** for storing employee data
- **Apache Tomcat 9** as the web server
- **MySQL Connector/J** for JDBC driver

---

## Database Setup

1. Create a MySQL database (e.g., `employee_db`):

```sql
CREATE DATABASE employee_db;
USE employee_db;
Usage Example

Insert Employee: Fill in name, address, salary, and email → Click "Add".

Update Employee: Enter employee ID → Update details → Click "Update".

Delete Employee: Enter employee ID → Click "Delete".

View Employee: Enter employee ID → Click "View".

View All Employees: Click "View All" → List of all employees displayed.

Ensure MySQL server is running before accessing the application.

Apache Tomcat must be configured to use port 8080 (default) or update URLs accordingly.

JDBC code should handle exceptions properly (try-catch blocks are recommended).

Make sure mysql-connector-java jar is compatible with your MySQL version.
