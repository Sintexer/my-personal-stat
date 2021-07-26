#FROM gradle:7.1.1-jdk16 as build
#WORKDIR /app
#COPY . ./
#
#RUN gradle mps-app:bootJar
#RUN ls
#
#FROM openjdk:16.0.2-slim-buster
#COPY --from=build /app/build/libs/mps-backend.jar .

FROM openjdk:16.0.2-slim-buster
WORKDIR /app

COPY ./mps-app/build/libs/mps-backend.jar .