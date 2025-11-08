# Expense Tracker

A simple Java 21 + Spring Boot web application to track personal expenses.

Users can register, log in, add expenses, categorize them, view reports, and receive friendly alerts if spending exceeds limits (like “spending too much on
coffee!!” ☕).

# Features

User registration and login with JWT authentication and spring security

Add and categorize expenses

Generate monthly expense reports (Monthly scheduler)

Custom alerts for overspending in categories

# Tech Stack

Java 21

Spring Boot 3.5.7

Maven (build tool)

H2 Database (in-memory, for easy testing)

Spring Security (JWT authentication)

# Requirement

Java 21

Maven 3.8.1

# Api Endpoints

| Endpoint           | Method | Description                     |
|-------------------|--------|---------------------------------|
| /user/signup       | POST   | Register a new user             |
| /user/login        | POST   | Login and get a JWT token       |
| /expense/add       | POST   | Add a new expense               |
| /category/add      | POST   | Add a new expense category      |
| /role/add          | POST   | Add a new role (admin only)     |
| /monthly-report    | GET    | Get monthly reports of expenses |


# Example API usage
## Signup a new user
curl --location 'localhost:8080/user/signup' \
--data '{
"name": "shahin",
"familyName": "rajaei",
"username": "shahin427",
"password": "123456",
"roleIds": [1, 2]
}'

## Login user
curl --location 'localhost:8080/user/login' \
--data '{
"username":"shahin427",
"password":"123456"
}'


