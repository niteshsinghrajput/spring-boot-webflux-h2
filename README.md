# spring-boot-webflux-h2
An example to demonstrate API development by using Spring WebFlux in functional style

## Prerequisites

Before running this project, make sure you have the following prerequisites:

- Java 11 or higher installed

## Setup

1. Clone the repository:

   ```bash
   git clone git@github.com:niteshsinghrajput/spring-boot-webflux-h2.git

2. Navigate to the project directory:

    ```bash
    cd spring-boot-webflux-h2

3. Build the project

    ```bash
    ./gradlew clean build

4. Run the application

   ```bash
    java -jar .\build\libs\spring-boot-webflux-h2-0.0.1-SNAPSHOT.jar

## Usage
Once the application is running, you can access the API endpoints using a tool like Postman or cURL.

#### The API supports the following endpoints:

* GET `/api/employees`: Get all employees
    * Sample URL: `http://localhost:8080/api/employees`
* GET `/api/employees/{id}`: Get an employee by ID
    * Sample URL: `http://localhost:8080/api/employees/1`
* POST `/api/employees`: Create a new employee
    * Sample URL: `http://localhost:8080/api/employees`
    * Sample Request Payload:
      ```json
        {
          "name": "Nitesh Rajput",
          "email": "nitesh.rajput122@target.com",
          "salary": 12000
        }
      ```
* PUT `/api/employees/{id}`: Update an existing employee
    * Sample URL: `http://localhost:8080/api/employees/1`
    * Sample Request Payload:
      ```json
        {
          "name": "Nitesh Rajput",
          "email": "nitesh.rajput123@target.com",
          "salary": 12500
        }
      ```
* DELETE `/api/employess/{id}`: Delete an employee
    * Sample URL: `http://localhost:8080/api/employees/1`

you can also use `curl` to perform CRUD (Create, Read, Update, Delete) operations for the `http://localhost:8080/api/employees` endpoint:

1. **Create an employee** (HTTP POST):
   ```sh
   curl -X POST -H "Content-Type: application/json" -d '{"name":"Nitesh Rajput","email": "atnsrajput@gmail.com", "salary": 20000}' http://localhost:8080/api/employees
   ```
   
2. **Read All Employees** (HTTP GET):
   ```sh
   curl http://localhost:8080/api/employees
   ```

3. **Read Single employee by ID** (HTTP GET):
   Replace `1` with the desired employee ID.
   ```sh
   curl http://localhost:8080/api/employees/1
   ```

4. **Update an Employee by ID** (HTTP PUT):
   Replace `1` with the desired employee ID.
   ```sh
   curl -X PUT -H "Content-Type: application/json" -d '{"name":"Nitesh Rajput","email": "atnsrajput@gmail.com", "salary": 25000}' http://localhost:8080/api/employees/1
   ```

5. **Delete an Employee by ID** (HTTP DELETE):
   Replace `1` with the desired employee ID.
   ```sh
   curl -X DELETE http://localhost:8080/api/employees/1
   ```

Please note that the above commands is for a JSON-based API and use the `-H "Content-Type: application/json"` header for requests that include data. Adjust the commands based on the actual structure of your API and the data format it expects. Also, ensure that your Spring Boot application is running and listening on port 8080 for these commands to work as expected.


Make sure to replace {id} with the actual ID of the employee when using the specific endpoints.

## Configuration
The application configuration can be found in the application.properties file. You can modify the H2 DB connection details, such as the host, port, and database name, in this file.
   