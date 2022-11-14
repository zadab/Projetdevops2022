FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD ./target/Achat-1.0.3-SNAPSHOT.jar Achat.jar
ENTRYPOINT ["java","-jar","/Achat.jar"]
