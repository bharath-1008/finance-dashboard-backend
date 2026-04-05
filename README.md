Finance Dashboard Backend (Spring Boot)

Overview
This project is a backend application built using Spring Boot for managing financial data such as income and expenses.
It provides REST APIs for user management, financial record tracking, filtering, and dashboard analytics.

The system follows a layered architecture and integrates with MySQL for persistent storage.
Tech Stack
. Java 17
. Spring Boot
. Spring Data JPA
. MySQL
. Maven
. Postman (API Testing)
Architecture
The project follows a clean layered architecture:
Controller Layer → Handles API requests
Service Layer → Contains business logic
Repository Layer → Handles database operations
Entity Layer → Defines data models

Features
User Management
. Create users
. View all users
. Role-based structure using enums (ADMIN, ANALYST, VIEWER)
Financial Records (CRUD)
. Add financial records
. View all records
. Update records
. Delete records
Each record includes:
. Amount
. Type (INCOME / EXPENSE)
. Category
. Date
. Notes
. CreatedBy (User ID)
Record Filtering (Advanced Feature)
Filter financial records based on:
. Type
. Category
. Date
This is implemented using Spring Data JPA query methods.
Dashboard Analytics
Provides summarized financial insights:
. Total Income
. Total Expense
. Net Balance
Implemented using  JPQL aggregation (SUM queries)for efficiency.
Input Validation & Error Handling
. Amount must be greater than 0
. Invalid inputs are rejected with proper error messages
Role-Based Access Control (Conceptual)
. Roles designed using enums
. Intended behavior:
  . ADMIN → Full access
  . ANALYST → Analytics access
  . VIEWER → Read-only access
> Note: Security is implemented at design level using annotations but not enforced with authentication for simplicity.
Database Configuration
Update application.properties:
properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
API Endpoints
User APIs
. POST /users → Create user
. GET /users → Get all user
Record APIs
•	POST /records → Create record
•	GET /records → Get all records
•	PUT /records/{id} → Update record
•	DELETE /records/{id} → Delete record
Filtering APIs
. GET /records/filter/type?type=INCOME
. GET /records/filter/category?category=Salary
. GET /records/filter/date?date=2026-04-01
Dashboard API
. GET /dashboard/summary
Sample Requests
Create User
json
{
  "name": "Sai",
  "email": "sai@test.com",
  "role": "ADMIN",
  "status": "ACTIVE"
}
Create Record
json
{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-01",
  "notes": "Monthly salary",
  "createdBy": 1
}
How to Run
1. Clone the repository
2. Configure MySQL database
3. Update application.properties
4. Run the Spring Boot application
5. Use Postman to test APIs
 Example Output
json
{
  "totalIncome": 5000,
  "totalExpense": 0,
  "netBalance": 5000
}
Key Highlights
. Clean layered architecture
. RESTful API design
. MySQL integration
. Filtering and analytics support
. Validation and error handling
