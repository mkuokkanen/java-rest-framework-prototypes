package fi.mkuokkanen.webproto.dropwizard;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class DropwizardResource {

    private final String defaultName;
    private final Integer defaultAge;

    public DropwizardResource(String defaultName, Integer defaultAge) {
        this.defaultName = defaultName;
        this.defaultAge = defaultAge;
    }

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Timed
    public String getHello() {
        return "hello world";
    }

    @Path("/page")
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Timed
    public IndexView getPage() {
        return new IndexView(defaultName);
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public PersonJaxb getJson(@DefaultValue("Matti") @QueryParam("name") String name,
                              @DefaultValue("36") @QueryParam("age") int age) {
        return new PersonJaxb(name, age);
    }
}
