# Use an official Java 21 image as the base
FROM eclipse-temurin:21-jdk

# Set the working directory to /app
WORKDIR /app

# Copy Maven wrapper files and pom.xml to leverage Docker cache
COPY mvnw pom.xml .
COPY .mvn .mvn

# Copy the entire project except ignored files (via .dockerignore)
COPY . .

# Grant execution permission to Maven wrapper
RUN chmod +x mvnw

# Build the application inside the container
RUN ./mvnw clean package -DskipTests

# Ensure the JAR file is available
RUN ls -l target/ezybank-0.0.1-SNAPSHOT.jar

# Expose the port that the application will use
EXPOSE 8180

# Run the application using the Java command
ENTRYPOINT ["java", "-jar", "/app/target/ezybank-0.0.1-SNAPSHOT.jar"]
