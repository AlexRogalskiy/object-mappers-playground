FROM debian:9.5-slim

LABEL maintainer="Alexander Rogalskiy <alexander.rogalsky@yandex.ru>"
LABEL homepage="http://github.com/AlexRogalskiy"
LABEL repository="http://github.com/AlexRogalskiy/object-mappers-playground"
LABEL organization="nullables.io"

LABEL io.nullables.api.playground.image.title="Nullables.io"
LABEL io.nullables.api.playground.image.description="Object Mappers Playground"
LABEL io.nullables.api.playground.image.vendor="Nullables.io"
LABEL io.nullables.api.playground.image.version="1.0.0"

LABEL com.github.actions.name="GitHub arguments"
LABEL com.github.actions.description="Write arguments to the standard output"
LABEL com.github.actions.color="purple"

ADD entrypoint.sh /entrypoint.sh

RUN chmod 755 /entrypoint.sh

ENTRYPOINT [ "/entrypoint.sh" ]
CMD ["Github [ Args ] action started"]
