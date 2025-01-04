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
	./build/install/app/bin/app --format json src/main/resources/jsonFile1.json src/main/resources/jsonFile2.json

jsonPlain:
		./build/install/app/bin/app --format plain src/main/resources/jsonFile1.json src/main/resources/jsonFile2.json

jsonStylish:
		./build/install/app/bin/app src/main/resources/jsonFile1.json src/main/resources/jsonFile2.json

yaml:
	./build/install/app/bin/app -f stylish src/main/resources/yamlFile1.yaml src/main/resources/yamlFile2.yml


build-run: build run

.PHONY: build