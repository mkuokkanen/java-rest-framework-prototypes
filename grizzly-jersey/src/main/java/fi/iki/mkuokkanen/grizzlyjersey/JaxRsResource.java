package fi.iki.mkuokkanen.grizzlyjersey;

import org.glassfish.jersey.server.mvc.Viewable;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
