FROM openjdk:21-jdk-slim
LABEL maintainer="Rushikesh Sonawane"
WORKDIR /app
COPY target/docker-kubernetes-0.0.1-SNAPSHOT.jar docker-kubernetes-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-kubernetes-0.0.1-SNAPSHOT.jar"]
