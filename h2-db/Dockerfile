# Etapa de construcción JRE
FROM eclipse-temurin:23-jdk-alpine AS jlink-builder

WORKDIR /

#RUN jlink --module-path $JAVA_HOME/jmods \
#          --add-modules java.base,java.sql,java.logging \
#          --output custom-jre \
#          --compress=2 \
#          --no-header-files \
#          --no-man-pages \

#ARG MODULES_JAVA=java.base,java.sql,java.logging,java.management,java.naming,java.security.jgss,java.instrument,java.xml
ARG MODULES_JAVA=java.base,java.sql,java.logging
RUN jlink --module-path $JAVA_HOME/jmods \
          --add-modules $MODULES_JAVA \
          --output custom-jre \
          --compress=2 \
          --no-header-files \
          --no-man-pages

# Etapa de ejecución
FROM alpine:latest

# Directorio de trabajo
WORKDIR /opt/h2

ARG H2_VERSION=2.3.232
ENV PATH="/opt/jre/bin:$PATH" \
    JAVA_HOME="/opt/jre"

# Copiar JRE porsonalizado
COPY --from=jlink-builder /custom-jre $JAVA_HOME

# Crear usuario no root
#RUN mkdir -p ${H2_DATA} \
    #&& addgroup -S h2group && adduser -S h2user -G h2group \
    #&& chown h2user:h2group ${H2_DATA}

# Instalar dependencias
RUN apk add --no-cache --virtual .build-deps wget \
    && wget -q https://repo1.maven.org/maven2/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar -O /opt/h2/h2.jar \
    && apk del .build-deps

# Exponer puertos del servidor H2
ENV H2_TCP_PORT=9092 \
    H2_WEB_PORT=8082
EXPOSE $H2_TCP_PORT $H2_WEB_PORT

# Configurar volumen para persistencia de datos
VOLUME ["/opt/h2/data"]

ENV H2_DATA=/opt/h2/data \
    H2_PASSWORD="" \
    H2_DBS=test

# Script creación DB y ejecución h2
COPY entrypoint.sh .
#RUN sed -i 's/\r$//' entrypoint.sh
ENTRYPOINT ["/opt/h2/entrypoint.sh"]