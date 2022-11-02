FROM eclipse-temurin:18-alpine
RUN mkdir /opt/app
COPY ./target/billing-service-0.0.1-SNAPSHOT.jar /opt/app/billing-service.jar
CMD ["java","-jar","/opt/app/billing-service.jar"]