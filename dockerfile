FROM maven:3.8.8-eclipse-temurin-17 as maven_build
LABEL authors="Evaldo"

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=maven_build /app/target/hexagonal-0.0.1-SNAPSHOT.jar ./hexagonal-ibm-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "hexagonal-ibm-0.0.1-SNAPSHOT.jar"]