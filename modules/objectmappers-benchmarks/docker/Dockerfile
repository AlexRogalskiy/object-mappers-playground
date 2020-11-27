#!/bin/echo docker build . -f
# -*- coding: utf-8 -*-
# docker build -t container_tag --build-arg IMAGE_SOURCE=openjdk IMAGE_TAG=latest .

ARG IMAGE_SOURCE=openjdk
ARG IMAGE_TAG=latest

# Init container image
FROM ${IMAGE_SOURCE}:${IMAGE_TAG}

# Set container labels
LABEL org.opencontainers.image.title="ObjectMappers"
LABEL org.opencontainers.image.description="ObjectMappers Playground"
LABEL org.opencontainers.image.vendor="Nullables, Inc."
LABEL org.opencontainers.image.version="1.0.0"

# Set container maintainer
MAINTAINER Alexander Rogalskiy <alexander.rogalsky@yandex.ru>

# Init home directory
ENV STARTER_HOME=/opt/app

# Define jar file
ARG JAR_FILE

# Add the application's jar to the container
ADD ${JAR_FILE} ${STARTER_HOME}/benchmarks.jar
ADD ./entrypoint.sh ${STARTER_HOME}/entrypoint.sh

# Update script permissions
RUN chmod 755 ${STARTER_HOME}/entrypoint.sh

# Set working directory inside container
WORKDIR ${STARTER_HOME}

# Run script
ENTRYPOINT [ "./entrypoint.sh" ]
CMD ["ObjectMappers Benchmarks Playground started"]
