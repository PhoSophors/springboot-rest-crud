# Spring Boot REST CRUD API

A simple RESTful CRUD API built with **Spring Boot**, demonstrating clean architecture and maintainable design.

## ✨ Features
This API provides basic user management operations:

- **List all users** → `GET /users`
- **Create a new user** → `POST /users`
- **Get user by ID** → `GET /users/{id}`
- **Update user details** → `PUT /users/{id}`
- **Update user status** → `PUT /users/{id}/status`
- **Delete user by ID** → `DELETE /users/{id}`

## 📡 Example Requests

```bash
# List all users
curl -X GET http://localhost:8080/users

# Create a user
curl -X POST http://localhost:8080/users \
     -H "Content-Type: application/json" \
     -d '{"name":"John Doe","email":"john@example.com"}'

# Update user status
curl -X PUT http://localhost:8080/users/6/status \
     -H "Content-Type: application/json" \
     -d '{"status":"publish"}'
