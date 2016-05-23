
## Introduction

Prototypes of different lightweigh rest api + page template solutions. 
They all implement almost indentical features.

### Useful maven commands for checking updates

```bash 
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```

### Building and running software

All software modules are build together from root `pom.xml` with `mvn clean install`. 
Maven uses Assembly plugin to build zip package 
with main artifact jar in root 
and dependency jars in subfolder `lib`.
Main artifact Manifest is wired to load classes from lib folder, 
so `java -jar daa.jar` is enough to run the software.

### Testing running software

```bash 
# Request plain text containing "hello world" as string
curl http://localhost:8080/test/hello

# Request HTML page containing "Hello Matti!" from FreeMarker template
curl http://localhost:8080/test/page

# Request JSON object
curl "http://localhost:8080/test/json?name=Mikko&age=20"

```

### Some stats

| Solution           | JAR size  |
|--------------------|-----------|
| grizzly-jersey     | 12 MB     | 
| undertow-resteasy  | 7.9 MB    |
| spark              | 2.8 MB    |
| vertx              | 5.9 MB    | 


## Prototypes

### Grizzly + Jersey

The Oracle Glassfish solution. 
Traditional approach. 
Jersey and Grizzly are both hosted at java.net, people work together?
EclipseLink Moxy has also roots in Oracle.

* Rest API by Jersey JAX-RS implementation.
* Server by Grizzly NIO software, Jersey provides wrapper for it. Jetty also supported.
* Template support by Freemarker, Jersey MVC provides support to it.
* JSON support by Moxy, as suggested by documentation.


```bash 
mvn clean install
cd grizzly-jersey/target/
unzip grizzly-jersey-0.0.1-SNAPSHOT-distribution.zip
cd grizzly-jersey-0.0.1-SNAPSHOT/
java -jar grizzly-jersey-0.0.1-SNAPSHOT.jar
```

### Undertow + RestEasy

The JBoss Wildfly solution. 
Traditional approach.
RestEasy and Undertow seem to be both JBoss projects, providing infra for WildFly app server.

* Rest API by RestEasy JAX-RS implementation.
* Server by Undertow NIO software. RestEasy provides wrapper for it.
* No template support, so build quick hack to implement FreeMarker.
* JSON support from Jettison, documentation seems to point to this direction. Jackson also option.

```bash 
mvn clean install
cd undertow-resteasy/target/
unzip undertow-resteasy-0.0.1-SNAPSHOT-distribution.zip
cd undertow-resteasy-0.0.1-SNAPSHOT/
java -jar undertow-resteasy-0.0.1-SNAPSHOT.jar
```

### Spark

Spark has its own compact syntax for declaring rest API. 
Seems to be core functionality with not much else.
I like it.
Spark embeds Jetty server software deep inside, it is not immediately visible to programmer

* Rest API by Sparks own syntax.
* Server by Jetty, but is not visible.
* Spark has support for FreeMarker.
* Spark does not have build in JSON support, but documentation suggests GSON.

```bash 
mvn clean install
cd spark/target/
unzip spark-0.0.1-SNAPSHOT-distribution.zip
cd spark-0.0.1-SNAPSHOT/
java -jar spark-0.0.1-SNAPSHOT.jar
```


### Vert.x

Vert.x is big project trying to push a (event driven and async?) paradigm.
Multiple different features, like CLI tool, own deployment mechanisms, different languages etc.

* Rest API by vertx routes.
* Server software by Netty, but it is not visible.
* Templates by Handlebars, which vertx has wrapper for.
* JSON support by vertx own implementation, it seems.

Something strange with mapping absolute URLs to page templates, a bug? 
Freemarker was found from GitHub source code, but no artifact in maven central.

```bash 
mvn clean install
cd spark/target/
unzip spark-0.0.1-SNAPSHOT-distribution.zip
cd spark-0.0.1-SNAPSHOT/
java -jar spark-0.0.1-SNAPSHOT.jar
```
