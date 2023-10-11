FROM openjdk:8u181-jdk-alpine
EXPOSE 8080
WORKDIR /app
ARG JAR=library-0.0.1-SNAPSHOT.jar

COPY  /target/$JAR /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]