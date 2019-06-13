FROM openjdk:11.0.3-jdk-stretch
ADD /target/eureka-server-0.0.1-SNAPSHOT.jar /app/music/eureka-server-0.0.1-SNAPSHOT.jar
WORKDIR app/music
ENTRYPOINT ["java","-jar","eureka-server-0.0.1-SNAPSHOT.jar"]
