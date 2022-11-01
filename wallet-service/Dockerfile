FROM eclipse-temurin:18-alpine
RUN mkdir /opt/app
COPY ./target/wallet-service-0.0.1-SNAPSHOT.jar /opt/app/wallet-service.jar
CMD ["java","-jar","/opt/app/wallet-service.jar"]