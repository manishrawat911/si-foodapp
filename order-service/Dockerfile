FROM eclipse-temurin:18-alpine
RUN mkdir /opt/app
COPY ./target/order-service-0.0.1-SNAPSHOT.jar /opt/app/order-service.jar
CMD ["java","-jar","/opt/app/order-service.jar"]