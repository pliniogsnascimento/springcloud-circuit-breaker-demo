FROM maven:3.9.5-amazoncorretto-21 AS build
RUN mkdir /app
WORKDIR /app

ADD . /app/
RUN mvn package -Dmaven.test.skip && \
    curl -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
ENTRYPOINT [ "java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/app/target/circuitbreaker.jar" ]