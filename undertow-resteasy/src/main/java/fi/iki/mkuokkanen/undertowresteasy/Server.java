package fi.iki.mkuokkanen.undertowresteasy;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;

public class Server {

    private final UndertowJaxrsServer server;

    public Server() {
        server = new UndertowJaxrsServer();
        server.start(Undertow.builder().addHttpListener(8080, "0.0.0.0"));

        deployWithDescription();
        //deployStraight();
    }

    private void deployWithDescription() {
        DeploymentInfo di = server.undertowDeployment(JaxRsApp.class);
        di.setContextPath("/context")
            .setDeploymentName("DI");

        server.deploy(di);
    }

    private void deployStraight() {
        server.deploy(JaxRsApp.class);
    }

    public void stop() {
        server.stop();
    }
}
