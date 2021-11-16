FROM openjdk:17
EXPOSE 80
ADD target/cassandra-0.0.1-SNAPSHOT.jar Order-service-docker-cassandra.jar
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} /Order-service-docker.jar
COPY src/main/resources/secure-connect-orderdb.zip /secure-connect-orderdb.zip
ENTRYPOINT ["java","-jar","/Order-service-docker-cassandra.jar"]
