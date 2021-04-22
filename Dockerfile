FROM maven:3.8.1-jdk-11 as build-image

COPY . /app
WORKDIR /app
RUN mvn package
RUN find /app

FROM openjdk:11-jre-slim-buster
COPY --from=build-image app/target/app*.jar myapp.jar
EXPOSE 8080
CMD ["java","-jar","myapp.jar"]
