#!/bin/bash

# Set the Java Home if needed (optional)
# export JAVA_HOME=/path/to/java

# Set the Spring Boot application JAR file location
JAR_FILE="JAVA_MAIL_SENDER.jar"

# If the JAR file is in a different location, specify the absolute path:
# JAR_FILE="/path/to/your/application/my-springboot-app.jar"

# Check if the JAR file exists
if [ ! -f "$JAR_FILE" ]; then
  echo "JAR file not found: $JAR_FILE"
  exit 1
fi

# Optionally, set the profile to run (e.g., 'prod', 'dev', etc.)
PROFILE="prod"

# Run the Spring Boot application
echo "Starting Spring Boot application with profile: $PROFILE..."
java -jar -Dspring.profiles.active=$PROFILE $JAR_FILE
