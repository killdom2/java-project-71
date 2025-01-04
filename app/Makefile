.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.8

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean installDist

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

jsonJson:
	./build/install/app/bin/app --format json src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

jsonPlain:
		./build/install/app/bin/app --format plain src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

jsonStylish:
		./build/install/app/bin/app src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

yaml:
	./build/install/app/bin/app src/test/resources/fixtures/file1.yaml src/test/resources/fixtures/file2.yaml


build-run: build run

.PHONY: build