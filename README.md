
# Spring Boot + Docker - Kubernetes Learning Project

This project is a simple Spring Boot application created for learning Docker and kubernetes. It focuses on containerization, image optimization, and running Java microservices in isolated environments.

---
## Tech Stack

- Java 21
- Spring Boot 3.5.3
- Maven
- Docker
- Kubernetes
---

## Running the App Locally (Without Docker)

```bash
# Build the project (with wrapper)
./mvnw clean install

# OR use system Maven
mvn clean install

# Run the Spring Boot app
./mvnw spring-boot:run
````
---

## Docker Integration

### Step 1: Create `Dockerfile`

```Dockerfile
# Use optimized base image
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy only the fat jar (target must be built before this)
COPY target/docker-kubernetes-0.0.1-SNAPSHOT.jar app.jar

# Document exposed port
EXPOSE 8080

# Entry point to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
```
---

### Step 2: Build Docker Image
```bash
docker build -t springboot-docker-demo .
```
* `-t springboot-docker-demo`: Tags the image with a name.
* `.`: Context is the current directory (Dockerfile and target folder should be here).
---

### Step 3: Run Docker Container
```bash
docker run -p 8080:8080 springboot-docker-demo
```

* `-p 8080:8080`: Maps local port 8080 to container's 8080.
* `springboot-docker-demo`: Name of the image to run.
---

## Docker Commands
### Image Commands
```bash
docker build -t <image-name> .        # Build Docker image
docker images                         # List all Docker images
docker rmi <image-id>                 # Remove image by ID
docker tag <image> <new-name>         # Rename or retag image
docker inspect <image>                # Docker image details
```

### Container Commands
```bash
docker run -p 8080:8080 <image-name>             # Run a container
docker run -d -p 8080:8080 <image-name>          # Run in detached mode (in background)
docker run -p 8080:8080 -d --rm <image-name>     # Run a container and remove container automatically on exit ( --rm tag used to clear container automatically once conatiner is stoped)
docker ps                                        # List running containers
docker ps -a                                     # List all containers (running + stopped)
docker start <container-id/conainer-name>        # Start container (Default is detached mode)
docker stop <container-id>                       # Stop a container
docker rm <container-id>                         # Remove a container
docker container prune                           # Remove all container at once
```

### Inspect & Logs
```bash
docker logs <container-id>                       # View logs
docker inspect <container-id>                    # Inspect container details
docker exec -it <container-id> /bin/bash         # Open terminal in running container
```

### Cleanup
```bash
docker system prune                              # Remove unused containers/images/networks
docker volume prune                              # Remove unused volumes
```
---
