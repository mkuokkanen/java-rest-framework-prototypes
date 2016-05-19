package fi.iki.mkuokkanen.undertowresteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class JaxRsResource {

    @Path("/basic")
    @GET
    @Produces("text/plain")
    public String get() {
        return "hello world";
    }
}
