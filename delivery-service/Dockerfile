FROM eclipse-temurin:18-alpine
RUN mkdir /opt/app
COPY ./target/delivery-service-0.0.1-SNAPSHOT.jar /opt/app/delivery-service.jar
CMD ["java","-jar","/opt/app/delivery-service.jar"]