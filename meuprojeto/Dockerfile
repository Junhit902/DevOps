# Build stage
FROM maven:3.9.2-eclipse-temurin-17 AS builder

WORKDIR /build

COPY pom.xml .
COPY src ./src

# Use Maven from the image instead of the wrapper script
RUN mvn -B clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /build/target/meuprojeto-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8686

ENTRYPOINT ["java", "-jar", "app.jar"]