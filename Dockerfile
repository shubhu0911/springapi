
From openjdk:11
LABEL maintainer="shubham"
ADD target/restapi.jar spring-boot-docker.jar
ENTRYPOINT ["java", "-jar", "spring-boot-docker.jar"]
