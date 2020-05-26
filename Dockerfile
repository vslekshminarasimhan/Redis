FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/AutoSc-OnWatch-1.0.0-SNAPSHOT.jar AutoSc-OnWatch.jar
COPY ${JAR_FILE} /mydir/AutoSc-OnWatch.jar
ENTRYPOINT ["java", "-jar", "/AutoSc-OnWatch.jar"]


