FROM openjdk:21-jdk-slim
LABEL maintainer="Rushikesh Sonawane"

# Set the working directory inside the container to /app
WORKDIR /app

# Copy the JAR file from the host machine to the /app directory in the container
COPY target/docker-kubernetes-0.0.1-SNAPSHOT.jar docker-kubernetes-0.0.1-SNAPSHOT.jar

# Expose port 8080 so it can be mapped by Docker when running the container
EXPOSE 8080

# Define the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "docker-kubernetes-0.0.1-SNAPSHOT.jar"]
