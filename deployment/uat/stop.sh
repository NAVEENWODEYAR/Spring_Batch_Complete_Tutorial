#!/bin/bash

# Set the Spring Boot application JAR file name (same as in start.sh)
JAR_FILE="JAVA_MAIL_SENDER.jar"

# Find the process ID (PID) of the running Java application based on the JAR file name
PID=$(ps aux | grep "$JAR_FILE" | grep -v grep | awk '{print $2}')

# If the PID is found, kill the process
if [ -n "$PID" ]; then
    echo "Stopping Spring Boot application with PID: $PID..."
    kill "$PID"
    echo "Application stopped."
else
    echo "No running application found for $JAR_FILE."
fi
