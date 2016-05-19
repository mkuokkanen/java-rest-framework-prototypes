package fi.iki.mkuokkanen.undertowresteasy;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;

public class URServer {

    private final UndertowJaxrsServer server;

    public URServer() {
        Undertow.Builder builder = Undertow.builder()
            .addHttpListener(8080, "0.0.0.0");

        server = new UndertowJaxrsServer();
        server.start(builder);

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
