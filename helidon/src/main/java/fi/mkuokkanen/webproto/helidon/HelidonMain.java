package fi.mkuokkanen.webproto.helidon;

import io.helidon.microprofile.server.Server;

import java.io.IOException;

public final class HelidonMain {

    private HelidonMain() {
    }

    public static void main(final String[] args) throws IOException {
        Server server = startServer();
    }

    static Server startServer() {
        return Server.create().start();
    }
}
