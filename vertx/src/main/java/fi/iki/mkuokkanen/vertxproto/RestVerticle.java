package fi.iki.mkuokkanen.vertxproto;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
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

        // not needed because body is not read here?
        //router.route().handler(BodyHandler.create());

        router.get("/test/hello")
            //.produces("text/plain")
            .handler(this::getHello);

        router.route(HttpMethod.GET, "/test/page")
            //.produces("text/html")
            .handler(this::getPage);

        router.route(HttpMethod.GET, "/test/page")
            .handler(templateHandler);

        router.get("/test/json")
            //.produces("application/json")
            .handler(this::handleGetJson);

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

    private void handleGetJson(RoutingContext ctx) {
        String name = ctx.request().getParam("name");
        int age = new Integer(ctx.request().getParam("age"));

        JsonObject person = new JsonObject()
            .put("name", name)
            .put("age", age);

        ctx.response()
            .putHeader("content-type", "application/json")
            .end(person.encode());
    }
}
