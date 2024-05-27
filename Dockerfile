# Use uma imagem base para a fase de construção
FROM ubuntu:latest AS build

# Instalar atualizações e o JDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Instalar o Maven
RUN apt-get install -y maven

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o código fonte para o contêiner
COPY . .

# Executar o Maven para construir o projeto
RUN mvn clean install

# Usar uma imagem mais leve do OpenJDK para a fase final
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Expor a porta da aplicação
EXPOSE 8080

# Copiar o arquivo JAR do estágio de construção para o estágio final
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
