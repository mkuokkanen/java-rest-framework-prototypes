package fi.iki.mkuokkanen.grizzlyjersey;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

public class GJServer {

    private final HttpServer webServer;

    private GJServer(HttpServer grizzlyServer) {
        this.webServer = grizzlyServer;
    }

    public static GJServer buildStartedServer() {

        // ResourceConfig extends Jax-rs application class with extra features
        // Here we just use it as it is.
        ResourceConfig rc = ResourceConfig.forApplicationClass(JaxRsApp.class);

        final HttpServer grizzlyServer = GrizzlyHttpServerFactory.createHttpServer(
            getBaseURI(),
            rc,
            true
        );

        return new GJServer(grizzlyServer);
    }

    public void stop() {
        webServer.shutdownNow();
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8080).build();
    }

}
