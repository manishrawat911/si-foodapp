FROM eclipse-temurin:18-alpine
RUN mkdir /opt/app
COPY ./target/user-service-0.0.1-SNAPSHOT.jar /opt/app/user-service.jar
CMD ["java","-jar","/opt/app/user-service.jar"]