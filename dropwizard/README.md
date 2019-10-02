# DropWizard (Jetty, Jersey, Jackson, FreeMarker)

DropWizard is opinionated rich web framework
integrating multiple libraries
with some custom glue code.

* Rest configuration is JAR-RS from Jersey.
* Web server is Jersey.
* Json serialization is Jackson.
* Multiple templates, including FreeMarker.
* Lots of other features too.

Using maven shade plugin to assemble runnable jar as instructed by documentation.

Use `server config.yml` arguments to start app.

Needs 2.0 to support Java 11. No final release while writing this.

Documentation can be found here:
https://www.dropwizard.io/en/stable/manual/index.html
