FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY orders-service.jar /app/orders-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/orders-service.jar"]
