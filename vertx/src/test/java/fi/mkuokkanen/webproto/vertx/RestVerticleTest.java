package fi.mkuokkanen.webproto.vertx;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.ServerSocket;

@Ignore("Netty does not work with Java 11")
@RunWith(VertxUnitRunner.class)
public class RestVerticleTest {

    private Vertx vertx;

    private int port;

    @Before
    public void setUp(TestContext context) throws IOException {
        vertx = Vertx.vertx();

        ServerSocket socket = new ServerSocket(0);
        port = socket.getLocalPort();
        socket.close();

        DeploymentOptions options = new DeploymentOptions()
                .setConfig(new JsonObject().put("http.port", port)
                );

        vertx.deployVerticle(RestVerticle.class.getName(),
                options, context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void testGetHello(TestContext context) {
        final Async async = context.async();

        vertx.createHttpClient().getNow(port, "localhost", "/test/hello", response -> {
            response.handler(body -> {
                context.assertEquals("hello world", body.toString());
                async.complete();
            });
        });
    }

    @Test
    public void testGetPage(TestContext context) {
        final Async async = context.async();

        vertx.createHttpClient().getNow(port, "localhost", "/test/page", response -> {
            response.handler(body -> {
                context.assertTrue(body.toString().startsWith("Hello Matti!"));
                async.complete();
            });
        });
    }

    @Test
    public void testGetJson(TestContext context) {
        final Async async = context.async();

        vertx.createHttpClient().getNow(port, "localhost", "/test/json" + "?name=Daa&age=5", response -> {
            response.handler(body -> {

                JsonObject json = body.toJsonObject();

                context.assertEquals("Daa", json.getString("name"), "Name string did not match");
                context.assertEquals(5, json.getInteger("age"), "Age int did not match");

                async.complete();
            });
        });
    }
}
