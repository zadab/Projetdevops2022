FROM openjdk:11
EXPOSE 8089
ADD ./target/Achat-1.0.3-SNAPSHOT.jar Achat.jar
ENTRYPOINT ["java","-jar","/Achat.jar"]
