# Build Stage

FROM amazoncorretto:17-alpine3.15-jdk as build
WORKDIR /build
RUN apk add curl maven=3.8.3-r0
RUN curl -s "https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.12.0/opentelemetry-javaagent.jar" -o opentelemetry-javaagent.jar
COPY pom.xml ./

ENV SPRING_MAIL_HOST=${SPRING_MAIL_HOST}

# Getting version info to build package

RUN mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.artifactId -q -DforceStdout > artifactId
RUN mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -q -DforceStdout > version

# Non Cacheable steps

COPY . .
RUN [ "mvn", "-Dspring.profiles.active=${ENV:dev}", "clean", "package" ]
RUN mv ./target/`cat artifactId`-`cat version`.jar ./application.jar

# Distribution Stage

FROM amazoncorretto:17-alpine3.15 as runner
WORKDIR /app
COPY --from=build /build/application.jar ./application.jar

# Add opentelemetry collector

COPY --from=build /build/opentelemetry-javaagent.jar ./opentelemetry-javaagent.jar
RUN apk add freetype fontconfig ttf-dejavu
CMD [ "java", "-Xms2048m", "-Xmx2560m", "-Dspring.profiles.active=${ENV:dev}", "-jar", "application.jar" ]
