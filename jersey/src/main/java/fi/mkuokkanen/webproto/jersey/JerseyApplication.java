package fi.mkuokkanen.webproto.jersey;

public class JerseyApplication {

    public static void main(String[] args) {
        JerseyServer s = JerseyServer.buildStartedServer();
    }

}
