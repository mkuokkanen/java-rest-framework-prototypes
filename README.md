
Prototypes of different rest api + page template solutions. 
Idea would be that same software could create html page dynamically 
and then support the ajax calls it will make.

## Usefule maven commands

```bash 
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```

## Grizzly + Jersey

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

## Undertow + RestEasy

RestEasy does not support FreeMarker, Mustache or similar. So had to hack it together myself.

JavaScript corner of Undertow, undertow.js, might support something like that, but it is still prototype AFAIK.

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



## Jetty + Spark

Jetty is embedded deep, it is not visible to programmer

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



