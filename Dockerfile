FROM openjdk:21-jdk-slim AS build
EXPOSE 8080
COPY ./target/demo-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
