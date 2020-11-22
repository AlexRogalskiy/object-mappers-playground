# ObjectMappers

![Lines of code](https://tokei.rs/b1/github/AlexRogalskiy/object-mappers-playground?category=lines)
![GitHub closed issues](https://img.shields.io/github/issues-closed/AlexRogalskiy/object-mappers-playground)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/AlexRogalskiy/object-mappers-playground)
![Github All Contributors](https://img.shields.io/github/all-contributors/AlexRogalskiy/object-mappers-playground)
![GitHub repo size](https://img.shields.io/github/repo-size/AlexRogalskiy/object-mappers-playground)
![GitHub last commit](https://img.shields.io/github/last-commit/AlexRogalskiy/object-mappers-playground)
![GitHub](https://img.shields.io/github/license/AlexRogalskiy/object-mappers-playground)
![GitHub language count](https://img.shields.io/github/languages/count/AlexRogalskiy/object-mappers-playground)
![GitHub search hit counter](https://img.shields.io/github/search/AlexRogalskiy/object-mappers-playground/goto)
![GitHub Repository branches](https://badgen.net/github/branches/AlexRogalskiy/object-mappers-playground)
![GitHub Repository dependents](https://badgen.net/github/dependents-repo/AlexRogalskiy/object-mappers-playground)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=AlexRogalskiy_object-mappers-playground&metric=alert_status)](https://sonarcloud.io/dashboard?id=AlexRogalskiy_object-mappers-playground)
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

- [**ObjectMappers All**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-all)  
  `objectmappers-all` - Library to work with ObjectMappers API.

ObjectMappers module dependencies:

- [**ObjectMappers Benchmarks**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-benchmarks)  
  `objectmappers-benchmarks` - Library with utilities for benchmarks use cases.

- [**ObjectMappers Bull**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-bull)  
  `objectmappers-bull` - Library to work with Bull API.

- [**ObjectMappers BeanCP**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-beancp)  
  `objectmappers-beancp` - Library to work with BeanCP API.

- [**ObjectMappers Commons**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-commons)  
  `objectmappers-commons` - Library with utilities for common use cases.

- [**ObjectMappers Datus**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-datus)  
  `objectmappers-datus` - Library to work with Datus API.

- [**ObjectMappers Dozer**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-dozer)  
  `objectmappers-dozer` - Library to work with Dozer API.

- [**ObjectMappers JMapper**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-jmapper)  
  `objectmappers-jmapper` - Library to work with JMapper API.

- [**ObjectMappers MapStruct**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-mapstruct)  
  `objectmappers-mapstruct` - Library to work with MapStruct API.

- [**ObjectMappers ModelMapper**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-modelmapper)  
  `objectmappers-modelmapper` - Library to work with ModelMapper API.

- [**ObjectMappers Moo**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-moo)  
  `objectmappers-moo` - Library to work with Moo API.

- [**ObjectMappers Nomin**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-nomin)  
  `objectmappers-nomin` - Library to work with Nomin API.

- [**ObjectMappers Orika**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-orika)  
  `objectmappers-orika` - Library to work with Orika API.

- [**ObjectMappers ReMap**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-remap)  
  `objectmappers-remap` - Library to work with ReMap API.

- [**ObjectMappers Selma**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-selma)  
  `objectmappers-selma` - Library to work with Selma API.

- [**ObjectMappers TestFlow**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-testflow)  
  `objectmappers-testflow` - Library to work with TestFlow API.

- [**ObjectMappers IntegrationTests**](https://github.com/AlexRogalskiy/object-mappers-playground/tree/master/modules/objectmappers-it)  
  `objectmappers-it` - Library with utilities for integration test use cases.

## Version Store

[./pom.xml](https://github.com/AlexRogalskiy/object-mappers-playground/blob/master/pom.xml)

## Miscellaneous

  You can find more useful libs and examples on [wiki](https://github.com/AlexRogalskiy/object-mappers-playground/wiki)

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

[![alt tag](https://app.shippable.com/app/assets/images/shippable-logo.png)](https://www.shippable.com/)

ObjectMappers project is using Shippable DevOps and CI automation tool.

[![Edit with Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/AlexRogalskiy/object-mappers-playground)

ObjectMappers has experimental support for Gitpod, a pre-configured development environment that runs in your browser. To use Gitpod, click the button below and sign in with GitHub. Gitpod also offers a browser add-on, though it is not required.

## License

ObjectMappers is distributed under LGPL version 3 or later, see COPYING.LESSER(LGPL) and COPYING(GPL).   
LGPLv3 is additional permissions on top of GPLv3.

![image](https://user-images.githubusercontent.com/19885116/48661948-6cf97e80-ea7a-11e8-97e7-b45332a13e49.png)

## Development support

Like *ObjectMappers* ? Consider buying me a coffee :)

[![Buy Me A Coffee](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/AlexRogalskiy)
