FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/sales-service-0.0.1.jar
COPY ${JAR_FILE} app_saless.jar
ENTRYPOINT ["java", "-jar", "app_sales.jar"]