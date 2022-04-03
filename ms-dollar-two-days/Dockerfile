FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/ms-dollar-two-days-0.0.1-SNAPSHOT.jar ms-dollar-two-days.jar
ENTRYPOINT ["java","-jar","/ms-dollar-two-days.jar"]