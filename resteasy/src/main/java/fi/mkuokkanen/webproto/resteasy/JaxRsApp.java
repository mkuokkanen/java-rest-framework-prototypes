package fi.mkuokkanen.webproto.resteasy;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//@ApplicationPath("/app")
public class JaxRsApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(JaxRsResource.class);
        return classes;
    }
}

