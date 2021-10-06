#Start Installing Java 11
FROM openjdk:11-slim as build

#Information about image
MAINTAINER pmedhekar

# Add jar
COPY target/AccountMS-0.0.1-SNAPSHOT.jar AccountMS-0.0.1-SNAPSHOT.jar

# Execute Application
ENTRYPOINT ["java", "-jar", "/AccountMS-0.0.1-SNAPSHOT.jar"]
