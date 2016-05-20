package fi.iki.mkuokkanen.vertxproto;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.TemplateHandler;
import io.vertx.ext.web.templ.HandlebarsTemplateEngine;
import io.vertx.ext.web.templ.TemplateEngine;

public class RestVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        // Create a router object.
        Router router = Router.router(vertx);

        TemplateEngine engine = HandlebarsTemplateEngine.create();
        TemplateHandler templateHandler = TemplateHandler.create(engine);

        router.get("/test/hello").handler(this::getHello);

        router.route("/test/page").handler(this::getPage);
        router.route("/test/page").handler(templateHandler);

        // Create the HTTP server and pass the "accept" method to the request handler.
        vertx
            .createHttpServer()
            .requestHandler(router::accept)
            .listen(
                config().getInteger("http.port", 8080),
                result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                }
            );
    }

    private void getHello(RoutingContext routingContext) {
        routingContext.response()
            .putHeader("content-type", "text/plain")
            .end("hello world");

    }

    private void getPage(RoutingContext routingContext) {
        routingContext.put("user", "Matti");
        routingContext.next();
    }
}
