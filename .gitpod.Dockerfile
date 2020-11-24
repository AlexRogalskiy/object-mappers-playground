#!/bin/echo docker build . -f
# -*- coding: utf-8 -*-

FROM gitpod/workspace-full

LABEL maintainer="Alexander Rogalskiy <alexander.rogalsky@yandex.ru>"
LABEL organization="nullables.io"
LABEL io.nullables.api.playground.image.title="Nullables.io"
LABEL io.nullables.api.playground.image.description="Object Mappers Playground"
LABEL io.nullables.api.playground.image.vendor="Nullables.io"
LABEL io.nullables.api.playground.image.version="1.0.0"

ENV LC_ALL en_US.UTF-8
ENV LANG ${LC_ALL}

# Downloading and installing Maven
# Define a constant with the version of maven you want to install
ARG MAVEN_VERSION=3.6.3

# Define a constant with the working directory
ARG USER_HOME_DIR="/root"

# Define the SHA key to validate the maven download
ARG SHA=c35a1803a6e70a126e80b2b3ae33eed961f83ed74d18fcd16909b2d44d7dada3203f1ffe726c17ef8dcca2dcaa9fca676987befeadc9b9f759967a8cb77181c0

# Define the URL where maven can be downloaded from
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

# Disable coredump
RUN echo "Set disable_coredump false" >> /etc/sudo.conf

# Create the directories, download maven, validate the download, install it, remove downloaded file and set links
RUN sudo mkdir -p /usr/share/maven /usr/share/maven/ref \
  && echo "Downloading maven" \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  \
  && echo "Checking download hash" \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  \
  && echo "Unziping maven" \
  && sudo tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  \
  && echo "Cleaning and setting links" \
  && sudo rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Define environmental variables required by Maven, like Maven_Home directory and where the maven repo is located
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

USER gitpod

#RUN mvn -N io.takari:maven:wrapper -Dmaven=3.6.3
RUN chmod +x /usr/bin/mvn
