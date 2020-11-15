# OpenParser

## Summary

OpenParser application is intended to provide XML documents processing operations

## Description

Application can be used for parsing XML documents with possibility to store results in a database

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

Execute the following command to start OpenParser application:

```shell script
run.bat <source_template>
```

## Usage

Choose one of the modules and add to your `pom.xml`

```xml
<dependency>
    <groupId>ru.gkomega.api</groupId>
    <artifactId>openparser-parent</artifactId>
    <version>{lib.version}</version>
</dependency>
```

Bundle with all OpenParser dependencies:

- [**OpenParser All**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-all)  
  `openparser-all` - Library to work with OpenParser API.

OpenParser module dependencies:

- [**OpenParser Batch**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-batch)  
  `openparser-batch` - Library to work with Batch API.

- [**OpenParser Commons**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-commons)  
  `openparser-commons` - Library with utilities for common use cases.

- [**OpenParser Csv**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-csv)  
  `openparser-csv` - Library to work with Csv API.

- [**OpenParser Database**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-db)  
  `openparser-db` - Library to work with Database API.

- [**OpenParser Executor**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-executor)  
  `openparser-processor` - Library to work with Executor API.

- [**OpenParser File**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-file)  
  `openparser-file` - Library to work with File API.

- [**OpenParser Web**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-web)  
  `openparser-web` - Library to work with Web API.

- [**OpenParser Xml**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-xml)  
  `openparser-processor` - Library to work with Xml API.

- [**OpenParser Xstream**](https://github.com/AlexRogalskiy/openparser/tree/master/modules/openparser-xstream)  
  `openparser-xstream` - Library to work with XStream API.

## Version Store

[./pom.xml](https://github.com/AlexRogalskiy/openparser/blob/master/pom.xml)

## Miscellaneous

  You can find more useful libs and examples on [wiki](https://github.com/AlexRogalskiy/openparser/wiki)

## Authors

OpenParser is maintained by:

* [Alexander Rogalskiy](https://github.com/AlexRogalskiy) 

with community support please contact with us if you have some question or proposition.

## Team Tools

[![alt tag](http://pylonsproject.org/img/logo-jetbrains.png)](https://www.jetbrains.com/) 

OpenParser Team would like inform that JetBrains is helping by provided IDE to develop the application. Thanks to its support program for an Open Source projects!

[![alt tag](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/dashboard?id=org.schemaspy%3Aschemaspy)

OpenParser project is using SonarCloud for code quality. 
Thanks to SonarQube Team for free analysis solution for open source projects.

## License

OpenParser is distributed under LGPL version 3 or later, see COPYING.LESSER(LGPL) and COPYING(GPL).   
LGPLv3 is additional permissions on top of GPLv3.

![image](https://user-images.githubusercontent.com/19885116/48661948-6cf97e80-ea7a-11e8-97e7-b45332a13e49.png)
