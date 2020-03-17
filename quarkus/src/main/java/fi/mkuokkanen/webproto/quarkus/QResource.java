package fi.mkuokkanen.webproto.quarkus;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class QResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "hello world";
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getJson(@DefaultValue("Matti") @QueryParam("name") String name,
                          @DefaultValue("36") @QueryParam("age") int age) {
        return new Person(name, age);
    }
}
