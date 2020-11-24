FROM gitpod/workspace-full

USER gitpod

RUN mvn -N io.takari:maven:wrapper -Dmaven=3.6.3
RUN chmod +x ./mvnw
