# 1. aşama: Maven ile jar build et
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. aşama: sadece jar'ı alıp minimal image oluştur
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/gtv-api-v2-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]

