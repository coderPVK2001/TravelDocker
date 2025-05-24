FROM openjdk:17

COPY target/travel-app.jar  /usr/app/

WORKDIR /usr/app/

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "travel-app.jar"]