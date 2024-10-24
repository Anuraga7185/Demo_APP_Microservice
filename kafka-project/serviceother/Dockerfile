FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY target/*.jar consumer-service.jar
ENTRYPOINT ["java", "-jar", "/consumer-service.jar"]