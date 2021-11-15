FROM openjdk:17
EXPOSE 80
ADD target/Order-service-docker.jar Order-service-docker.jar
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} /Order-service-docker.jar
#COPY src/main/resources/secure-connect-inventory.zip /secure-connect-inventory.zip
ENTRYPOINT ["java","-jar","/Order-service-docker.jar"]
