
Test Task for Online Intership JavaRush (<a href ="https://javarush.ru"> https://javarush.ru</a>)

**Project description:**
A simple CRUD application based on the following technologies: Spring Boot, MySQL, JPA, frontend framework: Vaadin.
When a program starts, mysql script runs automatically on startup. After launching
the program, open a web browser and enter the following URL: http://localhost:8080/.

**Before you run this program!:**
- check your database connection (MySQL): username, password, database url -> see `application.properties`
- change your properties in `persistence.xml ` file -> user, password, url
- change the path to your sql script in CrudApplication.class, password, username, url

Default properties:

`username: root`

`password: root`

`database url: jdbc:mysql://localhost:3306/test`

**Run your program or just execute it with Maven:**
- git clone https://github.com/JolaPsh/crud-with-vaadin.git
- mvn spring-boot:run

Preffered IDE: IntelliJ IDEA
