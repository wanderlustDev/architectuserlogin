**PROJECT SCOPE**

This application allows you to get registered with a username and password which gets stored in a database. When the register button is clicked, the user is then prompted to enter a username and password,. If the specified username exists already, the user will be prompted to enter a new username. The username can be a minimum of 5 alphanumeric characters. There are no upper limits. The password must have at least 1 uppercase letter, 1 lowercase letter and 1 digit. The password can be a minimum of 8 characters, with no upper limit. If the user inputs a value that isn’t valid, they will be prompted to enter the correct value.


**TECHNOLOGIES AND FRAMEWORKS USED**

- Spring Boot
- Thymeleaf
- H2 Database (Data is stored locally in project directory (./userlogin/data/userlogin)
- Tomcat
- Lombok


**BEFORE RUNNING APPLICATION**

1. Ensure you have Java 8 installed on your computer.
2. Ensure you have Maven installed on your computer.


**HOW TO RUN APPLICATION**

1. Unzip zipped file (userlogin.zip).
2. Open in an IDE of your choice.
3. Run ‘mvn clean package’.
4. Then run `java -jar target/userlogin-0.0.1-SNAPSHOT.jar`.
5. Go to `localhost:8080/home`.
6. If port `8080` is being used by another service, you can change the defined port to an available port in `applications.properties`.
7. Once your port is running and you are on the Home url, click `Click here to register`.
8. Enter your username and password. Click Register.
9. You’re now registered.
10. To see the registered user in the database, go to `localhost:8080/h2-console`.
11. Use `username: "sa"; password: "password"` to login.
12. Run `SELECT * FROM USER`;


**DESIGN DECISIONS**

_1. WHY SPRING BOOT?_

In order to write the application in the shortest time possible, Spring’s use of Inversion of Control and Dependency Injection and other criteria made it the best choice. Inversion of Control and Dependency Injection forces you to follow good software coding practices and also helps quicken development time since a lot of the configuration and setting up is already done for you. Also, SpringBoot’s ability to connect to any database of choice makes it a very convenient option for building an application that requires data access and storage. Another top deciding factor was SpringBoot’s flexibility in terms of supporting the development of server-side rendered web applications, it took away the complexity of running client-side and server-side projects separately. Another benefit is that SpringBoot Applications include a pre-configured, embedded web server, like Tomcat, which makes it very easy to setup, deploy and test web applications. Lastly, SpringBoot also makes it a lot easier to create CRUD Applications through a layer of JPA-based CRUD repositories. Overall, SpringBoot’s flexibility, stability, reliability, connectivity and access to a wealth of resources made it the best choice for this project.

_2. WHY THYMELEAF?_

Thymeleaf’s Spring integration made it one of the top choices for writing this application, the fact that it is fully implemented for and well supported makes it a very convenient option. Thymeleaf’s templating engine takes away the complexity of working with JSP with it’s more HTML focused structure, allowing you to build a user interface with much less complexity. Thymeleaf also reduces the build-deploy-test feedback loop making development a lot easier and faster. 

_2. WHY LOMBOK?_
Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java. Using @Data annotation on a POJO automatically adds @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor.

**CLASS HIERARCHY**

- Controller Layer -> Service Layer -> Data Layer : HomeController -> UserController -> UserService -> UserRepository -> DB Access
- Entity -> User -> has {id, username, password}. 
- ID and Username are unique for each user.
- ID is automatically generated and incremented.
- Username must only contain alphanumeric characters and must have a minimum length of 5.
- Password must contain at least 1 lowercase character, 1 uppercase character, 1 digit, and must have a minimum length of 8.

**`Each user gets saved in the Database.`**


**UNIT TESTS**

_SCENARIOS COVERED:_
1. When an entirely new user is created, it should be saved in the database.
2. When a new user is created using an existing username, an error message should be returned asking the user to enter a different username. The user will not be stored in the DB.
3. When a new user is created using an invalid username, an error message should be returned asking the user to enter a correct username.
4. When a new user is created using an invalid password, an error message should be returned asking the user to enter a correct password.
5. When a new user is created using an invalid username and password, an error message should be returned asking the user to enter correct values for both username and password.

**TEST COVERAGE**

- Class: 88%
- Method: 82%
- Line: 90%


**ADDING NEW FUNCTIONALITIES**

New functionalities like finding all users and displaying the result, finding a particular user by username, deleting a user, updating a user’s details, adding more information about users, can be added in the future by simply adding a new function in the Service layer and providing an implementation that makes use of the existing data access methods provided by the CRUD Repository.




