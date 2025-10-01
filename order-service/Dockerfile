# Build stage
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /workspace/app

# Copy the POM file
COPY pom.xml .
# Download dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src src

# Build the application
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-jammy

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /workspace/app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
