#!/usr/bin/env bash

set -x

# SIGTERM-handler
trap 'pkill java; exit 130' SIGINT
trap 'pkill java; exit 143' SIGTERM

# Java environment options
ENV JAVA_VM_OPTS="-Xms64m -Xmx1024m -XX:MaxRAMFraction=1 -noverify -XX:+AlwaysPreTouch -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=256m -XX:NativeMemoryTracking=summary -XX:+UseConcMarkSweepGC -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true -Dcom.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize=true"

exec java ${JAVA_VM_OPTS} ${JAVA_OPTS} -jar ./modules/objectmappers-benchmarks/.build/bin/io.nullables.playground.objectmappers.benchmarks/benchmarks.jar "$@"

wait $!
