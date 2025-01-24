# Stage 1: Build the application using Maven
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory for the build
WORKDIR /app

# Copy the pom.xml first to avoid unnecessary rebuilds
COPY pom.xml .

# Install dependencies
RUN mvn dependency:resolve

# Copy the source code into the image
COPY src ./src

# Run Maven build with debug output to see detailed logs
RUN mvn clean package -DskipTests -X

# Stage 2: Create the runtime image
FROM eclipse-temurin:21-jre-alpine AS runtime

# Set working directory for the runtime container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
