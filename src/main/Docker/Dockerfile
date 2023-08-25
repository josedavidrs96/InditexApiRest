# Utiliza una imagen base de Java
FROM adoptopenjdk:11-jre-hotspot

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR de tu aplicación a la imagen
COPY target/nombre-de-tu-app.jar app.jar

# Expone el puerto en el que tu aplicación escucha
EXPOSE 8080

# Comando para ejecutar tu aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]
