FROM java:8
VOLUME /tmp
ADD uranus-discovery-server-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar