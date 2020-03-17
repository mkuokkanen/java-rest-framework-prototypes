# Java web framework prototypes

Simple Java web framework prototypes implementing 
rest endpoints,
json handling and 
html template rendering.

Tested frameworks are:

* DropWizard
* Helidon
* Jersey
* Pippo
* Quarkus
* RestEasy
* Spark
* Spincast
* Spring Boot
* Vert.x

Purpose is to investigate 
how stand alone app is made with given framework 
and what libraries it integrates.

Tested with Java 11.

## Summary of frameworks

| Framework | Rest syntax / lib | Latest release |
| --- | --- | --- |
| [DropWizard](https://www.dropwizard.io/) | (Jersey?) JAX-RS | [2020-02 (2.0.2)](https://github.com/dropwizard/dropwizard/releases) |
| [Helidon](https://helidon.io/) | (Jersey?) JAX-RS / Reactive | [2020-03 (1.4.3)](https://github.com/oracle/helidon/releases) |
| [Jersey](https://github.com/eclipse-ee4j/jersey) | JAX-RS | [2020-02 (2.30.1)](https://github.com/eclipse-ee4j/jersey/releases) |
| [Pippo](http://www.pippo.ro) | Pippo | [2018-12 (1.12.0)](https://github.com/pippo-java/pippo/releases) |
| [Quarkus](https://quarkus.io) | (RestEasy?) JAX-RS / Reactive | [2020-03 (1.3.0)](https://github.com/quarkusio/quarkus/releases) |
| [RestEasy](https://resteasy.github.io) | JAX-RS | [2020-03 (4.5.2)](https://resteasy.github.io) |
| [Spark](http://sparkjava.com) | Spark | [2019-05 (2.9.1)](http://sparkjava.com/news) |
| [Spincast](https://www.spincast.org) | Spincast | [2019-05 (1.14.1)](https://github.com/spincast/spincast-framework/releases) |
| [Spring Boot](https://spring.io/projects/spring-boot) | Spring MVC / Spring WebFlux | [2020-02 (2.2.5)](https://github.com/spring-projects/spring-boot/releases) |
| [Vert.x](https://vertx.io) | Vert.x | [2020-01 (3.8.5)](https://github.com/eclipse-vertx/vert.x/releases) |




## Useful maven commands for checking updates

```bash 
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```

## Building and running software

### Dropwizard

```bash 
mvn clean install
cd dropwizard
java -jar target/dropwizard-1.0.0-SNAPSHOT.jar server config.yml
```

### Helidon

```bash
mvn clean install
cd helidon
java -jar target/helidon.jar
```

### Jersey

```bash 
mvn clean install
cd jersey/target/
unzip jersey-1.0.0-SNAPSHOT-distribution.zip
java -jar jersey-1.0.0-SNAPSHOT/jersey-1.0.0-SNAPSHOT.jar
```

### Pippo

```bash
mvn clean install
cd pippo/target/
unzip pippo-1.0.0-SNAPSHOT-distribution.zip
java -jar pippo-1.0.0-SNAPSHOT/pippo-1.0.0-SNAPSHOT.jar
```

### Quarkus

```bash 
mvn clean install
cd quarkus
java -jar target/getting-started-1.0-SNAPSHOT-runner.jar
```

### RestEasy

```bash 
mvn clean install
cd resteasy/target/
unzip spark-1.0.0-SNAPSHOT-distribution.zip
java -jar spark-1.0.0-SNAPSHOT/spark-1.0.0-SNAPSHOT.jar
```

### spark

```bash 
mvn clean install
cd spark/target/
unzip resteasy-1.0.0-SNAPSHOT-distribution.zip
java -jar resteasy-1.0.0-SNAPSHOT/resteasy-1.0.0-SNAPSHOT.jar
```

### spincast

```bash
mvn clean install
cd spincast/target/
unzip spincast-1.0.0-SNAPSHOT-distribution.zip
java -jar spincast-1.0.0-SNAPSHOT/spincast-1.0.0-SNAPSHOT.jar
```

### spring boot

```bash
mvn clean install
cd springboot
java -jar target/springboot-1.0.0-SNAPSHOT.jar
```

### vertx

```bash 
mvn clean install
cd vertx/target/
unzip vertx-1.0.0-SNAPSHOT-distribution.zip
java -jar vertx-1.0.0-SNAPSHOT/vertx-1.0.0-SNAPSHOT.jar 
```

## Testing running software

```bash 
# Request plain text containing "hello world" as string
curl http://localhost:8080/test/hello

# Request HTML page containing "Hello Matti!" from FreeMarker template
curl http://localhost:8080/test/page

# Request JSON object
curl "http://localhost:8080/test/json?name=Mikko&age=20"
```

