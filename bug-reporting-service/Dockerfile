FROM bellsoft/liberica-runtime-container:jdk-17-glibc
VOLUME [ "/tmp" ]
ARG JAR_FILE=target/bug-reporting-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} bug-reporting-service.jar
ENTRYPOINT [ "java", "-jar", "/bug-reporting-service.jar" ]