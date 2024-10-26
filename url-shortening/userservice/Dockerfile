# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Set the working directory for the build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml ./
COPY src ./src

# Build the project and package it as a JAR
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:21-jre

# Set the working directory for the runtime image
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
