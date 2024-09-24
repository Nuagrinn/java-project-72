FROM gradle:8.5.0-jdk21

ENV PORT=7070

WORKDIR /app

COPY app/src src

ENV JAVA_OPTS "-Xmx512M -Xms512M"

COPY app/. .

RUN gradle installDist

CMD ./build/install/app/bin/app