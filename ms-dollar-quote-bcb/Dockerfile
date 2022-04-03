FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/ms-dollar-quote-bcb-0.0.1-SNAPSHOT.jar ms-dollar-quote-bcb.jar
ENTRYPOINT ["java","-jar","/ms-dollar-quote-bcb.jar"]