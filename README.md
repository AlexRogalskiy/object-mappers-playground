# ObjectMappers

![Build](https://github.com/AlexRogalskiy/objectmappers-playground/workflows/Build/badge.svg?branch=master&event=push)
![Create Release](https://github.com/AlexRogalskiy/objectmappers-playground/workflows/Release-draft/badge.svg?branch=master)
![Lines of code](https://img.shields.io/tokei/lines/github/AlexRogalskiy/objectmappers-playground)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/AlexRogalskiy/objectmappers-playground)
![GitHub closed issues](https://img.shields.io/github/issues-closed/AlexRogalskiy/objectmappers-playground)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/AlexRogalskiy/objectmappers-playground)
![Github All Contributors](https://img.shields.io/github/all-contributors/AlexRogalskiy/objectmappers-playground)
![GitHub repo size](https://img.shields.io/github/repo-size/AlexRogalskiy/objectmappers-playground)
![GitHub last commit](https://img.shields.io/github/last-commit/AlexRogalskiy/objectmappers-playground)
![GitHub](https://img.shields.io/github/license/AlexRogalskiy/objectmappers-playground)
![GitHub All Releases](https://img.shields.io/github/downloads/AlexRogalskiy/objectmappers-playground/total)
![GitHub language count](https://img.shields.io/github/languages/count/AlexRogalskiy/objectmappers-playground)
![GitHub search hit counter](https://img.shields.io/github/search/AlexRogalskiy/objectmappers-playground/goto)
![GitHub Repository branches](https://badgen.net/github/branches/AlexRogalskiy/objectmappers-playground)
![GitHub Repository dependents](https://badgen.net/github/dependents-repo/AlexRogalskiy/objectmappers-playground)
![Docker Automated build](https://img.shields.io/docker/automated/alexanderr/objectmappers-playground)
![Docker Pulls](https://img.shields.io/docker/pulls/alexanderr/objectmappers-playground)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=AlexRogalskiy_objectmappers-playground&metric=alert_status)](https://sonarcloud.io/dashboard?id=AlexRogalskiy_objectmappers-playground)
[![Run Status](https://api.shippable.com/projects/5fb2d6f4a4e0a80007cb1606/badge?branch=master)]()

## Summary

ObjectMappers playground is intended to provide various mapping operations on DTO objects while converting from source to target objects.

## Description

Playground can be used for processing and testing mapping operations in order to evaluate major available options on objects conversion.

## Compile

### For JDK 8

```shell script
mvn clean install -Pdev,assembly,non_module_java -DskipTests
```

### For JDK 11

```shell script
mvn clean install -Pdev,assembly,module_java -DskipTests
```
## Running

Execute the following command to start ObjectMappers application:

```shell script
run.bat <source_template>
```

## Usage

Choose one of the modules and add to your `pom.xml`

```xml
<dependency>
    <groupId>io.nullables.api.playground</groupId>
    <artifactId>objectmappers-parent</artifactId>
    <version>{lib.version}</version>
</dependency>
```

Bundle with all ObjectMappers dependencies:

- [**ObjectMappers All**](https://github.com/AlexRogalskiy/objectmappers-playground/tree/master/modules/objectmappers-all)  
  `objectmappers-all` - Library to work with ObjectMappers API.

ObjectMappers module dependencies:

- [**ObjectMappers MapStruct**](https://github.com/AlexRogalskiy/objectmappers-playground/tree/master/modules/objectmappers-mapstruct)  
  `objectmappers-mapstruct` - Library to work with MapStruct API.

- [**ObjectMappers ModelMapper**](https://github.com/AlexRogalskiy/objectmappers-playground/tree/master/modules/objectmappers-modelmapper)  
  `objectmappers-modelmapper` - Library to work with ModelMapper API.

- [**ObjectMappers Commons**](https://github.com/AlexRogalskiy/objectmappers-playground/tree/master/modules/objectmappers-commons)  
  `objectmappers-commons` - Library with utilities for common use cases.

- [**ObjectMappers TestFlow**](https://github.com/AlexRogalskiy/objectmappers-playground/tree/master/modules/objectmappers-testflow)  
  `objectmappers-testflow` - Library to work with TestFlow API.

- [**ObjectMappers IntegrationTests**](https://github.com/AlexRogalskiy/objectmappers-playground/tree/master/modules/objectmappers-it)  
  `objectmappers-it` - Library with utilities for integration test use cases.

## Version Store

[./pom.xml](https://github.com/AlexRogalskiy/objectmappers-playground/blob/master/pom.xml)

## Miscellaneous

  You can find more useful libs and examples on [wiki](https://github.com/AlexRogalskiy/objectmappers-playground/wiki)

## Authors

ObjectMappers is maintained by:

* [Alexander Rogalskiy](https://github.com/AlexRogalskiy) 

with community support please contact with us if you have some question or proposition.

## Team Tools

[![alt tag](http://pylonsproject.org/img/logo-jetbrains.png)](https://www.jetbrains.com/) 

ObjectMappers Team would like inform that JetBrains is helping by provided IDE to develop the application. Thanks to its support program for an Open Source projects!

[![alt tag](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/dashboard?id=org.schemaspy%3Aschemaspy)

ObjectMappers project is using SonarCloud for code quality. 
Thanks to SonarQube Team for free analysis solution for open source projects.

## License

ObjectMappers is distributed under LGPL version 3 or later, see COPYING.LESSER(LGPL) and COPYING(GPL).   
LGPLv3 is additional permissions on top of GPLv3.

![image](https://user-images.githubusercontent.com/19885116/48661948-6cf97e80-ea7a-11e8-97e7-b45332a13e49.png)
