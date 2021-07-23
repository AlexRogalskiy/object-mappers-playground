FROM openjdk:latest

RUN apk --update add git openssh maven && \
    rm -rf /var/lib/apt/lists/* && \
    rm /var/cache/apk/*

ENV BOOT_SLEEP=0 \
    JAVA_OPTS=""

RUN addgroup -S test && adduser -S -G test test && \
	mkdir -p /test/clone && \
	chown -R test:test /test

USER test

WORKDIR /test

RUN git clone --depth=1 https://github.com/AlexRogalskiy/object-mappers-playground /test/clone && \
	cd /test/clone && \
	mvn clean package --file pom.xml --show-version --batch-mode --errors --lax-checksums -DskipTests=true -P"test-jar","dev" && \
	mv modules/objectmappers-benchmarks/.build/bin/io.nullables.api.playground.objectmappers.benchmarks/benchmarks.jar /test/ && \
	cd /test && rm -rf /test/clone && rm -rf ~/.m2

EXPOSE 8000

CMD sleep $BOOT_SLEEP && \
	java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar benchmarks.jar
