# ObjectMappers

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
