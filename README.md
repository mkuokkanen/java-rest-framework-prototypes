# Java web framework prototypes

Simple Java web framework prototypes implementing 
rest endpoints, 
json handling and 
html template rendering.

Purpose is to investigate 
how stand alone app is made with given framework 
and what libraries it integrates.

Tested with Java 11.

## Prototyped frameworks

* Jersey + Grizzly + Moxy + Freemarker
* RestEasy + Undertow + Jackson + Freemarker
* Spark + Jetty + GSON + Freemarker
* Vert.x + Netty + Jackson + FreeMarker

## Useful maven commands for checking updates

```bash 
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```

## Building and running software

All software modules are build together from root `pom.xml` with `mvn clean install`. 
Maven uses Assembly plugin to build zip package 
with main artifact jar in root folder
and dependency jars in subfolder `lib`.
Main artifact Manifest is wired to load classes from lib folder, 
so `java -jar daa.jar` is enough to run the software.

```bash 
mvn clean install
cd <subfolder>/target/
unzip <something>-distribution.zip
cd <something>-1.0.0-SNAPSHOT/
java -jar <something>-1.0.0-SNAPSHOT.jar
```

### Testing running software

```bash 
# Request plain text containing "hello world" as string
curl http://localhost:8080/test/hello

# Request HTML page containing "Hello Matti!" from FreeMarker template
curl http://localhost:8080/test/page

# Request JSON object
curl "http://localhost:8080/test/json?name=Mikko&age=20"

```