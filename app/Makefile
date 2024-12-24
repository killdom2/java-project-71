.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.8

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/java-package/bin/java-package

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

checkstyleMain:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release

app:
	./build/install/app/bin/app -h

json:
	./build/install/app/bin/app src/main/resources/nestedFile1.json src/main/resources/nestedFile2.json -f stylish

yaml:
	./build/install/app/bin/app src/main/resources/nestedFile1.yaml src/main/resources/nestedFile2.yml -f stylish


build-run: build run

.PHONY: build