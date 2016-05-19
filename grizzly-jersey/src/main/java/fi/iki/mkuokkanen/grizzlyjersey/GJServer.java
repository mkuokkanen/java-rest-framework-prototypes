package fi.iki.mkuokkanen.grizzlyjersey;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

public class GJServer {

    private final HttpServer webServer;

    private GJServer(HttpServer grizzlyServer) {
        this.webServer = grizzlyServer;
    }

    public static GJServer buildStartedServer() {

        final HttpServer grizzlyServer = GrizzlyHttpServerFactory.createHttpServer(
            getBaseURI(),
            new JaxRsApp(),
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
