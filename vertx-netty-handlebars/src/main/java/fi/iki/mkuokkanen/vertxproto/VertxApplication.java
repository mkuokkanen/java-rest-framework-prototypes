package fi.iki.mkuokkanen.vertxproto;


import io.vertx.core.Vertx;

public class VertxApplication {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new RestVerticle());
    }
}
