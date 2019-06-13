FROM openjdk:11.0.3-jdk-stretch
ADD /target/MyMuzixApp-0.0.1-SNAPSHOT.jar /app/music/MyMuzixApp-0.0.1-SNAPSHOT.jar
WORKDIR app/music
ENTRYPOINT ["java","-jar","MyMuzixApp-0.0.1-SNAPSHOT.jar"]
