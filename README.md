### Hexlet tests and linter status:
[![hexlet-check](https://github.com/killdom2/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/killdom2/java-project-71/actions/workflows/hexlet-check.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/80edda2a75e4e0779a25/maintainability)](https://codeclimate.com/github/killdom2/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/80edda2a75e4e0779a25/test_coverage)](https://codeclimate.com/github/killdom2/java-project-71/test_coverage)
## Presentation
<a href="https://asciinema.org/a/aAp82nBnYD1o7aZh1XXir5O7C" target="_blank"><img src="https://asciinema.org/a/aAp82nBnYD1o7aZh1XXir5O7C.svg" /></a>

### Description
A small console program that compares two files json or yaml/yml and prints the result. The input parameters are the output format and the full or relative paths to the files being compared.
Supported formats:
- stylish (as default)
- plain
- json

##Example of use:
1. app file1.json file2.json
2. app -f plain file1.json file2.json
3. app --format json file1.json file2.json

Yaml files can also be used as input files.
