FROM openjdk:15-alpine
ADD calculator.jar /calculator_build.jar
ENTRYPOINT ["java", "-jar", "/calculator.jar"]
