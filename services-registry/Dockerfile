FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/services-registry-0.0.1.jar
COPY ${JAR_FILE} app_sv-registry.jar
ENTRYPOINT ["java", "-jar", "app_sv-registry.jar"]