#!/bin/bash

# Set the Java Home if needed (optional)
# export JAVA_HOME=/path/to/java

# Set the Spring Boot application JAR file location
JAR_FILE="JAVA_MAIL_SENDER.jar"

# Check if the JAR file exists
if [ ! -f "$JAR_FILE" ]; then
  echo "JAR file not found: $JAR_FILE"
  exit 1
fi

# Check if Java is installed
if ! command -v java &> /dev/null
then
    echo "Java could not be found, please install it."
    exit 1
fi

# Set the Spring profile to 'prod' by default, unless passed as an argument
PROFILE="${1:-prod}"

# Run the Spring Boot application
echo "Starting Spring Boot application with profile: $PROFILE..."
java -jar -Dspring.profiles.active=$PROFILE $JAR_FILE
