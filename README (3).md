# Spring Security Demo

A Spring Boot project demonstrating **Spring Security with JDBC authentication and role-based authorization**.

## Features

* Custom login page
* MySQL/JDBC authentication
* Role-based authorization
* `EMPLOYEE`, `MANAGER`, and `ADMIN` roles
* Custom access-denied page
* Logout
* Thymeleaf Spring Security

## Technologies

* Java 21
* Spring Boot
* Spring Security
* Thymeleaf
* MySQL
* JDBC
* Maven

## Test Users

| Username | Password | Roles                    |
| -------- | -------- | ------------------------ |
| shayan   | fun123   | EMPLOYEE, MANAGER, ADMIN |
| azam     | fun123   | EMPLOYEE                 |
| yazdan   | fun123   | EMPLOYEE, MANAGER        |

> These credentials are for this demo project only.

## Configuration

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

## GitHub

https://github.com/hossien-rm/Spring-Security.git

## Author

**Hossien Rafieemanesh**
