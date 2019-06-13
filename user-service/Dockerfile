FROM openjdk:11.0.3-jdk-stretch
ADD /target/userservice-0.0.1-SNAPSHOT.jar /app/music/userservice-0.0.1-SNAPSHOT.jar
WORKDIR app/music
ENTRYPOINT ["java","-jar","userservice-0.0.1-SNAPSHOT.jar"]