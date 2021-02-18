#!/bin/sh
./gradlew clean build
docker build -t currencies-api -f ./docker/Dockerfile .