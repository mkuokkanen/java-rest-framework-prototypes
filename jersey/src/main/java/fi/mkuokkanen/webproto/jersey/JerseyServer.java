package fi.mkuokkanen.webproto.jersey;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class JerseyServer {

    private final HttpServer webServer;

    private JerseyServer(HttpServer grizzlyServer) {
        this.webServer = grizzlyServer;
    }

    public static JerseyServer buildStartedServer() {

        final HttpServer grizzlyServer = GrizzlyHttpServerFactory.createHttpServer(
                getBaseURI(),
                new JaxRsApp(),
                true
        );

        return new JerseyServer(grizzlyServer);
    }

    public void stop() {
        webServer.shutdownNow();
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8080).build();
    }

}
