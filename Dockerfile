# 1) Gradle 빌드 스테이지
FROM --platform=linux/amd64 gradle:8.4-jdk17-alpine AS build
WORKDIR /app

COPY build.gradle settings.gradle ./
RUN gradle dependencies --no-daemon

COPY . /app
RUN gradle clean build --no-daemon

# 2) Temurin 17 런타임 스테이지
FROM --platform=linux/amd64 eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/docker_clone.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","docker_clone.jar"]