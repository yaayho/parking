#ARG NAME_APP=Users

FROM openjdk:21
#as builder
#ARG NAME_APP
#LABEL authors="jairz"


WORKDIR /app
#WORKDIR /app/$NAME_APP

COPY ./target/Users-0.0.1-SNAPSHOT.jar .
#COPY ./pom.xml /app
#COPY ./Users .
#COPY ./$NAME_APP/.mvn ./.mvn
#COPY ./$NAME_APP/mvnw .
#COPY ./$NAME_APP/pom.xml .

#RUN  ./mvnw clean package -DskipTests
#RUN  ./mvnw clean package -Dmaven.test.skkp -Dmaven.main.skkp -Dspring-boot.repackage.skip
#&& rm -r ./target/

#RUN ./mvnw dependency:go-offline
#COPY ./Users/src ./src

#RUN  ./mvnw clean package -DskipTests

#FROM  openjdk:21
#ARG NAME_APP

#WORKDIR /app

#RUN mkdir ./logs

#ARG TARGET_APP=/app/$NAME_APP/target
#COPY --from=builder $TARGET_APP/Users-0.0.1-SNAPSHOT.jar .
#ENV PORT 8000
#EXPOSE $PORT
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "Users-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java", "-jar", "./target/Users-0.0.1-SNAPSHOT.jar"]
#CMD ["java", "-jar", "Users-0.0.1-SNAPSHOT.jar"]