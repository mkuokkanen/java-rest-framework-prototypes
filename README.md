
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


## Prototypes

### Grizzly + Jersey

Jersey provides JAX-RS and FreeMarker template support. 
Also provides wrapper to Grizzly NIO server software.
Jersey people seem to do close collabaration with Grizzly people.

```bash 
mvn clean install
cd grizzly-jersey/target/
unzip grizzly-jersey-0.0.1-SNAPSHOT-distribution.zip
cd grizzly-jersey-0.0.1-SNAPSHOT/
java -jar grizzly-jersey-0.0.1-SNAPSHOT.jar
```

```bash 
curl http://localhost:8080/test/page
curl http://localhost:8080/test/hello
```

Zip file size 6.6 MB.

### Undertow + RestEasy

RestEasy provides JAX-RS and wrapper to Undertow NIO server software. RestEasy people seem to collaborate with Undertow people.

RestEasy does not support templating FreeMarker, Mustache or similar, so I had to hack it together myself. Solution could be more elegant. JavaScript corner of Undertow, undertow.js, might support FreeMarker, but it is still prototype AFAIK.

```bash 
mvn clean install
cd undertow-resteasy/target/
unzip undertow-resteasy-0.0.1-SNAPSHOT-distribution.zip
cd undertow-resteasy-0.0.1-SNAPSHOT/
java -jar undertow-resteasy-0.0.1-SNAPSHOT.jar
```

```bash 
curl http://localhost:8080/context/app/test/page
curl http://localhost:8080/context/app/test/hello
```

Zip file size 6.4 MB.



### Jetty + Spark

Spark is not JAX-RS compliant. The REST api declaration syntax is much more compact and cleaner.
I like it.
Spark embeds Jetty server software deep inside, it is not immediately visible to programmer

```bash 
mvn clean install
cd spark/target/
unzip spark-0.0.1-SNAPSHOT-distribution.zip
cd spark-0.0.1-SNAPSHOT/
java -jar spark-0.0.1-SNAPSHOT.jar
```

```bash 
curl http://localhost:8080/test/page
curl http://localhost:8080/test/hello
```

Zip file size 2.6 MB.

