.DEFAULT_GOAL := build

run-dist:
	@./build/install/app/bin/app

clean:
	@./gradlew clean

build:
	@./gradlew clean build installDist

lint:
	@./gradlew checkstyleMain

.PHONY: build