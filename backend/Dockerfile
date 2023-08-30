# Use a base image with Java and Gradle
FROM gradle:8.2.1-jdk17 AS build

# Set the working directory in the container
WORKDIR /app

# # Copy the Gradle files and settings
COPY . .

# Build the backend
RUN gradle bootJar

# Use a lighter-weight base image for the actual application
FROM amazoncorretto:17-alpine AS runtime
WORKDIR /app

# Set environment variables
ENV POSTGRES_URL=jdbc:postgresql://localhost:5432/db-name
ENV POSTGRES_USER=db-username
ENV POSTGRES_PASSWORD=db-password

# Expose the port your backend will run on
EXPOSE 8080

# Copy the built JAR file from the build image
ARG JAR_FILE=/app/build/libs/*.jar
COPY --from=build ${JAR_FILE} /app.jar

# Start the backend application
CMD ["java", "-jar", "/app.jar"]
