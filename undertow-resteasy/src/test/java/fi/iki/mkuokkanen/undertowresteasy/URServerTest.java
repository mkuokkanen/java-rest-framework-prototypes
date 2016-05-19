package fi.iki.mkuokkanen.undertowresteasy;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;

import static org.hamcrest.CoreMatchers.startsWith;

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
        String val = client.target("http://localhost:8080/context/app/test/hello")
            .request().get(String.class);
        Assert.assertEquals("hello world", val);
        client.close();
    }

    @Test
    public void testPageResource() throws Exception {
        Client client = ClientBuilder.newClient();
        String val = client.target("http://localhost:8080/context/app/test/page")
            .request().get(String.class);
        Assert.assertThat(val, startsWith("Hello Matti!"));
        client.close();
    }
}

