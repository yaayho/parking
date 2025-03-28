# Argumento global
ARG NAME_APP=driver-parking-detail-service

# Etapa de construcción JAR
FROM eclipse-temurin:23-jdk-alpine AS jar-builder

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

# Etapa de construcción JRE
FROM eclipse-temurin:23-jdk-alpine AS jlink-builder

ARG NAME_APP
WORKDIR /app/$NAME_APP

RUN apk add --no-cache zip

COPY --from=jar-builder /app/$NAME_APP/target/$NAME_APP-0.0.1-SNAPSHOT.jar ./

RUN jar xf ./$NAME_APP-0.0.1-SNAPSHOT.jar && \
    zip -d ./$NAME_APP-0.0.1-SNAPSHOT.jar "module-info.class"
    #jar cf0 ./$NAME_APP-0.0.1-SNAPSHOT.jar META-INF/ BOOT-INF/ org/

#jdeps --ignore-missing-deps --class-path "BOOT-INF/lib/" --recursive .\driver-parking-history-service-0.0.1-SNAPSHOT.jar
RUN jdeps --ignore-missing-deps -q  \
    --recursive  \
    --multi-release 23  \
    --print-module-deps  \
    --class-path 'BOOT-INF/lib/*'  \
    ./$NAME_APP-0.0.1-SNAPSHOT.jar > modules.txt

RUN cat modules.txt

RUN jlink \
    --add-modules $(cat modules.txt) \
    --strip-debug \
    --no-man-pages \
    --no-header-files \
    --compress=2 \
    --output /custom-jre

# Etapa de ejecución
#FROM eclipse-temurin:23-jre-alpine
FROM alpine:latest

ARG NAME_APP
WORKDIR /app/$NAME_APP

# Copia JRE personalizado
COPY --from=jlink-builder /custom-jre /opt/jre
ENV PATH="/opt/jre/bin:$PATH"
ENV JAVA_HOME="/opt/jre"

# Copiar el archivo .jar generado en la fase de construcción
COPY --from=jar-builder /app/$NAME_APP/target/$NAME_APP-0.0.1-SNAPSHOT.jar .

RUN mkdir ./logs

# Exponer el puerto de la aplicación
EXPOSE 8012

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "driver-parking-detail-service-0.0.1-SNAPSHOT.jar"]
