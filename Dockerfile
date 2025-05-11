# Base image (OpenJDK 17)
FROM eclipse-temurin:21-jdk

# Working directory inside container
WORKDIR /app

# Jar dosyasını container'a kopyala
COPY target/gtv-api-v2-0.0.1-SNAPSHOT.jar app.jar

# Uygulamanın çalışacağı port
EXPOSE 8081

# Uygulama başlatma komutu
ENTRYPOINT ["java", "-jar", "app.jar"]
