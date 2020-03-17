package fi.mkuokkanen.webproto.jersey;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JerseyServerTest extends Application {

    public static final String URL_PREFIX = "http://localhost:8080/test/";
    private static JerseyServer server;

    @BeforeClass
    public static void setUpClass() throws Exception {
        server = JerseyServer.buildStartedServer();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testRestResource() throws Exception {
        Client client = ClientBuilder.newClient();
        String val = client.target(URL_PREFIX + "hello")
                .request().get(String.class);
        Assert.assertEquals("hello world", val);
        client.close();
    }

    @Test
    public void testPageResource() throws Exception {
        Client client = ClientBuilder.newClient();
        String val = client.target(URL_PREFIX + "page")
                .request().get(String.class);
        assertThat(val, startsWith("Hello Matti!"));
        client.close();
    }

    @Test
    public void testJsonResource() throws Exception {
        Client client = ClientBuilder.newClient();
        PersonJaxb val = client
                .target(URL_PREFIX + "json")
                .queryParam("name", "Mikko")
                .queryParam("age", 15)
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(PersonJaxb.class);

        assertEquals(15, val.age);
        assertEquals("Mikko", val.name);
        client.close();
    }
}

