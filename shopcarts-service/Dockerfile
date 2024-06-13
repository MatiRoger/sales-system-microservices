FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/shopcarts-service-0.0.1.jar
COPY ${JAR_FILE} app_shopcarts.jar
ENTRYPOINT ["java", "-jar", "app_shopcarts.jar"]