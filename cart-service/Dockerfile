FROM eclipse-temurin:18-alpine
RUN mkdir /opt/app
COPY ./target/cart-service-0.0.1-SNAPSHOT.jar /opt/app/cart-service.jar
CMD ["java","-jar","/opt/app/cart-service.jar"]