FROM eclipse-temurin:21-jdk-jammy AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY mvnw /home/app
COPY .mvn /home/app/.mvn
RUN chmod +x /home/app/mvnw
WORKDIR /home/app
RUN ./mvnw clean package -DskipTests --no-transfer-progress
RUN rm -rf /root/.m2/repository

FROM eclipse-temurin:21-jre-jammy AS final
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /usr/local/lib/app.jar" ]