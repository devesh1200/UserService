FROM openjdk:17

COPY target/UserService.jar  /usr/app/

WORKDIR /usr/app/

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "UserService.jar"]