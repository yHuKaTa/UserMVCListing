# User MVC Listing

## Description

`User MVC Listing` is a tiny web API employee to perform CRUD operations and view data from DB. Application use Spring Boot with Spring Security. It can register new user, list all existing users in DB, remove user from DB.

The application provides the following functionalities:
---

* Login as init User(Username: guest, Password: guest)
* Login as init Admin(Username: admin, Password: admin)
* Add new user to DB
* View list of users from DB
* Remove user from DB


## Launching

Method 1:
* Install MySQL: <a href=https://dev.mysql.com/downloads/installer/> Select your platform here </a>
* Open "Terminal" or "Command Promt".
* Insert in terminal -> 'project_location'/java -jar dimitar.jar
* Test the app at http://localhost:8080.

Method 2:
* Install MySQL: <a href=https://dev.mysql.com/downloads/installer/> Select your platform here </a>
* Open "Terminal" or "Command Promt".
* Insert in terminal -> 'project_location'/mvn clean package
* Insert in terminal -> 'project_location'/java -jar dimitar.jar
* Test the app at http://localhost:8080.

Method 3:
* Install Docker: <a href=https://www.docker.com/products/docker-desktop/> Select your platform here </a>
* Open "Terminal" or "Command Promt".
* Insert in terminal -> 'project_location'/docker compose up
* Test the app at http://localhost:8080.

## Pages

###  Login Page - build-in page from Spring Security. Here we insert username(Email) and password. In here we are getting authorized and enter to the home page.
* <a href=http://localhost:8080/login> Login page </a>

### Home Page - Page that lists all user from DB. From here we can delete user, proceed to user form page and logout.
* <a href=http://localhost:8080/home> Home page </a>

### User Form Page - Page that provide user add form. Here we can insert data to the form and save that user to DB. Also, we can proceed back to the home page. 
* <a href=http://localhost:8080/home> Home page </a>

### Logout Page - build-in page from Spring Security. Here we confirm our logout and getting proceed to the login page.
* <a href=http://localhost:8080/home> Home page </a>

## Technologies

* Java 8
* Spring Boot with Spring DATA JPA and Hibernate
* Spring Security
* Maven 3
* MySQL 8
* Docker
