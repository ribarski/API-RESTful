# Usar uma imagem base do JDK
FROM openjdk:17-jdk-slim

# Configurar diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven
COPY SaudeBemEstar/target/SaudeBemEstar-0.0.1-SNAPSHOT.jar app.jar

# Configurar porta (se necessário)
EXPOSE 8080

# Definir comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
