package fi.iki.mkuokkanen.undertowresteasy;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;

public class URServerTest extends Application {

    private static URServer server;

    @BeforeClass
    public static void setUpClass() throws Exception {
        server = new URServer();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testRestResource() throws Exception {
        Client client = ClientBuilder.newClient();
        String val = client.target("http://localhost:8080/context/app/test/basic")
            .request().get(String.class);
        Assert.assertEquals("hello world", val);
        client.close();
    }
}

