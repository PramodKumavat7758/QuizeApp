# Dynamic Quiz App

This is a web application built using Spring Boot that allows users to attend quiz and questions to check their skills. This application serves as a simple web-app which provide the platform to check the knowledge toward technologies. In this application Admin who controls the adding , updating, deleting questions, Admin also can create quiz by selecting category of the questions and number questions after providing data the generated quiz will select random number of questions with options from database. In this application the spring security provides the authority to login and register new user with proper validations.

## Features

- Add a new employee with their details.
- Update existing employee details.
- Delete employee records.
- Display a list of all employees in a table.

## Technologies Used
--------------------------------------------------------------------------------------------------------------------
- Java
- Spring Boot
- Spring MVC
- Hibernate
- Thymeleaf (for templating)
- MySQL Database (or your preferred database)

## Getting Started

To run this project on your local machine, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone <repository_url>
   ```

2. **Configure the Database:**

   Create a MySQL database and update the `application.properties` file with your database configuration:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and Run the Application:**

   Use Maven to build and run the application:

   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application:**

   Open your web browser and access the application at [http://localhost:8080](http://localhost:8080).

## Usage

- Navigate to the "List Employees" page to view the existing employee records.
- Click "Add Employee" to add a new employee record.
- Click "Update" next to an employee record to edit their details.
- Click "Delete" to remove an employee record from the system.


## List Employees
![List Employees](Welcome.png)

## Update Exsting Employee
![UpdateEmployee](UpdatingEmployee.png)

## Add New Employee
![addNewEmployee](AddingNewEmployee.png)



This project was created as a learning exercise and is based on tutorials and courses related to Spring Boot and web development.

---

Feel free to customize this README to provide more specific information about your project. Include any additional setup instructions, prerequisites, or specific details about your application that you think would be helpful for users.
