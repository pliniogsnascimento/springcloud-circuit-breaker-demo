FROM maven:3.9.5-amazoncorretto-21 AS build
RUN mkdir /app
WORKDIR /app

ADD . /app/
RUN mvn package -Dmaven.test.skip
RUN ls -ltr /app/target
ENTRYPOINT [ "/app/target/circuitbreaker.jar" ]