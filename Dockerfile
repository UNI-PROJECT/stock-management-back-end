# Use uma imagem base para a fase de construção
FROM ubuntu:latest AS build

# Instalar atualizações e o JDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk wget tar

# Baixar e instalar o Maven
RUN wget https://archive.apache.org/dist/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.tar.gz
RUN tar -xvzf apache-maven-3.8.7-bin.tar.gz
RUN mv apache-maven-3.8.7 /opt/apache-maven
ENV M2_HOME=/opt/apache-maven
ENV PATH=${M2_HOME}/bin:${PATH}

WORKDIR /app

COPY . .

# Executar o Maven para construir o projeto, ignorando os testes
RUN mvn clean install -DskipTests

# Usar uma imagem mais leve do OpenJDK para a fase final
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Expor a porta da aplicação
EXPOSE 8080

# Copiar o arquivo JAR do estágio de construção para o estágio final
COPY --from=build /app/target/backendStoque-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
