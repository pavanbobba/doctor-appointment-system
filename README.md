# Doctor Appointment Booking System

A backend application for booking doctor appointments, built with Spring Boot and MySQL.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven

## Features
- Doctor management (add and view doctors)
- Availability slots with optimistic locking (`@Version`) to prevent double booking
- Appointment booking (in progress)
- JWT authentication with roles: Patient, Doctor, Admin (planned)

## Project Structure
```
controller  -> handles HTTP requests
service     -> business logic
repository  -> database access
entity      -> database tables
security    -> authentication and authorization
```

## Setup

1. Install Java, Maven and MySQL.
2. Create the database in MySQL:
```sql
CREATE DATABASE appointment_db;
```
3. Create a file `src/main/resources/application-local.properties` with your own details:
```
spring.datasource.url=jdbc:mysql://localhost:3306/appointment_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```
4. Run `DoctorAppointmentSystemApplication`. The app starts on `http://localhost:8080`.

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/doctors | Add a doctor |
| GET | /api/doctors | Get all doctors |
| GET | /api/doctors/{id} | Get one doctor by id |

Example request body for POST:
```json
{
  "name": "Dr. Ravi",
  "specialization": "Cardiology",
  "bio": "10 years experience"
}
```

## Author
Pavan Bobba