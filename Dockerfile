FROM eclipse-temurin:latest AS Builder
WORKDIR /Fxbackend
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM eclipse-temurin:latest
ENV password=
COPY --from=Builder /Fxbackend/build/libs/*.jar Fxbackend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dadmin.password=$password", "/Fxbackend.jar"]