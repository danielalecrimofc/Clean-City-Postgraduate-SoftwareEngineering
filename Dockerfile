# Stage 1: Build the application
FROM maven:3.8.6-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/clean-city-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080:8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]