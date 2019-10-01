package fi.iki.mkuokkanen.vertxproto;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.freemarker.FreeMarkerTemplateEngine;

import java.util.Objects;

public class RestVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        Router router = Router.router(vertx);

        FreeMarkerTemplateEngine engine = FreeMarkerTemplateEngine.create(vertx);

        router.get("/test/hello")
                .produces("text/plain")
                .handler(this::getHello);

        router.route(HttpMethod.GET, "/test/page")
                .produces("text/html")
                .handler(ctx -> {
                    JsonObject data = new JsonObject()
                            .put("user", "Matti");

                    engine.render(data, "templates/index.ftl", res -> {
                        if (res.succeeded()) {
                            ctx.response().end(res.result());
                        } else {
                            ctx.fail(res.cause());
                        }
                    });
                });

        router.get("/test/json")
                .produces("application/json")
                .handler(this::handleGetJson);

        vertx
                .createHttpServer()
                .requestHandler(router)
                .listen(8080);
    }

    private void getHello(RoutingContext routingContext) {
        routingContext.response()
                .putHeader("content-type", "text/plain")
                .end("hello world");
    }

    private void handleGetJson(RoutingContext ctx) {
        String name = ctx.request().getParam("name");
        String age = ctx.request().getParam("age");

        JsonObject person = new JsonObject()
                .put("name", Objects.isNull(name) ? "Matti" : name)
                .put("age", Objects.isNull(age) ? 36 : Integer.parseInt(age));

        ctx.response()
                .putHeader("content-type", "application/json")
                .end(person.encode());
    }
}
