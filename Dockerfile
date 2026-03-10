FROM eclipse-temurin:21-jre

RUN mkdir -p /opt/factory-microservice

WORKDIR /opt/factory-microservice

COPY target/*.jar factory-microservice.jar

CMD ["java", "-jar", "factory-microservice.jar"]