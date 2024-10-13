# First stage: Build the application
FROM maven:3.9.9-amazoncorretto-21 AS build

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY src /app/src
COPY pom.xml /app

# Build the application
RUN mvn package

# Second stage: Run the application
FROM amazoncorretto:21

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/my-app-1.0-SNAPSHOT.jar myapp.jar

# Set environment variables
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

# Expose the port (uncomment if needed)
# EXPOSE 3000

# Set the entry point
ENTRYPOINT exec java $JAVA_OPTS -jar myapp.jar
