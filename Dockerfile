# Build stage
FROM amazoncorretto:17-al2-jdk as build
WORKDIR /source
COPY . .
RUN ./gradlew build

# Final image
FROM amazoncorretto:17-alpine
LABEL authors="solthoth"
EXPOSE 8080
WORKDIR /app
COPY --from=build /source/build/libs/email-service-0.0.1-SNAPSHOT.jar /app/email-service.jar

ENTRYPOINT ["java", "-jar", "/app/email-service.jar"]
