To run the application, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Install the required dependencies using the command: `mvn clean install`.
4. Run the application using the command: `mvn spring-boot:run`.
5. or you can run the application using the command: `java -jar target/result-analyzer-0.0.1-SNAPSHOT.jar `.
6. To build Docker image, run the command: `docker build . -t saikiranvanama/result-analyzer:v1`.
7. To view the docker image, run the command: `docker images`.
8. To run the docker container, run the command: `docker run -p 8080:8080 saikiranvanama/result-analyzer:v1`.
9. To Run the docker container in detached mode, run the command: `docker run -d -p 8080:8080 saikiranvanama/result-analyzer:v1`.
10. To view the running container, run the command: `docker ps`.
11. To stop the running container, run the command: `docker stop <container_id>`.
12. To view the logs of the running container, run the command: `docker logs <container_id>`.