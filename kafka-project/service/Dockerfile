FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY target/*.jar producer-service.jar
ENTRYPOINT ["java", "-jar", "/producer-service.jar"]
