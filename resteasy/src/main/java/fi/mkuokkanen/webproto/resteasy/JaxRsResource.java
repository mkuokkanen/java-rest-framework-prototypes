package fi.mkuokkanen.webproto.resteasy;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
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
    public String getPage() {
        final Map<String, Object> data = new HashMap<>();
        data.put("user", "Matti");
        data.put("foo", "bar");

        StringWriter writer = new StringWriter();

        Configuration cfg = FreeMarkerUtil.config();
        try {
            Template template = cfg.getTemplate("index.ftl");
            template.process(data, writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PersonJaxb getJson(@DefaultValue("Matti") @QueryParam("name") String name,
                              @DefaultValue("36") @QueryParam("age") int age) {
        return new PersonJaxb(name, age);
    }
}
