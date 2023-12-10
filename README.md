# Batch Student Boot App

## Overview

The Batch Student Boot App is a simple Spring Boot application that helps manage educational batches and students. It provides functionalities to associate students with batches and perform various queries based on different criteria.

## Features

- **Entities:** Includes entities for Batch, Student, and a generic ResponseStructure.
- **Repositories:** Utilizes Spring Data JPA with repositories for Batch and Student entities.
- **DAOs:** Data Access Objects for Batch and Student entities.
- **Services:** Business logic services for Batch and Student operations.
- **Controllers:** RESTful API controllers for Batch and Student operations.
- **Application:** Main application class to run the Spring Boot application.
- **Configuration:** MySQL database configuration in application.properties.

## Getting Started

1. Clone the repository.
2. Configure your MySQL database in `src/main/resources/application.properties`.
3. Run the application using `mvn spring-boot:run` or your preferred method.
4. Access the API endpoints as defined in the controllers.
    ***Batch Operations***
    - `/batches`: CRUD operations for batches.
    - `/batches/{batchId}`: Retrieve batch details by batch ID.
    - `/batches/phone/{phone}`: Retrieve batches by student phone.
    - `/batches/{batchId}/addStudent/{studentId}`: Add a student to a batch.

    ***Student Operations***
    - `/students`: CRUD operations for students.
    - `/students/{studentId}`: Retrieve student details by student ID.
    - `/students/batch/{batchId}`: Retrieve students by batch ID.
    - `/students/batchCode/{batchCode}`: Retrieve students by batch code.
    - `/students/subject/{subject}`: Retrieve students by subject.
    - `/students/trainer/{trainer}`: Retrieve students by trainer.

## API Endpoints

### Batch Operations

- **Create Batch:**
  - **Method:** POST
  - **URL:** `http://localhost:8080/batches`
  - **Body:**
    ```json
    {
      "subject": "Spring",
      "batchcode": "SPG101",
      "trainer": "Chiku"
    }
    ```

- **Retrieve Batch:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/batches/{batchId}`

- **Retrieve Batches by Student Phone:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/batches/phone/{phone}`

- **Add Student to Batch:**
  - **Method:** POST
  - **URL:** `http://localhost:8080/batches/{batchId}/addStudent/{studentId}`

### Student Operations

- **Create Student:**
  - **Method:** POST
  - **URL:** `http://localhost:8080/students`
  - **Body:**
    ```json
    {
      "name": "Pragyan",
      "phone": 9876543210,
      "age": 26,
      "percentage": 89.5
    }
    ```

- **Retrieve Student:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/students/{studentId}`

- **Retrieve Students by Batch ID:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/students/batch/{batchId}`

- **Retrieve Students by Batch Code:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/students/batchCode/{batchCode}`

- **Retrieve Students by Subject:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/students/subject/{subject}`

- **Retrieve Students by Trainer:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/students/trainer/{trainer}`

### Additional Operations

- **Retrieve All Batches:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/batches`

- **Retrieve All Students:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/students`

## Using Postman

1. **Run the Application:**
   - Ensure that the Batch Student Boot App is running.

2. **Open Postman:**
   - Open the Postman application or visit [Postman Web](https://www.postman.com/).

3. **Make Requests:**
   - Use the provided API endpoints with Postman.

4. **Inspect Responses:**
   - Verify that the requests are working as expected.

## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL

## Customize

Feel free to customize the application according to your needs.

## Contributors

- [Pragyan Kumar Pradhan]

## License

This project is licensed under the [MIT License](LICENSE).
