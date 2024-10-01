.DEFAULT_GOAL := build-run

setup:
	gradlew wrapper --gradle-version 8.5

clean:
	gradlew clean

build:
	gradlew build


test:
	./gradlew test

report:
	gradle jacocoTestReport

lint:
	gradlew checkstyleMain

check-deps:
	gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build