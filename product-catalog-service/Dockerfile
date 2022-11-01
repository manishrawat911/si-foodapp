FROM eclipse-temurin:18-alpine
RUN mkdir /opt/app
COPY ./target/catalogue-service-0.0.1-SNAPSHOT.jar /opt/app/catalogue-service.jar
CMD ["java","-jar","/opt/app/catalogue-service.jar"]