#!/bin/echo docker build . -f
# -*- coding: utf-8 -*-

FROM alpine

RUN apk add --no-cache imagemagick bash

COPY validate.sh /validate.sh

RUN chmod 755 /validate.sh

ENTRYPOINT [ "/validate.sh" ]
CMD ["Github [ Validate ] action started"]
