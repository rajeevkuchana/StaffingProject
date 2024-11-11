FROM eclipse-temurin:17-jre

# Set the working directory inside the container


RUN apt-get update && \
    apt-get install -y curl unzip && \
    curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip" && \
    unzip awscliv2.zip && \
    ./aws/install && \
    rm -rf awscliv2.zip aws && \
    apt-get clean

COPY aws .aws
WORKDIR /app
# Copy the JAR file into the container
COPY target/jobportal-0.0.1-SNAPSHOT.jar /app/jobportal-0.0.1-SNAPSHOT.jar

# Create a directory for logs
RUN mkdir -p /app/logs

# Command to run the application with logging to a file inside the container
CMD java -jar /app/jobportal-0.0.1-SNAPSHOT.jar > /app/logs/jobportal.log 2>&1
