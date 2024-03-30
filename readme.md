# Spring Boot Hotel Booking Application

A brief description of what this project does and who it's for. This Spring Boot application facilitates hotel and booking management, leveraging H2 as an in-memory database and Redis for caching.

## Features

- CRUD operations for managing hotels and bookings.
- Utilization of H2 in-memory database for persistent storage.
- Redis caching for efficient data retrieval.
- Comprehensive unit and integration tests with JUnit and Mockito.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

- JDK 11 or newer
- Gradle (Version X.X or newer)
- Redis server

### Installation

A step-by-step series of examples that tell you how to get a development environment running.

1. Clone the repository:

```sh
git clone <repository-url>
```
    
Start your Redis server:

Ensure your Redis server is running locally on the default port (6379).

Navigate to the project directory and run the application using Gradle:
```sh
cd HotelBooking
./gradlew bootRun
```
Or, build the JAR file and run it:

```shell
./gradlew build
java -jar build/libs/hotelbooking-0.0.1-SNAPSHOT.jar
```

The application will now be accessible at http://localhost:8080.

## Usage

Details on how to use the API, including endpoints and example requests and responses.
## Hotels

- Create Hotel: POST /api/hotels

    Example request body:
    ```json
    {
      "name": "Hotel Name",
      "address": "Hotel Address",
      "capacity": 100
    }
    
    ```
- Get Hotel by ID: GET `/api/hotels/{id}`

## Bookings

- Create Booking: POST /api/bookings

Example request body:
```json
{
  "customerName": "John Doe",
  "hotelId": 1,
  "checkIn": "2024-04-01",
  "checkOut": "2024-04-05"
}

```

- Get Booking by ID: GET `/api/bookings/{id}`

## Built With

- Spring Boot - The web framework used.
- Gradle - Dependency management.
-  H2 Database - In-memory database.
-  Redis - Used for caching.
-  JUnit - Used for testing.
-  Mockito - Used for mocking in tests.