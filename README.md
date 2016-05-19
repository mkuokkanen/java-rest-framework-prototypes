
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
cd grizzly-jersey/
mvn clean install
cd target/
unzip grizzly-jersey-proto-0.0.1-SNAPSHOT-distribution.zip
cd grizzly-jersey-proto-0.0.1-SNAPSHOT/
java -jar grizzly-jersey-proto-0.0.1-SNAPSHOT.jar
```

Zip file size 6.6 MB.

## Undertow + RestEasy

```bash 
cd undertow-resteasy/
mvn clean install
cd target/
unzip undertow-resteasy-proto-0.0.1-SNAPSHOT-distribution.zip
cd undertow-resteasy-proto-0.0.1-SNAPSHOT/
java -jar undertow-resteasy-proto-0.0.1-SNAPSHOT.jar
```

Zip file size 6.4 MB.

RestEasy does not support FreeMarker, Mustache or similar. So had to hack it together myself.

JavaScript corner of Undertow might support something like that, but it is still prototype AFAIK.


