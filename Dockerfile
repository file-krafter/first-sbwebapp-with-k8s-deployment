# ----------------------
# 🏗️ Stage 1: Build Java WAR using Maven
# ----------------------
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Set working directory inside the container
WORKDIR /app

# Copy only the pom.xml to leverage Docker cache for dependencies
COPY pom.xml .

# Download all dependencies without building the project
RUN mvn dependency:go-offline

# Now copy the source code
COPY src ./src

# Build the WAR file, skipping tests
RUN mvn clean package -DskipTests

# ----------------------
# 🏁 Stage 2: Runtime Image using Distroless (secure, minimal)
# ----------------------
FROM gcr.io/distroless/java21-debian12:nonroot

# Set working directory
WORKDIR /app

# Expose the port your app listens on
EXPOSE 8080

# Copy the WAR file from the previous stage
COPY --from=builder /app/target/*.war app.war

# Run the WAR using distroless's java21
ENTRYPOINT ["java", "-jar", "app.war"]
