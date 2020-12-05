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

# docker image build arguments for user/group configurations
ARG USER=localtest
ARG USER_ID=802
ARG USER_GROUP=tests
ARG USER_GROUP_ID=802
ARG USER_HOME=/home/${USER}

# create the user and group
RUN \
    groupadd --system --gid ${USER_GROUP_ID} ${USER_GROUP} \
    && useradd --system -s /bin/bash --home ${USER_HOME} --gid ${USER_GROUP_ID} --uid ${USER_ID} -m ${USER}

# Define jar file
ARG JAR_FILE

# Add the application's jar to the container
ADD ${JAR_FILE} ${STARTER_HOME}/benchmarks.jar
ADD ./modules/objectmappers-benchmarks/docker/entrypoint.sh ${STARTER_HOME}/entrypoint.sh

# Update script permissions
RUN chmod 755 ${STARTER_HOME}/entrypoint.sh

# Set current user
USER ${USER}
# Set working directory inside container
WORKDIR ${STARTER_HOME}

# Run script
ENTRYPOINT [ "./entrypoint.sh" ]
CMD ["ObjectMappers Benchmarks Playground started"]
