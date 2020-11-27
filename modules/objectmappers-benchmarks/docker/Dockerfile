#!/bin/echo docker build . -f
# -*- coding: utf-8 -*-
# docker build -t container_tag --build-arg IMAGE_SOURCE=openjdk IMAGE_TAG=latest .

ARG IMAGE_SOURCE=openjdk
ARG IMAGE_TAG=latest

FROM ${IMAGE_SOURCE}:${IMAGE_TAG}

LABEL org.opencontainers.image.title="ObjectMappers"
LABEL org.opencontainers.image.description="ObjectMappers Playground"
LABEL org.opencontainers.image.vendor="Nullables, Inc."
LABEL org.opencontainers.image.version="1.0.0"

MAINTAINER Alexander Rogalskiy <alexander.rogalsky@yandex.ru>

ENV STARTER_HOME=/opt/app

# The application's jar file
ARG JAR_FILE

# Add the application's jar to the container
ADD ${JAR_FILE} ${STARTER_HOME}/benchmarks.jar
ADD ./entrypoint.sh ${STARTER_HOME}/entrypoint.sh

RUN chmod 755 ${STARTER_HOME}/entrypoint.sh

# Set workdir inside container
WORKDIR ${STARTER_HOME}

# Run microservice process.
ENTRYPOINT [ "./entrypoint.sh" ]
CMD ["ObjectMappers Benchmarks Playground started"]
