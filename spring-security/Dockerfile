#
# Build stage
#
FROM maven:3.9.1-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17
COPY --from=build /target/*.jar app.jar
# ENV PORT=8080
EXPOSE 8125
ENTRYPOINT ["java","-jar","/app.jar"]
