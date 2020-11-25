#!/usr/bin/env bash
if [ ! -z "$TRAVIS_TAG" ]
then
    echo "on a tag -> set pom.xml <version> to $TRAVIS_TAG"
    mvn --settings ../.mvn/settings.xml org.codehaus.mojo:versions-maven-plugin:2.8.1:set -DnewVersion=$TRAVIS_TAG 1>/dev/null 2>/dev/null
else
    echo "not on a tag -> keep SNAPSHOT version in pom.xml"
fi

mvn clean deploy --settings ../.mvn/settings.xml -DskipTests=true -B -U
