FROM ubuntu:latest
LABEL authors="saikiranvanama"

FROM eclipse-temurin:25

# Add the application's jar to the container
COPY ./target/result-analyzer-0.0.1-SNAPSHOT.jar result-analyzer-0.0.1-SNAPSHOT.jar

# Set the entry point to run the jar file and execute the application
ENTRYPOINT ["java", "-jar", "result-analyzer-0.0.1-SNAPSHOT.jar"]
