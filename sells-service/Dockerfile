FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/sells-service-0.0.1.jar
COPY ${JAR_FILE} app_sells.jar
ENTRYPOINT ["java", "-jar", "app_sells.jar"]