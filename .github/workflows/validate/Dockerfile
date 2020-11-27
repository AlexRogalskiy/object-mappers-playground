#!/bin/echo docker build . -f
# -*- coding: utf-8 -*-

FROM alpine

RUN apk add --no-cache imagemagick bash

ENV STARTER_HOME=/opt/app

ADD ./.github/workflows/validate/validate.sh ${STARTER_HOME}/validate.sh

RUN chmod 755 ${STARTER_HOME}/validate.sh

WORKDIR ${STARTER_HOME}

ENTRYPOINT [ "./validate.sh" ]
CMD ["Github [ Validate ] action started"]
