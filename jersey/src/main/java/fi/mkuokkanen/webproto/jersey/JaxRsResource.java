package fi.mkuokkanen.webproto.jersey;

import org.glassfish.jersey.server.mvc.Viewable;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class JaxRsResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "hello world";
    }

    @Path("/page")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {
        final Map<String, Object> map = new HashMap<>();
        map.put("user", "Matti");
        map.put("foo", "bar");

        return new Viewable("/index.ftl", map);
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PersonJaxb getJson(@DefaultValue("Matti") @QueryParam("name") String name,
                              @DefaultValue("36") @QueryParam("age") int age) {
        return new PersonJaxb(name, age);
    }
}
