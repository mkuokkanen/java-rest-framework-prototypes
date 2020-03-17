package fi.mkuokkanen.webproto.helidon;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Path("/test")
@RequestScoped
public class RestEndpoint {

    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "hello world";
    }

    @Path("/page")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getPage() {
        // TODO
        return "TODO";
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@DefaultValue("Matti") @QueryParam("name") String name,
                            @DefaultValue("36") @QueryParam("age") int age) {
        JsonObject json = JSON.createObjectBuilder()
                .add("name", name)
                .add("age", age)
                .build();
        return Response.status(Response.Status.OK).entity(json).build();
    }
}
