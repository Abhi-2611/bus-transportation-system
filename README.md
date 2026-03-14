# Bus Transportation System

A Spring Boot REST API for managing bus routes, buses, and route–bus mapping.  
The application provides endpoints to create, update, retrieve, and soft delete routes and buses, and to map buses to routes.

---

## Tech Stack

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Lombok  
- OpenAPI / Swagger  

---

## Project Structure

```
src/main/java/com/transport/bus

config
controller
dto
entity
exception
mapper
repository
service
serviceimpl
util
```

### Layers

- **Controller** – Handles API requests and responses
- **Service** – Defines business operations through interfaces
- **Service Implementation** – Implements service logic
- **Repository** – Handles database operations using Spring Data JPA
- **DTO** – Data transfer objects for API requests and responses
- **Mapper** – Converts between DTO and Entity objects
- **Entity** – Represents database tables
- **Exception** – Handles application exceptions globally
- **Config** – Contains OpenAPI and CORS configuration
- **Util** – Common utility classes such as API response wrapper

---

## API Endpoints

### Route APIs

| Method | Endpoint | Description |
|------|------|------|
POST | `/api/routes` | Create or update route |
GET | `/api/routes` | Get all active routes |
GET | `/api/routes/get?routeId=1` | Get route by ID |
DELETE | `/api/routes/delete?routeId=1` | Soft delete route |

---

### Bus APIs

| Method | Endpoint | Description |
|------|------|------|
POST | `/api/buses` | Create or update bus |
GET | `/api/buses` | Get all buses |
GET | `/api/buses/get?busId=1` | Get bus by ID |
DELETE | `/api/buses/delete?busId=1` | Soft delete bus |

---

### Route-Bus Mapping APIs

| Method | Endpoint | Description |
|------|------|------|
POST | `/api/route-bus/map?busId=1&routeId=2` | Map bus to route |
GET | `/api/route-bus/buses?routeId=1` | Get buses by route |

---

## Example Response

```json
{
  "success": true,
  "message": "Route created successfully",
  "data": {
    "id": 1,
    "title": "PUNE_TO_MUMBAI",
    "source": "Pune",
    "destination": "Mumbai",
    "stations": "Pune,Lonavala,Karjat"
  }
}
```

---

## Swagger Documentation

After starting the application open:

```
http://localhost:8080/swagger-ui.html
```

or

```
http://localhost:8080/swagger-ui/index.html
```

Swagger UI allows testing all APIs from the browser.

---

## Database Tables

### routes

```
id
title
source
destination
stations
active_flag
```

### buses

```
id
bus_no
color
capacity
route_id
```

Relationship:

```
Route (1) -------- (Many) Bus
```

---

## Running the Application

Clone the repository:

```
git clone https://github.com/Abhi-2611/bus-transportation-system.git
```

Go to the project directory:

```
cd bus-transportation-system
```

Run the application:

```
mvn spring-boot:run
```

---

## Future Additions

- React frontend   

---

## License

This project is licensed under the MIT License.

---

## Author

Abhishek Musale
