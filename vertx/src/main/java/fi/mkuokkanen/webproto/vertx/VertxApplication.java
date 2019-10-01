package fi.mkuokkanen.webproto.vertx;


import io.vertx.core.Vertx;

public class VertxApplication {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new RestVerticle());
    }
}
