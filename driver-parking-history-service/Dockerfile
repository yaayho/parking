# Argumento global
ARG NAME_APP=driver-parking-history-service

# Etapa de construcción
FROM eclipse-temurin:23-jdk-alpine AS builder

ARG NAME_APP

WORKDIR /app/$NAME_APP

# Copiar los archivos de configuración de Maven y construir las dependencias
COPY ./pom.xml /app
COPY ./$NAME_APP/pom.xml ./
COPY ./$NAME_APP/.mvn ./.mvn
COPY ./$NAME_APP/mvnw ./
RUN  ./mvnw clean package -Dmaven.test.skkp -Dmaven.main.skkp -Dspring-boot.repackage.skip && rm -r ./target/
#RUN  ./mvnw dependency:go-offline

# Copiar el código fuente y construir el paquete
COPY ./$NAME_APP/src ./src
RUN  ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:23-jre-alpine

ARG NAME_APP
WORKDIR /app/$NAME_APP

RUN mkdir ./logs

# Copiar el archivo .jar generado en la fase de construcción
COPY --from=builder /app/$NAME_APP/target/$NAME_APP-0.0.1-SNAPSHOT.jar .

# Exponer el puerto de la aplicación
EXPOSE 8011

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "driver-parking-history-service-0.0.1-SNAPSHOT.jar"]
