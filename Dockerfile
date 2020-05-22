FROM openjdk:15-alpine
COPY target/*SNAPSHOT.jar /calculator_build.jar
ENTRYPOINT ["java", "-jar", "/calculator_build.jar"]
