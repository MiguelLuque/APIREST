FROM adoptopenjdk/openjdk11:latest
LABEL maintainer="miguel.luque.97@gmail.com"
WORKDIR /app
COPY target/APITemplate-0.0.1-SNAPSHOT.jar /app/APITemplate.jar
ENTRYPOINT ["java","-jar","APITemplate.jar"]