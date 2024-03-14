#First step: Create build container that will build project
FROM maven AS build
WORKDIR /dimitar
COPY src .
RUN mvn clean package -DskipTests
#Second step: Remove all not nessesary files and deploy the API on another container
FROM openjdk:8-jdk AS deploy
COPY --from=build /dimitar/target/dimitar-0.0.1.jar /dimitar/dimitar.jar
RUN rm -rf src target/dependency
WORKDIR /exam
EXPOSE 8080
CMD ["java", "-jar", "dimitar.jar"]