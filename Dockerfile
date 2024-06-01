FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-17-jdk wget tar

RUN wget https://archive.apache.org/dist/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.tar.gz
RUN tar -xvzf apache-maven-3.8.7-bin.tar.gz
RUN mv apache-maven-3.8.7 /opt/apache-maven
ENV M2_HOME=/opt/apache-maven
ENV PATH=${M2_HOME}/bin:${PATH}

WORKDIR /app

COPY . .

RUN mvn clean install 

FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/backendStoque-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
