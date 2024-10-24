# Stage 1: Build the Java project using Maven
FROM maven:3.8.6-eclipse-temurin-17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and src directory to the working directory
COPY pom.xml .
COPY src ./src

# Build the project using Maven
RUN mvn clean install

# Stage 2: Create the runtime image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=builder /app/target/*.jar consumer-service.jar

# Set entry point
ENTRYPOINT ["java", "-jar", "/app/consumer-service.jar"]
