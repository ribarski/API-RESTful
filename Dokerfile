# Usar uma imagem base do JDK
FROM openjdk:17-jdk-slim

# Configurar diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven
COPY target/seu-projeto.jar app.jar

# Configurar porta (se necessário)
EXPOSE 8080

# Definir comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
