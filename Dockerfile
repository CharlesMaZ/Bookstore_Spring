FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/lab-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080