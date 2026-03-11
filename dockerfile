FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/expense-tracker-0.0.1.jar expense-tracker.jar
EXPOSE 8080
CMD ["java","-XX:MaxRAMPercentage=70.0","-jar","expense-tracker.jar"]

