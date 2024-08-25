# Use a minimal base image with JRE
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/jobportal-0.0.1-SNAPSHOT.jar /app/jobportal-0.0.1-SNAPSHOT.jar

# Command to run the application
CMD ["java", "-jar", "/app/jobportal-0.0.1-SNAPSHOT.jar"]