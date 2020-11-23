# Selma

## Description

The main idea is to prohibit magic conversion and just automate all mappings without any side effects.
When mapping appears to be too complex, the developer should handle it by himself using custom mappings/interceptors.
The footprint of Selma should be as small as possible as we only depend on a JavaWriter and the JDK.
Selma tries to only use static compiled generated code without any reflection at runtime or pseudo-code written in string fields.
You can use composition to build a chain of mappers and inside a single mapper you can have global configuration that can be overwritten on a per method basis.
Annotation-based approach (APT) is used to generate end-to-end object mappings.

## Features

## Pros & Cons

### Pros

- object mappings generated at compile time
- user-friendly approach backed by annotations simplifies the notation of object property mappings
- mappers compositions with configurations provide possibility to reuse already defined object matchings (new method does not have to be provided for each mapping)

### Cons


## Use cases

## Links

- [**Official Site**](http://www.selma-java.org/)
- [**Official Repository**](https://github.com/xebia-france/selma)
- [**Java Selma Alternatives**](https://java.libhunt.com/selma-alternatives)
