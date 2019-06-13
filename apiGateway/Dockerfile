

FROM openjdk:11.0.3-jdk-stretch
ADD /target/apiGateway-0.0.1-SNAPSHOT.jar /app/music/apiGateway-0.0.1-SNAPSHOT.jar
WORKDIR app/music
ENTRYPOINT ["java","-jar","apiGateway-0.0.1-SNAPSHOT.jar"]

