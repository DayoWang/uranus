#!/bin/bash
FROM java:8
#FROM hypriot/rpi-java
VOLUME /tmp
ADD uranus-discovery-server-1.0-SNAPSHOT.jar /opt/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS /opt/app.jar
